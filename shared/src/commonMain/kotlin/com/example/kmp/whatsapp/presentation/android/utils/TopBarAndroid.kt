package com.example.kmp.whatsapp.presentation.android.utils

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Camera
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kmp.whatsapp.presentation.android.ui.theme.backGroundColor
import com.example.kmp.whatsapp.presentation.android.ui.theme.textColor
import com.example.kmp.whatsapp.presentation.android.ui.theme.topBarColor


@Composable
fun TopBarAndroid(
    tabs: @Composable () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxWidth()
            .background(backGroundColor)
            .padding(start = 16.dp, end = 16.dp, top = 15.dp, bottom = 8.dp),
        verticalArrangement = Arrangement.Top,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = "Whatsapp",
                color = topBarColor,
                fontSize = 22.sp,
                modifier = Modifier.padding(start = 7.dp)
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Filled.Camera,
                    contentDescription = "Camera",
                    tint = topBarColor,
                    modifier = Modifier.size(22.dp)
                )

                Spacer(Modifier.width(15.dp))

                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Edit",
                    tint = topBarColor,
                    modifier = Modifier.size(22.dp)
                )
                Spacer(Modifier.width(15.dp))

                Icon(
                    imageVector = Icons.Filled.MoreVert,
                    contentDescription = "Edit",
                    tint = topBarColor,
                    modifier = Modifier.size(22.dp)
                )
            }
        }

        Spacer(Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            tabs()
        }
    }
}

