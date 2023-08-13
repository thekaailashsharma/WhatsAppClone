package com.example.kmp.whatsapp.presentation

import com.example.kmp.whatsapp.presentation.android.utils.CallContent
import com.example.kmp.whatsapp.presentation.android.utils.CallType
import com.example.kmp.whatsapp.presentation.android.utils.ChatContent
import com.example.kmp.whatsapp.presentation.android.utils.StatusContent
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlin.random.Random

class WhatsAppViewModel : ViewModel() {
    private val names = listOf(
        "John",
        "Alice",
        "Bob",
        "Emma",
        "Michael",
        "Olivia",
        "David",
        "Patricia",
        "Richard",
        "Susan",
    )
    private val messages = listOf(
        "Hey, how are you?",
        "Hi there!",
        "What's up?",
        "Just wanted to say hi!",
        "Long time no see!",
        "How's your day?",
        "How's it going?",
        "What's going on?",
        "How's life?",
        "How's your day going?",
    )
    private val times = List(10) {
        "${Random.nextInt(24).toString().padStart(2, '0')}:${
            Random.nextInt(60).toString().padStart(2, '0')
        }"
    }
    private val unReads = listOf(true, false)
    private val imageUrls = listOf(
        "https://images.unsplash.com/photo-1500648767791-00dcc994a43e?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8cmFuZG9tJTIwcGVvcGxlfGVufDB8fDB8fHww&auto=format&fit=crop&w=800&q=60",
        "https://images.unsplash.com/photo-1522364723953-452d3431c267?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fHx8fHx8fHx8fHx8fHx8fHx8fHx8fHx8fHx8fHx8fHx8fHx8fHx8fHx8fHx8fHx8fHx8fHx8fHx8fHx8fHx8fHx8",
        "https://images.unsplash.com/photo-1530268729831-4b0b9e170218?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTB8fHJhbmRvbSUyMHBlb3BsZXxlbnwwfHwwfHx8MA%3D%3D&auto=format&fit=crop&w=800&q=60",
        "https://images.unsplash.com/photo-1525134479668-1bee5c7c6845?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OHx8cmFuZG9tJTIwcGVvcGxlfGVufDB8fDB8fHww&auto=format&fit=crop&w=800&q=60",
        "https://images.unsplash.com/photo-1539571696357-5a69c17a67c6?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Nnx8cmFuZG9tJTIwcGVvcGxlfGVufDB8fDB8fHww&auto=format&fit=crop&w=800&q=60",
        "https://images.unsplash.com/photo-1507003211169-0a1dd7228f2d?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8cmFuZG9tJTIwcGVvcGxlfGVufDB8fDB8fHww&auto=format&fit=crop&w=800&q=60",
        "https://images.unsplash.com/photo-1496360166961-10a51d5f367a?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MjB8fHJhbmRvbSUyMHBlb3BsZXxlbnwwfHwwfHx8MA%3D%3D&auto=format&fit=crop&w=800&q=60",
        "https://images.unsplash.com/photo-1494790108377-be9c29b29330?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTd8fHJhbmRvbSUyMHBlb3BsZXxlbnwwfHwwfHx8MA%3D%3D&auto=format&fit=crop&w=800&q=60",
        "https://images.unsplash.com/photo-1529626455594-4ff0802cfb7e?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTh8fHJhbmRvbSUyMHBlb3BsZXxlbnwwfHwwfHx8MA%3D%3D&auto=format&fit=crop&w=800&q=60",
        "https://plus.unsplash.com/premium_photo-1681884620841-9a49e1afd488?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTl8fHJhbmRvbSUyMHBlb3BsZXxlbnwwfHwwfHx8MA%3D%3D&auto=format&fit=crop&w=800&q=60"
    )

    val chatList: MutableList<ChatContent> = mutableListOf()
    val statusList: MutableList<StatusContent> = mutableListOf()
    val callsList: MutableList<CallContent> = mutableListOf()
    init {
        for (i in 0 until 10) {
            val time = times[i]
            val unRead = unReads.random()
            val unReads = (0..5).random()
            val chat = ChatContent(names[i], messages[i], time, unRead, imageUrls[i], unReads)
            chatList.add(chat)
        }
        for (i in 0 until 4){
            val status = StatusContent(
                name = names[i],
                image = imageUrls[i],
                time = "${
                    listOf("Yesterday","Today").random()
                } at ${times[i]} ${listOf("am","pm").random()} "
            )
            statusList.add(status)
        }
        for (i in 0 until 10){
            val call = CallContent(
                name = names[i],
                image = imageUrls[i],
                time = "${
                    listOf("Yesterday","Today").random()
                } at ${times[i]} ${listOf("am","pm").random()} ",
                callType = listOf(CallType.OUTGOING, CallType.MISSED).random()
            )
            callsList.add(call)
        }
    }





}