package com.fifty.chromanotes.feature_note.domain.usecase

import com.fifty.chromanotes.feature_note.domain.model.Note
import com.fifty.chromanotes.feature_note.domain.repository.NoteRepository

class DeleteNoteUseCase(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(note: Note) =
        repository.deleteNote(note)
}