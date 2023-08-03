package com.fifty.chromanotes.di

import android.app.Application
import androidx.room.Room
import com.fifty.chromanotes.feature_note.data.data_source.NoteDatabase
import com.fifty.chromanotes.feature_note.data.repository.NoteRepositoryImpl
import com.fifty.chromanotes.feature_note.domain.repository.NoteRepository
import com.fifty.chromanotes.feature_note.domain.usecase.DeleteNoteUseCase
import com.fifty.chromanotes.feature_note.domain.usecase.GetNotesUseCase
import com.fifty.chromanotes.feature_note.domain.usecase.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application) =
        Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase) =
        NoteRepositoryImpl(db.noteDao)

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository) =
        NoteUseCases(
            getNotes = GetNotesUseCase(repository),
            deleteNote = DeleteNoteUseCase(repository)
        )
}