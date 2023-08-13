package com.example.kmp.whatsapp.presentation.iOS

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.kmp.ui.theme.WhatsAppTheme
import com.seiko.imageloader.rememberImagePainter
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@Composable
fun WhatsAppIOS(darkTheme: Boolean, dynamicColor: Boolean) {
    val painter = rememberImagePainter("https://blog.jetbrains.com/wp-content/uploads/2023/05/sampleapps-2800x1626.png")
    WhatsAppTheme(
        darkTheme = darkTheme,
        dynamicColor = dynamicColor
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
//            TopBarIOS()
            Image(
                painter = painter,
                contentDescription = "Profile",
                modifier = Modifier
                    .size(200.dp)
                    .clip(CircleShape)
            )
        }
    }
}