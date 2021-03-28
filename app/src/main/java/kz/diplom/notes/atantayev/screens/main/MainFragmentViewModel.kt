package kz.diplom.notes.atantayev.screens.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kz.diplom.notes.atantayev.utilits.REPOSITORY

class MainFragmentViewModel(application: Application) : AndroidViewModel(application) {
    val allNotes = REPOSITORY.allNotes
    fun signOut(){
        REPOSITORY.signOut()
    }
}