package br.com.jd.sistemas.emocao.data.repository

import br.com.jd.sistemas.emocao.data.database.EmocaoDao
import br.com.jd.sistemas.emocao.data.domain.Emocao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class EmocaoRepository(private val emocaoDao: EmocaoDao)  {

   val data = emocaoDao.getEmocoes()

   suspend fun refresh() {
      withContext(Dispatchers.IO) {
         emocaoDao.getEmocoes()
      }
   }

   fun add(emocao: Emocao) {
      emocaoDao.add(emocao)
   }
}