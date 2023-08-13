package com.example.kmp.whatsapp.presentation.android.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
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
import com.example.kmp.whatsapp.presentation.android.utils.AndroidFab
import com.example.kmp.whatsapp.presentation.android.utils.AndroidStatusItem
import com.example.kmp.whatsapp.presentation.android.utils.StatusContent
import com.example.kmp.whatsapp.presentation.android.utils.WhatsAppTabs
import com.seiko.imageloader.rememberImagePainter

@Composable
fun AndroidStatus(
    whatsAppTabs: WhatsAppTabs,
    statusList: MutableList<StatusContent>
) {
    Box(modifier = Modifier.fillMaxSize().background(chatBackgroundColor)) {
        LazyColumn(
            modifier = Modifier.background(color = chatBackgroundColor)
        ) {
            item {
                Column {
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(
                            start = 16.dp,
                            end = 16.dp,
                            top = 8.dp,
                            bottom = 8.dp
                        )
                    ) {
                        val painter =
                            rememberImagePainter("https://images.unsplash.com/photo-1529626455594-4ff0802cfb7e?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTh8fHJhbmRvbSUyMHBlb3BsZXxlbnwwfHwwfHx8MA%3D%3D&auto=format&fit=crop&w=800&q=60")
                        Box(
                            modifier = Modifier.padding(5.dp),
                            contentAlignment = Alignment.BottomEnd
                        ) {
                            Card(
                                colors = CardDefaults.cardColors(
                                    containerColor = Color.LightGray
                                ),
                                shape = CircleShape,
                            ) {
                                Image(
                                    painter = painter,
                                    contentDescription = "Profile",
                                    modifier = Modifier
                                        .size(39.dp)
                                        .clip(CircleShape)
                                )

                            }
                            Icon(
                                imageVector = Icons.Filled.Add,
                                contentDescription = "Add",
                                tint = Color.White,
                                modifier = Modifier
                                    .size(16.dp)
                                    .clip(CircleShape)
                                    .background(unReadsColor)
                                    .padding(2.dp)
                            )
                        }

                        Spacer(modifier = Modifier.width(8.dp))
                        Column {
                            Text(
                                "My Status",
                                color = textColor,
                                fontSize = 20.sp
                            )
                            Spacer(modifier = Modifier.height(5.dp))
                            Text(
                                "Tap to add status update",
                                color = topBarColor,
                                fontSize = 16.sp
                            )
                        }

                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        "Recent Updates",
                        color = topBarColor,
                        fontSize = 15.sp,
                        modifier = Modifier.padding(
                            start = 15.dp
                        )
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
            items(statusList){
                AndroidStatusItem(it)
            }
            item {
                Spacer(modifier = Modifier.height(8.dp))
                Divider(
                    Modifier.padding(start = 15.dp, end = 15.dp),
                    1.dp,
                    Color.LightGray.copy(alpha = 0.2f)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        "Your status updates are end-to-end encrypted",
                        color = unReadsColor,
                        fontSize = 12.sp
                    )
                }
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



