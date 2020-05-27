package br.com.jd.sistemas.emocao.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.jd.sistemas.emocao.data.domain.Emocao

@Database(entities = [Emocao::class], version = 1, exportSchema = false)
abstract class AppDataBase: RoomDatabase() {
    abstract val emocaoDao: EmocaoDao
}