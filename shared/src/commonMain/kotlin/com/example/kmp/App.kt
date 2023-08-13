package com.example.kmp

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun HelloMultiPlatform() {
    var value by remember {
        mutableStateOf(0)
    }
    var isVisible by remember {
        mutableStateOf(false)
    }
    LaunchedEffect(key1 = Unit){
        delay(1000)
        isVisible = true
    }
    val coroutineScope = rememberCoroutineScope()
    Crossfade(targetState = value) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            AnimatedVisibility(
                isVisible,
                enter = slideInVertically() + fadeIn(),
                exit = slideOutVertically() + fadeOut()
            ) {
                Button(onClick = {
                    coroutineScope.launch {
                        isVisible = !isVisible
                        delay(500)
                        value++
                        isVisible = !isVisible
                    }
                }) {
                    Text("Click Me $value", color = Color.White)
                }
            }
        }
    }
}
