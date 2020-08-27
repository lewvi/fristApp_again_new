package com.natthakun.fristapp_again.ContactDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Contact::class], version = 1, exportSchema = false)
abstract class ContactDatabase : RoomDatabase(){
    abstract val Dao: ContactDAO
    companion object{
        @Volatile
        private var INSTANCE: com.natthakun.fristapp_again.ContactDB.ContactDatabase? = null
        fun getInstance(context: Context): com.natthakun.fristapp_again.ContactDB.ContactDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        com.natthakun.fristapp_again.ContactDB.ContactDatabase::class.java,
                        "database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}