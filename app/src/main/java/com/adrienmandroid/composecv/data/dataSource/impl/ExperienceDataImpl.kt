package com.adrienmandroid.composecv.data.dataSource.impl

import com.adrienmandroid.composecv.R
import com.adrienmandroid.composecv.data.Dates
import com.adrienmandroid.composecv.data.Experience
import com.adrienmandroid.composecv.data.dataSource.ExperienceData
import java.util.*

class ExperienceDataImpl : ExperienceData {
    override fun getExperiences(): List<Experience> = listOf(
        Experience(
            name = "Ingénieur développement Android",
            employer = "Astek",
            logo = R.drawable.ic_exp_astek,
            ExpDates = Dates(begin = Date(1631052000000), end = null),
            informations = listOf(
                "Développement Android",
                "Utilisation de Git en équipe",
                "<b>Travail en équipe</b> avec iOS et le back end",
                "<b>Spécifications et chiffrages</b> des futurs développements.",
                "Respect du design donné par l'équipe DA, <b>au pixel prêt</b>",
                "Application des règles et normes d'écritures. Personnalisée par les développeurs Séniors ou recommandés par Google.",
                "Support, monitoring et analyses",
                "Layout binding et data binding",
                "Navigation graph"
            )
        ),
        Experience(
            name = "Projet personnel Jetpack compose",
            logo = R.drawable.ic_launcher,
            ExpDates = Dates(begin = Date(1645052400000), end = null),
            informations = listOf(
                "<b>Jetpack compose</b>",
                "Plurals",
                "Recherche sur la structure MVVM et recommandations Google",
                "Construction du design en collaboration avec des designers",
                "Canvas",
                "Flavors"
            )
        ),
        Experience(
            name = "Projet personnel Animateurs FDC",
            logo = R.drawable.ic_exp_fresque,
            ExpDates = Dates(begin = Date(1593554400000), end = Date(1641596400000)),
            informations = listOf(
                "Projet Android avec Kotlin.",
                "Réflexion avec d'autres Animateurs sur les fonctionnalités à développer.",
                "Écriture des <b>tests</b> unitaires et fonctionnels. <b>Junit4, Mockito, Espresso et UI automator</b>.",
                "Injection de dépendances (DI) : <b>Hilt</b>",
                "Utilisation de l'architecture <b>MVVM</b>.",
                "<b>Recherche des meilleures bibliothèques</b> pour les différentes fonctionnalités.",
                "Utilisation de Jetpack (test: Junit, Espresso. Threading. Fragment)"
            )
        ),
        Experience(
            name = "Ingénieur Développeur Peoplesoft",
            employer = "S&H group",
            logo = R.drawable.ic_exp_sh,
            ExpDates = Dates(begin = Date(1572562800000), end = Date(1590962400000)),
            informations = listOf(
                "Développement et mises à jour de pages du site de mobilité interne du client.",
                "<b>Spécifications et chiffrages</b> des futurs développements.",
                "Commentaires pour la compréhension et <b>maintenabilité du code</b>.",
                "Environnement technique : Peoplesoft, SQL.",
                "Mise en place de nouveaux outils et gain de temps sur de nombreux process."
            )
        ),
        Experience(
            name = "Développeur Peoplesoft en alternance",
            employer = "Natixis",
            logo = R.drawable.ic_exp_natixis,
            ExpDates = Dates(begin = Date(1472680800000), end = Date(1559340000000)),
            informations = listOf(
                "Développement en autonomie et en équipe.",
                "<b>Analyse des besoins utilisateurs</b> en prenant en compte <b>obligations</b> et <b>contraintes</b>.",
                "Écriture des Tests d'essai."
            )
        )
    )
}