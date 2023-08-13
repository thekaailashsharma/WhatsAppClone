package com.example.kmp.whatsapp.presentation.android

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Divider
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kmp.whatsapp.presentation.WhatsAppViewModel
import com.example.kmp.whatsapp.presentation.android.screens.AndroidCalls
import com.example.kmp.whatsapp.presentation.android.screens.AndroidChats
import com.example.kmp.whatsapp.presentation.android.screens.AndroidStatus
import com.example.kmp.whatsapp.presentation.android.ui.theme.backGroundColor
import com.example.kmp.whatsapp.presentation.android.ui.theme.textColor
import com.example.kmp.whatsapp.presentation.android.ui.theme.topBarChatColor
import com.example.kmp.whatsapp.presentation.android.ui.theme.topBarColor
import com.example.kmp.whatsapp.presentation.android.utils.TopBarAndroid
import com.example.kmp.whatsapp.presentation.android.utils.WhatsAppTabs
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun WhatsAppAndroid() {
    Column(modifier = Modifier.fillMaxSize()) {
        val viewModel = getViewModel(
            key = "WhatsAppViewModel",
            factory = viewModelFactory {
                WhatsAppViewModel()
            }
        )
        val count = viewModel.chatList.let {
            var unReads = 0
            it.forEach { chats ->
                if (chats.unReads > 0) {
                    unReads += 1
                }
            }
            unReads
        }
        val tabIndex = rememberSaveable { mutableStateOf(0) }
        val scope = rememberCoroutineScope()
        val state = rememberPagerState()
        val tabs = listOf(
            WhatsAppTabs.Chats,
            WhatsAppTabs.Status,
            WhatsAppTabs.Calls,
        )
        LaunchedEffect(key1 = state.currentPage) {
            tabIndex.value = state.currentPage
        }
        TopBarAndroid(
            tabs = {
                TabRow(
                    selectedTabIndex = tabIndex.value,
                    modifier = Modifier.background(backGroundColor).fillMaxWidth(),
                    divider = {
                        Divider(
                            modifier = Modifier
                                .height(1.dp)
                                .fillMaxWidth(),
                            color = Color.Transparent
                        )
                    },
                    containerColor = backGroundColor,
                ) {
                    tabs.forEachIndexed { index, tab ->
                        Tab(
                            selected = tabIndex.value == index,
                            onClick = {
                                tabIndex.value = index
                                scope.launch {
                                    state.scrollToPage(index)
                                }
                            },
                            text = {
                                Text(
                                    text = "${tab.name} ${
                                        if (tab == WhatsAppTabs.Chats && count > 0)
                                            "($count)" else ""
                                    }",
                                    fontSize = 16.sp,
                                    color = if (tabIndex.value == index) topBarChatColor else topBarColor
                                )
                            },
                            selectedContentColor = backGroundColor,
                            unselectedContentColor = textColor,
                        )
                    }
                }
            }
        )
        HorizontalPager(pageCount = tabs.size, state = state) { page ->
            when (page) {
                0 -> AndroidChats(tabs[tabIndex.value], viewModel.chatList)
                1 -> AndroidStatus(tabs[tabIndex.value], viewModel.statusList)
                2 -> AndroidCalls(tabs[tabIndex.value], viewModel.callsList)
            }
        }


    }

}