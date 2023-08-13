package com.example.kmp.whatsapp.presentation.iOS

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Camera
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TopBarIOS() {
    Column(
        modifier = Modifier.fillMaxWidth()
            .background(Color.White)
            .padding(start = 16.dp, end = 16.dp, top = 15.dp, bottom = 8.dp)
    ) {
        Text(
            text = "Edit",
            color = Color(0xFF178aff),
            fontSize = 13.sp
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Icon(
                imageVector = Icons.Filled.Camera,
                contentDescription = "Camera",
                tint = Color(0xFF178aff),
                modifier = Modifier.size(24.dp)
            )

            Spacer(Modifier.width(10.dp))

            Icon(
                imageVector = Icons.Filled.Edit,
                contentDescription = "Edit",
                tint = Color(0xFF178aff),
                modifier = Modifier.size(24.dp)
            )
        }
    }
}