import convention.configureRoom
import org.gradle.api.Plugin
import org.gradle.api.Project

class LibraryRoomPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            configureRoom()
        }
    }
}