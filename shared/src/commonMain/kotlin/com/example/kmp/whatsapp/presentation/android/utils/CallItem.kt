package com.example.kmp.whatsapp.presentation.android.utils

import androidx.compose.foundation.Image
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
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.CallMade
import androidx.compose.material.icons.filled.CallReceived
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
import com.example.kmp.whatsapp.presentation.android.ui.theme.textColor
import com.example.kmp.whatsapp.presentation.android.ui.theme.topBarColor
import com.example.kmp.whatsapp.presentation.android.ui.theme.unReadsColor
import com.seiko.imageloader.rememberImagePainter

@Composable
fun AndroidCallItem(callContent: CallContent) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(
            start = 16.dp,
            end = 16.dp,
            top = 8.dp,
            bottom = 8.dp
        )
    ) {
        val painter =
            rememberImagePainter(callContent.image)
        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color.LightGray
            ), shape = CircleShape,
            modifier = Modifier.dashedBorder(
                strokeWidth = 4.dp,
                color = unReadsColor,
                cornerRadiusDp = 16.dp
            )
        ) {
            Image(
                painter = painter,
                contentDescription = "Profile",
                modifier = Modifier
                    .size(39.dp)
                    .clip(CircleShape)
            )
        }
        Spacer(modifier = Modifier.width(18.dp))
        Column {
            Text(
                callContent.name,
                color = if (callContent.callType == CallType.MISSED) Color.Red else textColor,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(5.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = if (callContent.callType == CallType.OUTGOING)
                        Icons.Filled.CallMade else
                        Icons.Filled.CallReceived,
                    contentDescription = "Call",
                    tint = if (callContent.callType == CallType.MISSED) Color.Red.copy(0.7f) else topBarColor,
                    modifier = Modifier
                        .size(10.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    callContent.time,
                    color = if (callContent.callType == CallType.MISSED) Color.Red.copy(0.7f) else topBarColor,
                    fontSize = 16.sp
                )
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Icon(
                imageVector = Icons.Filled.Call,
                contentDescription = "Call",
                tint = unReadsColor,
                modifier = Modifier
                    .size(24.dp)
            )
        }
    }
}