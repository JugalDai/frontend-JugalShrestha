package com.jugal.travelnepal.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jugal.travelnepal.dao.DestinationDAO
import com.jugal.travelnepal.dao.UserDAO
//import com.aakash.travelnepal.dao.UserDAO
import com.jugal.travelnepal.entity.Destination
import com.jugal.travelnepal.entity.User

@Database(
       entities = [(User::class), (Destination::class)],
        //entities = [(Destination::class)],
        version = 2,
        exportSchema = false
)

abstract class UserDB : RoomDatabase(){
    abstract fun getUserDAO(): UserDAO
    abstract fun getDestinationDAO(): DestinationDAO


    companion object{
        @Volatile
        private var instance: UserDB? = null

        fun getInstance(context: Context): UserDB{
            if(instance==null){
                kotlin.synchronized(UserDB::class){
                    instance = buildDatase(context)
                }
            }
            return instance!!
        }
        private fun buildDatase(context: Context) : UserDB{
            return Room.databaseBuilder(
                    context.applicationContext,
                    UserDB::class.java,
                    "UserDB"
            ).build()
        }
    }
}