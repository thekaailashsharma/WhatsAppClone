package com.example.kmp.ui.theme

import androidx.compose.runtime.Composable

@Composable
expect fun WhatsAppTheme(
    darkTheme: Boolean,
    dynamicColor: Boolean,
    content: @Composable () -> Unit
)