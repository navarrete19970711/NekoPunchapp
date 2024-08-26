package com.example.nekopunchapp

import android.os.Bundle
import android.view.MotionEvent
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    // 1) 画面タッチ
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val iv:ImageView = findViewById(R.id.iv)

        // 条件分岐
        when(event?.action){
            MotionEvent.ACTION_DOWN -> iv.setImageResource(R.drawable.cat02)
            MotionEvent.ACTION_MOVE -> iv.setImageResource(R.drawable.cat03)
            MotionEvent.ACTION_UP   -> iv.setImageResource(R.drawable.cat01)
        }

        return super.onTouchEvent(event)
    }

}