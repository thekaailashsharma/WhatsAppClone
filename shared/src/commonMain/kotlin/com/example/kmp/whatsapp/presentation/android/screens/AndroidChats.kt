package com.example.kmp.whatsapp.presentation.android.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Archive
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kmp.whatsapp.presentation.android.ui.theme.chatBackgroundColor
import com.example.kmp.whatsapp.presentation.android.ui.theme.textColor
import com.example.kmp.whatsapp.presentation.android.ui.theme.unReadsColor
import com.example.kmp.whatsapp.presentation.android.utils.AndroidChatItem
import com.example.kmp.whatsapp.presentation.android.utils.AndroidFab
import com.example.kmp.whatsapp.presentation.android.utils.ChatContent
import com.example.kmp.whatsapp.presentation.android.utils.WhatsAppTabs

@Composable
fun AndroidChats(
    whatsAppTabs: WhatsAppTabs,
    chatList: MutableList<ChatContent>
) {
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier.background(color = chatBackgroundColor)
        ) {
            item {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(
                        start = 16.dp,
                        end = 16.dp,
                        top = 18.dp,
                        bottom = 8.dp
                    ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Filled.Archive,
                        tint = textColor,
                        contentDescription = "Archive",
                        modifier = Modifier.size(22.dp)
                    )
                    Spacer(modifier = Modifier.width(30.dp))
                    Text(
                        text = "Archived",
                        color = textColor,
                        fontSize = 20.sp
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(end = 10.dp),
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = (1..10).random().toString(),
                            color = unReadsColor,
                            fontSize = 15.sp
                        )
                    }
                }
            }
            items(chatList) {
                AndroidChatItem(it)
            }

        }
        Box(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            contentAlignment = Alignment.BottomEnd
        ) {
            AndroidFab(whatsAppTabs)
        }
    }
}

