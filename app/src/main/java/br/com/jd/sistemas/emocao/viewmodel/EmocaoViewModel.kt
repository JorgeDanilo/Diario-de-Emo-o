package br.com.jd.sistemas.emocao.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.jd.sistemas.emocao.data.domain.Emocao
import br.com.jd.sistemas.emocao.data.repository.EmocaoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EmocaoViewModel(private val emocaoRepository: EmocaoRepository): ViewModel() {

    fun add(emocao: Emocao) {
        viewModelScope.launch(Dispatchers.IO) {
            emocaoRepository.add(emocao)
        }
    }
}