package com.example.kmp.whatsapp.presentation.android.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.kmp.ui.theme.isSystemInDarkTheme


val backGroundColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color(0xFF1a2c34) else Color(0xFF128C7E)


val textColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color(0xFFe7eff9) else Color(0xFF000000)

val topBarColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color(0xFF7e9199) else Color.LightGray

val chatBackgroundColor : Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color(0xFF0e1b22) else Color(0xFFFFFFFF)

val unReadsColor : Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color(0xFF00AC81) else Color(0xFF25D366)


val topBarChatColor : Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color(0xFF00AC81) else Color.White

