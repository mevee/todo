package com.vee.zonecompose.data.api

import com.vee.zonecompose.data.Note

interface ApiInterface {
    fun getAllNotes(): List<Note>
    fun saveNote(note: Note): List<Note>
    fun getNote(id: Int): List<Note>
    fun getRemoveNote(id: Int): List<Note>
}