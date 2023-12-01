package com.example.utaronew.data.room.root

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.utaronew.data.room.dao.GoroscopListDao
import com.example.utaronew.data.room.entities.GoroscopListEntities
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

@Database(
    version = 1,
    entities = [GoroscopListEntities::class]
)
abstract class GoroscopDatabase: RoomDatabase() {

    abstract fun goroDao(): GoroscopListDao

    companion object {
        @Volatile
        private var INSTANCE: GoroscopDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): GoroscopDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    GoroscopDatabase::class.java,
                    "word_database123456789"
                )
                    .addCallback(SRoomDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }

        private class SRoomDatabaseCallback(
            private val scope: CoroutineScope
        ) : RoomDatabase.Callback() {

            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                INSTANCE?.let { database ->
                    scope.launch {
                        populateDatabase(database.goroDao())
                    }
                }
            }

            suspend fun populateDatabase(wordDao: GoroscopListDao) {
                // Delete all content here.
                wordDao.deleteAll()
                // Add sample words.
                wordDao.insert(GoroscopListEntities(1,
                    "Гороскоп на сегодня",
                    "gorotoday",
                    "Гороскоп на сегодня - это предсказание или прогноз, " +
                            "основанный на астрологических знаниях, которое дает информацию о " +
                            "событиях, эмоциях и возможностях, которые могут возникнуть в течение " +
                            "текущего дня. Гороскоп может быть составлен для отдельных знаков зодиака" +
                            " или для всех знаков сразу. Он обычно включает в себя рекомендации, советы" +
                            " или предостережения, чтобы помочь людям принять более осознанные решения " +
                            "и максимизировать свои возможности в течение дня. Гороскопы на сегодня могут" +
                            " быть найдены в различных источниках, включая интернет, газеты и " +
                            "специализированные журналы."))
                wordDao.insert(GoroscopListEntities(2,
                    "Гороскоп на неделю",
                    "goroweek",
                    "Очень хороший"))
                wordDao.insert(GoroscopListEntities(3,
                    "Гороскоп на \nмесяц",
                    "goromonth",
                    "Очень хороший"))
                wordDao.insert(GoroscopListEntities(4,
                    "Ульяна ты самая",
                    "gorolove",
                    "Красивая, обаятельная, умная, нежная, безупречная, великолепная, прекрасная, милая, " +
                            "очаровательная, незабываемая, добрая, романтичная, ласковая, страстная, грациозная, " +
                            "привлекательная, неотразимая, неповторимая, искренняя, решительная, чуткая, верная, " +
                            "заботливая, вдохновляющая, щедрая, улыбчивая, творческая, душевная, элегантная, успешная, " +
                            "энергичная, талантливая, растительная, эмоциональная, оригинальная, жизнерадостная, веселая, " +
                            "кокетливая, интересная, интеллигентная, глубокая, смелая, добродушная, мечтательная, волевая, " +
                            "остроумная, соблазнительная, сексуальная, абсолютная, прозрачная, внимательная, понимающая, " +
                            "ранимая, надежная, уверенная, чарующая"))
                wordDao.insert(GoroscopListEntities(5,
                    "Гороскоп на карьеру",
                    "gorowork",
                    "Очень хороший"))
                wordDao.insert(GoroscopListEntities(6,
                    "Гороскоп на жизнь",
                    "gorolive",
                    "Очень хороший"))
                wordDao.insert(GoroscopListEntities(7,
                    "Гороскоп на карьеру",
                    "gorowork",
                    "Очень хороший"))
                wordDao.insert(GoroscopListEntities(8,
                    "Гороскоп на жизнь",
                    "gorolive",
                    "Очень хороший"))
            }
        }
    }
