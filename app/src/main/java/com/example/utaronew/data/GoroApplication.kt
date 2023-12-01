package com.example.utaronew.data

import android.app.Application
import com.example.utaronew.data.repositories.GoroRepository
import com.example.utaronew.data.room.root.GoroscopDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class GoroApplication : Application() {
    val applicationScope = CoroutineScope(SupervisorJob())
    val database by lazy {GoroscopDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { GoroRepository(database.goroDao()) }
}