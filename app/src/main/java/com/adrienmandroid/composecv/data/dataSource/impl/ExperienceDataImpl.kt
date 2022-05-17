package com.adrienmandroid.composecv.data.dataSource.impl

import com.adrienmandroid.composecv.R
import com.adrienmandroid.composecv.data.ExpDates
import com.adrienmandroid.composecv.data.Experience
import com.adrienmandroid.composecv.data.dataSource.ExperienceData
import java.util.*

class ExperienceDataImpl : ExperienceData {
    override fun getExperiences(): List<Experience> = listOf(
        Experience(
            name = "Ingénieur développement Android",
            logo = R.drawable.home,
            ExpDates = ExpDates(Date(1631052000000), Date()),
            informations = listOf("Info3", "Info4", "Info5")
        ),
        Experience(
            name = "Projet personnel Jetpack compose",
            logo = R.drawable.home,
            ExpDates = ExpDates(Date(1645052400000), Date()),
            informations = listOf("Jetpack compose")
        ),
        Experience(
            name = "Projet personnel Animateurs FDC",
            logo = R.drawable.home,
            ExpDates = ExpDates(Date(1593554400000), Date(1641596400000)),
            informations = listOf(
                "Projet Android avec Kotlin.",
                "Réflexion avec d'autres Animateurs sur les fonctionnalités à développer.",
                "Écriture des tests unitaires et fonctionnels. Junit4, Mockito, Espresso et UI automator.",
                "Injection de dépendances (DI) : Hilt",
                "Utilisation de l'architecture MVVM.",
                "Recherche des meilleures bibliothèques pour les différentes fonctionnalités.",
                "Utilisation de Jetpack (test: Junit, Espresso. Threading. Fragment)"
            )
        ),
        Experience(
            name = "Ingénieur Développeur Peoplesoft",
            logo = R.drawable.home,
            ExpDates = ExpDates(Date(1572562800000), Date(1590962400000)),
            informations = listOf(
                "Développement et mises à jour de pages du site de mobilité interne du client.",
                "Spécifications et chiffrages des futurs développements.",
                "Commentaires pour la compréhension et maintenabilité du code.",
                "Environnement technique : Peoplesoft, SQL.",
                "Mise en place de nouveaux outils et gain de temps sur de nombreux process."
            )
        ),
        Experience(
            name = "Développeur Peoplesoft en alternance",
            logo = R.drawable.home,
            ExpDates = ExpDates(Date(1472680800000), Date(1559340000000)),
            informations = listOf(
                "Développement en autonomie et en équipe.",
                "Analyse des besoins utilisateurs en prenant en compte obligations et contraintes.",
                "Écriture des Tests d'essai."
            )
        ),
        Experience(
            name = "S&H",
            logo = R.drawable.home,
            ExpDates = ExpDates(Date(), Date()),
            informations = listOf("Info3", "Info4", "Info8")
        ),
        Experience(
            name = "S&H",
            logo = R.drawable.home,
            ExpDates = ExpDates(Date(), Date()),
            informations = listOf("Info3", "Info4", "Info9")
        ),
        Experience(
            name = "S&H",
            logo = R.drawable.home,
            ExpDates = ExpDates(Date(), Date()),
            informations = listOf("Info3", "Info4", "Info10")
        )
    )
}