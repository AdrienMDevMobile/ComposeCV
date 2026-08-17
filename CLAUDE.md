# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project

ComposeCV is a native Android app (Kotlin, Jetpack Compose) that presents a personal CV: welcome/about, experience, skills, and other (education/hobbies) sections behind bottom navigation. Application ID is `com.adrienmandroid.adrrienowner`, namespace `com.adrienmandroid.composecv`.

## Commands

Build with the Gradle wrapper from the repo root:

```
./gradlew assembleDebug            # debug build
./gradlew assembleRelease          # release build (minified, shrunk resources)
./gradlew test                     # JVM unit tests, all modules
./gradlew :app:testDebugUnitTest   # unit tests for a single module
./gradlew connectedAndroidTest     # instrumented/Compose UI tests (needs device/emulator)
./gradlew :feature:experience:ui:connectedAndroidTest   # instrumented tests for one module
./gradlew lint                     # Android lint across modules
```

There is no single-test CLI filter configured beyond Gradle's own `--tests` flag, e.g.:
`./gradlew :app:testDebugUnitTest --tests "*.DateDifferenceCalculatorTest"`.

Release builds run ProGuard/R8 (`isMinifyEnabled = true`, `isShrinkResources = true`, see `app/build.gradle.kts`). Preview/test-only data must never depend on debug-only resources (e.g. string resources scoped to `core:test`) — a past bug (`dbcd6c8`) was preview code depending on strings that only existed in a test-only module, which broke release compilation because that dependency isn't present in release. Prefer hardcoding preview/test fixture literals over pulling them from resource modules.

## Architecture

This is a Gradle multi-module project structured by **Clean Architecture** layers, further split by **feature**. Every feature module is composed of up to three Gradle modules:

- `feature/<name>/domain` — pure Kotlin/Android models and repository interfaces. Depends only on `core:model`.
- `feature/<name>/data` — repository implementations, local (Room) and remote (Retrofit) data sources, DTO↔domain converters. Depends on its own `domain` module plus `core:data`.
- `feature/<name>/ui` — Compose screens, ViewModels, `PreviewParameterProvider`s. Depends on its own `domain` module plus `core:ui`.

Features: `experience`, `skills`, `other`, `welcome`. There is also `app/feature/home`, which is not split into domain/data/ui.

`core` modules are shared, not feature-specific:
- `core:model` — cross-feature domain types (`Response<H, L>` result wrapper, `Dates`, `Link`, `BottomNavElement`, `TypographyEnum`).
- `core:data` — the generic offline-first data-loading machinery (see below), Retrofit setup, network connectivity interceptor.
- `core:ui` — shared Compose building blocks and the app theme (`core/ui/.../theme`), date/typography formatting extensions.
- `core:test` — shared test-only resources.

`app` is the composition root: it wires everything together via Hilt modules (`app/src/main/java/.../di/*Module.kt`, one `<Feature>DataModule` + one `<Feature>DomainModule` per feature binding data-source/repository interfaces to implementations), hosts `MainActivity`, the bottom-nav `NavGraph` (`navigation/BottomNavGraph.kt`), the Room `AppDatabase`, and `CVApplication` (Hilt entry point).

### Data flow pattern (offline-first)

Every feature repository follows the same shape, built on `ResponseLocalAndRemoteManager<H, L>` in `core:data`:

1. A feature defines `<Feature>LocalDataSource` and `<Feature>RemoteDataSource` interfaces (typically `BasicResponseLocalDataSource<T>` / `BasicResponseRemoteDataSource<T>` — the `H` type param is usually `Unit`).
2. `<Feature>RepositoryImpl` composes a `local` (Room-backed) and `remote` (Retrofit-backed) implementation into a `ResponseLocalAndRemoteManager`, and its `get()` just delegates to the manager.
3. `ResponseLocalAndRemoteManager.get()` streams from local storage; when local data resolves to `Response.Error`, it falls back to fetching remote data and persisting it locally, propagating `NoConnectivityException` as `Response.Error()`.
4. Everything downstream (`Response<H, L>`, a sealed success/error wrapper defined in `core:model`) is consumed by the feature's ViewModel and mapped to a `PageState`/UI state for Compose.

When adding a new data-backed feature, replicate this local/remote/manager triple rather than inventing a new pattern.

### Build-logic (convention plugins)

Module build files are thin because shared Gradle configuration lives in the included build `build-logic/convention` (`build-logic/convention/src/main/kotlin/*ConventionPlugin.kt`), exposed as plugin aliases in `gradle/libs.versions.toml` under `[plugins]` (`convention-application`, `convention-library`, `convention-compose-library`, `convention-hilt-library`, `convention-retrofit-core-library`, `convention-retrofit-api-library`, `convention-room-library`). A module opts into Compose, Hilt, Retrofit, or Room support purely by applying the matching convention plugin in its `build.gradle.kts` — check `build-logic/convention/src/main/kotlin/convention/` before touching SDK versions, Java/Kotlin compile options, or DI/network/DB setup, since those are centralized there rather than per-module.

Dependency versions and library coordinates are centralized in `gradle/libs.versions.toml` (version catalog) — add new libraries there rather than hardcoding versions in module `build.gradle.kts` files.

### Notable libraries

Jetpack Compose (BOM-managed), Coil 3 for image loading, Retrofit + kotlinx.serialization for networking, Room for local persistence, Hilt for DI, Accompanist Pager for carousels. Moshi and product flavors are present in history/comments but are considered obsolete (see commented-out code/dependencies) — don't reintroduce them without checking why they were removed.
