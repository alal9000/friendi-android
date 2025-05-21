package com.example.friendi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.friendi.ui.FriendiApp
import com.example.friendi.ui.theme.FriendiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FriendiTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    FriendiApp()
                }
            }
        }
    }
}