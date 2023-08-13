package com.example.kmp.whatsapp.presentation.android.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kmp.whatsapp.presentation.android.ui.theme.textColor
import com.example.kmp.whatsapp.presentation.android.ui.theme.topBarColor
import com.example.kmp.whatsapp.presentation.android.ui.theme.unReadsColor
import com.seiko.imageloader.rememberImagePainter

@Composable
fun AndroidStatusItem(statusContent: StatusContent) {
    Row(modifier = Modifier.fillMaxWidth().padding(
        start = 16.dp,
        end = 16.dp,
        top = 8.dp,
        bottom = 8.dp
    )) {
        val painter =
            rememberImagePainter(statusContent.image)
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
                statusContent.name,
                color = textColor,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                statusContent.time,
                color = topBarColor,
                fontSize = 16.sp
            )

        }
    }
}

fun Modifier.dashedBorder(strokeWidth: Dp, color: Color, cornerRadiusDp: Dp) = composed(
    factory = {
        val density = LocalDensity.current
        val strokeWidthPx = density.run { strokeWidth.toPx() }
        val cornerRadiusPx = density.run { cornerRadiusDp.toPx() }

        this.then(
            Modifier.drawWithCache {
                onDrawBehind {
                    val stroke = Stroke(
                        width = strokeWidthPx,
                        pathEffect = PathEffect.dashPathEffect(floatArrayOf(40f, 40f), 10f)
                    )

                    drawRoundRect(
                        color = color,
                        style = stroke,
                        cornerRadius = CornerRadius(cornerRadiusPx)
                    )
                }
            }
        )
    }
)