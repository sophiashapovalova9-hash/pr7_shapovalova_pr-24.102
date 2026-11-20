package com.example.pr7_shapovalova_pr_24102.presentation

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.example.pr7_shapovalova_pr_24102.data.WelcomeRepository


class MainScreen(private val context: Context) {

    fun create(): View {
        val repository = WelcomeRepository()
        val message = repository.getWelcomeMessage()

        val layout = LinearLayout(context).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setBackgroundColor(Color.WHITE)
        }

        val title = TextView(context).apply {
            text = message.title
            textSize = 28f
            setTextColor(Color.rgb(255, 77, 112))
            gravity = Gravity.CENTER
        }

        val description = TextView(context).apply {
            text = message.description
            textSize = 16f
            setTextColor(Color.BLACK)
            gravity = Gravity.CENTER
        }

        layout.addView(title)
        layout.addView(description)

        return layout
    }
}