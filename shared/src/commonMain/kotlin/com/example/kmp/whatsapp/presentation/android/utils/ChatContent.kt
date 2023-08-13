package com.example.kmp.whatsapp.presentation.android.utils

data class ChatContent(
    val name: String,
    val message: String,
    val time: String,
    val isSeen: Boolean,
    val image: String,
    val unReads: Int
)

data class StatusContent(
    val image: String,
    val name: String,
    val time: String,
)

data class CallContent(
    val image: String,
    val name: String,
    val time: String,
    val callType: CallType
)

enum class CallType {
    OUTGOING,
    MISSED
}