package com.example.composecomponentsplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.composecomponentsplayground.ui.theme.ComposeComponentsPLaygroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeComponentsPLaygroundTheme {}
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    ComposeComponentsPLaygroundTheme {}
}