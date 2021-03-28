package kz.diplom.notes.atantayev.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kz.diplom.notes.atantayev.database.firebase.AppFirebaseRepository
import kz.diplom.notes.atantayev.database.room.AppRoomDatabase
import kz.diplom.notes.atantayev.database.room.AppRoomRepository
import kz.diplom.notes.atantayev.utilits.REPOSITORY
import kz.diplom.notes.atantayev.utilits.TYPE_FIREBASE
import kz.diplom.notes.atantayev.utilits.TYPE_ROOM
import kz.diplom.notes.atantayev.utilits.showToast

class StartFragmentViewModel(application: Application):AndroidViewModel(application) {
    private val mContext = application

    fun initDatabase(type:String,onSuccess:()->Unit){
        when(type){
            TYPE_ROOM -> {
                val dao = AppRoomDatabase.getInstance(mContext).getAppRoomDao()
                REPOSITORY = AppRoomRepository(dao)
                onSuccess()
            }

            TYPE_FIREBASE -> {
                REPOSITORY = AppFirebaseRepository()
                REPOSITORY.connectToDatabase({onSuccess()},{ showToast(it)})
            }
        }
    }
}