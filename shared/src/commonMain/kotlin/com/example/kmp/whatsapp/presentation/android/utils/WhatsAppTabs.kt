package com.example.kmp.whatsapp.presentation.android.utils

sealed class WhatsAppTabs(var name: String) {
    object Chats : WhatsAppTabs("Chats")
    object Status : WhatsAppTabs("Status")
    object Calls : WhatsAppTabs("Calls")
}

