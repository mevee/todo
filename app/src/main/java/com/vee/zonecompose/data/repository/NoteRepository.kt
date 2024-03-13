package com.vee.zonecompose.data.repository

import android.content.Context
import com.vee.zonecompose.data.Note

class NoteRepository(context: Context) : BaseRepository(context) {
    fun getAllNotes(): List<Note> {
        return emptyList()
    }

    fun saveNote(note: Note): Boolean {
        return true

    }

    fun getNote(id: Int): Note? {
        return null

    }

    fun getRemoveNote(id: Int): Boolean {
        return true
    }


}