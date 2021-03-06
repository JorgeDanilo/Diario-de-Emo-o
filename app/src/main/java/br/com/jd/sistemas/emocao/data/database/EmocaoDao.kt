package br.com.jd.sistemas.emocao.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import br.com.jd.sistemas.emocao.data.domain.Emocao

@Dao
interface EmocaoDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun add(emocao: Emocao)

    @Query("SELECT * FROM tb_emocao ORDER BY data_cadastro ASC")
    fun getEmocoes(): LiveData<List<Emocao>>

    @Delete
    fun remove(emocao: Emocao)
}