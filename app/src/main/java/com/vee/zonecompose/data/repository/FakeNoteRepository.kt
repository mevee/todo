package com.vee.zonecompose.data.repository

import android.content.Context
import com.vee.zonecompose.data.Note

class FakeNoteRepository(context: Context) : BaseRepository(context) {
    suspend fun getAllNotes(): List<Note> {
        return emptyList()
    }

    suspend fun saveNote(note: Note): Boolean {
        return true

    }

    suspend fun getNote(id: Int): Note? {
        return null

    }

    suspend fun removeNote(id: Note): Boolean {
        return true
    }


}