package br.com.jd.sistemas.emocao.data.database

import androidx.lifecycle.LiveData
import br.com.jd.sistemas.emocao.data.domain.Emocao

class EmocaoDaoImpl : EmocaoDao {

    override fun add(emocao: Emocao) {

    }

    override fun getEmocoes(): LiveData<List<Emocao>> {
        TODO("Not yet implemented")
    }

}