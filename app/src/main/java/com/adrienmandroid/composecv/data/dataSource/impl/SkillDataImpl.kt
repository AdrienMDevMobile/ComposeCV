package com.adrienmandroid.composecv.data.dataSource.impl

import com.adrienmandroid.composecv.data.Skill
import com.adrienmandroid.composecv.data.dataSource.SkillData

class SkillDataImpl : SkillData {

    override fun getSkills(): List<Skill> = listOf(
        Skill("Android", 0.8f, """
            La technologie qui <b>me plait le plus</b>.
            Je suis très content d'avoir quitté le développement Peoplesoft pour passer sur Android.
            Plus je travaille dessus, plus je vois que la route et longue, et continuera à s'étendre avec toutes les évolutions à venir.
            <b>Je suis impatient de voir ce que je vais apprendre sur Android demain</b>.
        """.trimIndent()),
        Skill("Kotlin", 0.8f, """
            Une des raisons pour laquel Android est si plaisant à travailler est Kotlin.
            Cette technologie est <b>moderne</b>, et <b>incroyablement riche</b>. 
            Avec ce langage, y a toujours quelque chose à apprendre pour <b>optimiser</b> son code. En efficacité et en lisibilité.    
        """.trimIndent()),
        Skill("Structure MVVM", 0.7f, """
            Une des difficultés les plus redoutées dans l'entrée du monde du travail est de travailler sur des projets déjà existants et incommensurément complexes.
            Les structures de développements aident à soulager cette difficulté.
            C'est pour cela que <b>je me tiens au courant des dernières évolutions</b> et me questionne toujours pour optimiser et adapter l'exisstant.
        """.trimIndent()),
        Skill("Test Driven Development", 0.5f, """
            Cela demande d'apprendre de nombreux outils de tests et de structurer son code pour ces derniers.
            Cela en vaut clairement le coup.
            Avoir son code validé tout au long de son développement est non seulement <b>rassurant</b>, mais surtout <b>très satisfaisant</b>. 
        """.trimIndent()),
        Skill("Hilt", 0.7f, """
            Une révolution du développement que <b>j'adore</b>.
            L'injection de dépendances rend le code beaucoup <b>plus maintenable</b>, mais il y a bien un endroit où cela pique : quand ces dépendances doivent être injectées.
            Avec Hilt pas de soucis, <b>ces injections sont gérées de façon très lisible</b>.
            """.trimIndent()),
        Skill("Jetpack UI", 0.8f, """
            Constraint layout, Navigation drawers, Tabs, Recycler views.
            Tout cela permet <b>d'optimser le design</b>, et rendre une application qui respecte les demandes de la Direction Artistique <b>au pixel près</b>.
        """.trimIndent()),
        Skill("Jetpack compose", 0.7f, """
            Le dernier bébé de Google.
            Intrigué et curieux, j'ai évidemment <b>choisi de faire ce projet personnel avec Compose pour apprendre à l'utiliser</b>.
            J'ai été un peu déçu.
            Compose est bien mieux que l'xml. Mais ne m'a pas décoiffé comme l'injection de dépendance et Hilt l'ont fait.
        """.trimIndent()),
        Skill("Anglais", 0.9f, """
            With my multiple travels in American speaking countries (and the time spent browsing internet), I am fluent in English.
            I have a slight French accent, but that gives it a charm doesn't it ?
        """.trimIndent()),
        Skill("Allemand", 0.5f, """
            Ich habe Deutch in der Schule gelernt. 2022 möchte ich wieder Deutsch lernen.
            Ich spreche ein bissien deutch.
        """.trimIndent())
        //Skill("Super skill3", 0.7f, "Texte skill 3"),
    )
}