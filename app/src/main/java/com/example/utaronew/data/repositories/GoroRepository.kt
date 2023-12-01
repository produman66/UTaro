package com.example.utaronew.data.repositories

import com.example.utaronew.data.room.dao.GoroscopListDao
import com.example.utaronew.data.room.entities.GoroscopListEntities
import kotlinx.coroutines.flow.Flow

class GoroRepository(private val goroDao: GoroscopListDao) {

    val goroAll: Flow<List<GoroscopListEntities>> = goroDao.findAll()

}

