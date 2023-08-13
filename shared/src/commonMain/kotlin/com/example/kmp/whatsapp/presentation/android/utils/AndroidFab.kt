package com.example.kmp.whatsapp.presentation.android.utils

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCard
import androidx.compose.material.icons.filled.AddIcCall
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.kmp.whatsapp.presentation.android.ui.theme.topBarColor
import com.example.kmp.whatsapp.presentation.android.ui.theme.unReadsColor
import kotlinx.coroutines.delay

@Composable
fun AndroidFab(whatsAppTabs: WhatsAppTabs) {
    var isStatusVisible by remember {
        mutableStateOf(false)
    }
    LaunchedEffect(whatsAppTabs) {
        if (whatsAppTabs == WhatsAppTabs.Status) {
            delay(200)
            isStatusVisible = true
        } else {
            isStatusVisible = false
        }
    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AnimatedVisibility(
            visible = isStatusVisible,
        ) {
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = topBarColor
                ), shape = RoundedCornerShape(10.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Edit,
                    tint = Color.Black,
                    contentDescription = "Edit",
                    modifier = Modifier
                        .padding(12.dp)
                        .size(16.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Card(
            colors = CardDefaults.cardColors(
                containerColor = unReadsColor
            ), shape = RoundedCornerShape(7.dp)
        ) {
            when (whatsAppTabs) {
                WhatsAppTabs.Chats -> {
                    FabItem(
                        imageVector = Icons.Filled.Chat,
                        contentDescription = "Chat"
                    )
                }

                WhatsAppTabs.Status -> {
                    FabItem(
                        imageVector = Icons.Filled.PhotoCamera,
                        contentDescription = "Camera"
                    )
                }

                WhatsAppTabs.Calls -> {
                    FabItem(
                        imageVector = Icons.Filled.AddIcCall,
                        contentDescription = "Calls"
                    )
                }
            }

        }
    }
}

@Composable
fun FabItem(
    imageVector: ImageVector,
    contentDescription: String,
    modifier: Modifier = Modifier
) {
    Icon(
        imageVector = imageVector,
        tint = Color.Black,
        contentDescription = contentDescription,
        modifier = modifier
            .padding(15.dp)
            .size(22.dp)
    )
}


