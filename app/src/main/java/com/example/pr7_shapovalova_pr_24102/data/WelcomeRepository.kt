package com.example.pr7_shapovalova_pr_24102.data

import com.example.pr7_shapovalova_pr_24102.domain.WelcomeMessage


class WelcomeRepository {

    fun getWelcomeMessage(): WelcomeMessage {
        return WelcomeMessage(
            title = "GAAMETIIME",
            description = "Приложение для создания игр"
        )
    }
}