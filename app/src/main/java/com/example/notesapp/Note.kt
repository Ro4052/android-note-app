package com.example.notesapp

import android.os.ParcelUuid
import java.time.LocalDateTime

class Note(val id: ParcelUuid, val title: String, val content: String, val date: LocalDateTime) {}