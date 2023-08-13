package com.example.kmp

import androidx.compose.ui.window.ComposeUIViewController
import com.example.kmp.whatsapp.presentation.android.WhatsAppAndroid
import com.example.kmp.whatsapp.presentation.iOS.WhatsAppIOS
import platform.UIKit.UIScreen
import platform.UIKit.UIUserInterfaceStyle

fun MainViewController()  = ComposeUIViewController {
    WhatsAppAndroid()
}