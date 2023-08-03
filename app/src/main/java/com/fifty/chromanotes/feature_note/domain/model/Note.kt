package com.fifty.chromanotes.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.fifty.chromanotes.ui.theme.AquaBlue
import com.fifty.chromanotes.ui.theme.Gray
import com.fifty.chromanotes.ui.theme.Green
import com.fifty.chromanotes.ui.theme.Orange
import com.fifty.chromanotes.ui.theme.PaleGreen
import com.fifty.chromanotes.ui.theme.Pink
import com.fifty.chromanotes.ui.theme.Purple
import com.fifty.chromanotes.ui.theme.Yellow

@Entity
data class Note(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
) {
    companion object {
        val noteColors = listOf(AquaBlue, Pink, Yellow, PaleGreen, Purple, Orange, Green, Gray)
    }
}

class InvalidNoteException(message: String) : Exception(message)