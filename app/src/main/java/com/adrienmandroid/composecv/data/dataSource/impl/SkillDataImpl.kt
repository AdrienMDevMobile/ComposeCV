package com.adrienmandroid.composecv.data.dataSource.impl

import com.adrienmandroid.composecv.data.Skill
import com.adrienmandroid.composecv.data.dataSource.SkillData

class SkillDataImpl : SkillData {

    override fun getSkills(): List<Skill> = listOf(
        Skill("Android", 0.8f, """
            La technologie qui me plait le plus.
            Je suis très content d'avoir quitté le développement Peoplesoft pour passer sur Android.
            Plus je travaille dessus, plus je vois que la route et longue, et continuera à s'étendre avec toutes les évolutions à venir.
            Je suis impatient de voir ce que je vais apprendre demain.
        """),
        Skill("Kotlin", 0.8f, """
            Une des raisons pour laquel Android est si plaisant à travailler est Kotlin.
            Cette technologie est moderne, et incroyablement riche. 
            Avec ce langage, y a toujours quelque chose à apprendre pour optimiser son code. En efficacité et en lisibilité.    
        """),
        Skill("Structure MVVM", 0.7f, """
            Une des difficulté les plus redoutées dans l'entrée du monde du travail est de travailler sur des projets déjà existants et incommensurément complexes.
            Les structures de développements aident à soulager cette diffulté.
            C'est pour cela que je me tiens au courant des dernières évolutions et questionne toujours pour optimiser et adapter l'exisstant.
        """),
        Skill("Test Driven Development", 0.5f, """
            Cela demande d'apprendre de nombreux outils de tests et de structure son code pour ces derniers.
            Cela en vaut clairement le coup.
            Avoir son code validé tout au long de son développement est non seulement rassurant, mais surtout très satisfaisant. 
        """),
        Skill("Hilt", 0.7f, """
            Une révolution du développement que j'adore.
            L'injection de dépendance rend le code beaucoup plus maintenable, mais il y a bien un endroit o cela pique : quand ces dépendances doivent être injectées.
            Avec Hilt pas de soucis, ces injections sont gérées de façon très lisible."""),
        Skill("Jetpack UI", 0.8f, """
            Constraint layout, Navigation drawers, Tabs, Recycler views.
            Tout cela permet d'optimser le design, et rendre une application qui respecte les demandes de la Direction Artistique au pixel prêt.
        """),
        Skill("Jetpack compose", 0.7f, """
            Le dernier bébé de Google.
            Intrigué et curieux, j'ai évidemment travaillé sur ce projet personnel pour apprendre à l'utiliser.
            J'ai été un peu déçu.
            Compose est bien mieux que l'xml. Mais ne m'a pas décoiffé comme l'injection de dépendance et hilt l'ont fait.
        """),
        Skill("English", 0.9f, """
            With my multiple travels in American speaking countries (and the time spent browsing internet), I am fluent in English.
            I have a noticeable french accent, but that gives it a charm doesn't it ?
        """),
        Skill("German", 0.5f, """
            Ich habe Deutch in Schule gelernt. Im 2022, Ich möchte noch ein mal Deutch lernen.
            Ich sprechen ein bissien deutch.
        """.trimIndent())
        //Skill("Super skill3", 0.7f, "Texte skill 3"),

    )
}