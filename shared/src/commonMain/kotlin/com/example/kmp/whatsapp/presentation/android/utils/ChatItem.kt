package com.example.kmp.whatsapp.presentation.android.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.DoneAll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kmp.whatsapp.presentation.android.ui.theme.chatBackgroundColor
import com.example.kmp.whatsapp.presentation.android.ui.theme.textColor
import com.example.kmp.whatsapp.presentation.android.ui.theme.topBarColor
import com.example.kmp.whatsapp.presentation.android.ui.theme.unReadsColor
import com.seiko.imageloader.rememberImagePainter

@Composable
fun AndroidChatItem(chatContent: ChatContent) {
    val painter = rememberImagePainter(chatContent.image)
    Column(
        modifier = Modifier.background(chatBackgroundColor)
            .fillMaxWidth()
            .padding(
                start = 16.dp,
                end = 16.dp,
                top = 8.dp,
                bottom = 8.dp
            )
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color.LightGray
                ), shape = CircleShape
            ) {
                Image(
                    painter = painter,
                    contentDescription = "Profile",
                    modifier = Modifier
                        .size(39.dp)
                        .clip(CircleShape)
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    chatContent.name,
                    color = textColor,
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.height(5.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = if (chatContent.isSeen) Icons.Filled.DoneAll
                        else Icons.Filled.Done,
                        contentDescription = "Read",
                        tint = if (chatContent.isSeen) Color(0xFF34B7F1) else topBarColor,
                        modifier = Modifier
                            .size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        chatContent.message,
                        color = topBarColor,
                        fontSize = 16.sp
                    )
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        chatContent.time,
                        color = topBarColor,
                        fontSize = 14.sp
                    )
                    if (chatContent.unReads > 0) {
                        Spacer(modifier = Modifier.height(5.dp))
                        Card(
                            colors = CardDefaults.cardColors(
                                containerColor = unReadsColor
                            ), shape = CircleShape
                        ) {
                            Text(
                                chatContent.unReads.toString(),
                                color = Color.White,
                                fontSize = 12.sp,
                                modifier = Modifier.padding(
                                    start = 8.dp,
                                    end = 8.dp,
                                    top = 2.dp,
                                    bottom = 2.dp
                                )
                            )
                        }
                    }
                }
            }

        }

    }
}
