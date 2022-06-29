package com.example.mytetrisapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.mytetrisapplication.storage.AppPreference
import com.google.androidgamesdk.GameActivity
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    private var tvHighScore: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        val btnNewGame = findViewById<Button>(R.id.btn_new_game)
        val btnResetScore = findViewById<Button>(R.id.btn_reset_score)
        val btnExit = findViewById<Button>(R.id.btn_exit)
        tvHighScore = findViewById(R.id.tv_high_score)
        btnNewGame.setOnClickListener (this::onBtnNewGameClick)
        btnResetScore.setOnClickListener (this::onBtnResetScoreClick)
        btnExit.setOnClickListener (this::onBtnExitClick)
    }
    private fun onBtnNewGameClick(view: View) {
        val intent = Intent(this, GameActivity::class.java)
        startActivity(intent)
    }

    private fun onBtnResetScoreClick(view: View) {
        val preference = AppPreference(this)
        preference.clearHighScore()
    }

    private fun onBtnExitClick(view: View) {
        exitProcess(0)
    }
}