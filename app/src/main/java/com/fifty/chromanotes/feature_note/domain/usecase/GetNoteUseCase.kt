package com.fifty.chromanotes.feature_note.domain.usecase

import com.fifty.chromanotes.feature_note.domain.model.Note
import com.fifty.chromanotes.feature_note.domain.repository.NoteRepository

class GetNoteUseCase(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(id: Int) =
        repository.getNoteById(id)
}