package br.com.jd.sistemas.emocao.data.domain

import androidx.room.*
import br.com.jd.sistemas.emocao.data.converter.DateTimeConverter
import java.util.*

@Entity(tableName = "tb_emocao")
@TypeConverters(DateTimeConverter::class)
class Emocao(@PrimaryKey(autoGenerate = true) var id: Int = 0,
                  @ColumnInfo(name = "motivo") val motivo: String,
                  @ColumnInfo(name = "data_cadastro") val dataCadastro: Date) {

    override fun toString(): String {
        return "Motivo: $motivo, Data Cadastro: $dataCadastro"
    }
}