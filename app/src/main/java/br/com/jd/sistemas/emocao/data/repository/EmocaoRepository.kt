package br.com.jd.sistemas.emocao.data.repository

import br.com.jd.sistemas.emocao.data.database.EmocaoDao
import br.com.jd.sistemas.emocao.data.domain.Emocao

class EmocaoRepository(private val emocaoDao: EmocaoDao)  {

   fun add(emocao: Emocao) {
      emocaoDao.add(emocao)
   }
}