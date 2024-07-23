package com.adrienmandroid.composecv.data.dataSource.impl

import com.adrienmandroid.composecv.data.Skill
import com.adrienmandroid.composecv.data.dataSource.SkillData

class SkillDataImpl : SkillData {

    override fun getSkills(): List<Skill> = listOf(
        Skill(
            name = "Android", targetValue = 0.8f, explanation = """
            La technologie qui <b>me plait le plus</b>.
            Je suis très content d'avoir quitté le développement Peoplesoft pour passer sur Android.
            Plus je travaille dessus, plus je vois que la route et longue, et continuera à s'étendre avec toutes les évolutions à venir.
            <b>Je suis impatient de voir ce que je vais apprendre sur Android demain</b>.
        """.trimIndent()
        ),
        Skill(
            name = "Kotlin", targetValue = 0.8f, explanation = """
            Une des raisons pour laquel Android est si plaisant à travailler est Kotlin.
            Cette technologie est <b>moderne</b>, et <b>incroyablement riche</b>. 
            Avec ce langage, y a toujours quelque chose à apprendre pour <b>optimiser</b> son code. En efficacité et en lisibilité.    
        """.trimIndent()
        ),
        Skill(
            name = "Mad skills",  subSkills = listOf("Growth mindset", "Capacité d'apprentissage"), explanation = """
                Growth mindset (état d’esprit de croissance) : Dire tout le monde peut évoluer, changer et progresser avec du travail et des efforts. .
                En contraste avec le "Fixed mindset" (état d'esprit fixe), qui voit les capacités comme innées et déterminées uniquement par le talent naturel.
                Connaitre ces deux concepts là est une chose, mais <b>avoir une mentalité de croissance est de réelement croire</b>, au fond de soi, en sa capacité d'évoluer.
                 <b>Cela ne s'apprend pas, cela s'experimente.</b> Par exemple, en réussissant un défi que l'on c'est fixé.
                 Personnellement, je l'ai experimenté grace à League of Legends, en atteignant le rang Or, au bout de nombreuses années. Me classant ainsi parmis les 30% meilleurs joueurs du jeu.
        """.trimIndent()
        ),
        Skill(
            name = "Jetpack UI", targetValue = 0.8f, explanation = """
            Constraint layout, Navigation drawers, Tabs, Recycler views, Layout et Data bindings, Nav graph.
            Tout cela permet <b>d'optimser le design</b>, simplifier le maintient du code et rendre une application qui respecte les demandes de la Direction Artistique <b>au pixel près</b>.
        """.trimIndent()
        ),
        Skill(
            name = "Structure MVVM", targetValue = 0.7f, explanation = """
            Une des difficultés les plus redoutées dans l'entrée du monde du travail est de travailler sur des projets déjà existants et incommensurément complexes.
            Les structures de développements aident à soulager cette difficulté.
            C'est pour cela que <b>je me tiens au courant des dernières évolutions</b> et me questionne toujours pour optimiser et adapter l'exisstant.
        """.trimIndent()
        ),
        Skill(
            name="Soft skills", subSkills = listOf("Curiosité", "Créativité"), explanation = """
                De nature curieuse, j'aime, et j'ai besoin, de comprendre les choses. Je n'hesite pas à poser des questions ou chercher les réponses.
            """.trimIndent()
        ),
        Skill(
            name = "Test Driven Development", targetValue = 0.5f, explanation = """
            Cela demande d'apprendre de nombreux outils de tests et de structurer son code pour ces derniers.
            Cela en vaut clairement le coup.
            Avoir son code validé tout au long de son développement est non seulement <b>rassurant</b>, mais surtout <b>très satisfaisant</b>. 
        """.trimIndent()
        ),
        Skill(
            name = "Hilt", targetValue = 0.7f, explanation = """
            Une révolution du développement que <b>j'adore</b>.
            L'injection de dépendances rend le code beaucoup <b>plus maintenable</b>, mais il y a toutefois un endroit où cela pique : quand ces dépendances doivent être injectées.
            Avec Hilt pas de soucis, <b>ces injections sont gérées de façon très lisible</b>.
            """.trimIndent()
        ),
        Skill(
            name = "Jetpack UI", targetValue = 0.8f, explanation = """
            Constraint layout, Navigation drawers, Tabs, Recycler views.
            Tout cela permet <b>d'optimser le design</b>, et rendre une application qui respecte les demandes de la Direction Artistique <b>au pixel près</b>.
        """.trimIndent()
        ),
        Skill(
            name = "Jetpack compose", targetValue = 0.7f, explanation = """
            Le dernier bébé de Google.
            Intrigué et curieux, j'ai évidemment <b>choisi de faire ce projet personnel avec Compose pour apprendre à l'utiliser</b>.
            Une révolution, un pas de plus vers des codes plus maintenables et compréhensibles. Après Compose, le XML n'a plus le même gout
        """.trimIndent()
        ),
        Skill(
            name = "Anglais", targetValue = 0.9f, explanation = """
            With my multiple travels in American speaking countries (and the time spent browsing internet), I am fluent in English.
            I have a slight French accent, but that gives it a charm doesn't it ?
        """.trimIndent()
        ),
        Skill(
            name = "Allemand", targetValue = 0.5f, explanation = """
            Ich habe Deutch in der Schule gelernt. 2022 möchte ich wieder Deutsch lernen.
            Ich spreche ein bissien deutch.
        """.trimIndent()
        )
        //Skill("Super skill3", 0.7f, "Texte skill 3"),
    )
}