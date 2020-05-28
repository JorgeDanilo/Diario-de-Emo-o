package br.com.jd.sistemas.emocao.viewmodel

import android.app.Application
import androidx.lifecycle.*
import br.com.jd.sistemas.emocao.data.domain.Emocao
import br.com.jd.sistemas.emocao.data.repository.EmocaoRepository
import br.com.jd.sistemas.emocao.utils.LoadingState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class EmocaoViewModel(private val emocaoRepository: EmocaoRepository): ViewModel() {

    private val _loadingState = MutableLiveData<LoadingState>()
    val loadingState : LiveData<LoadingState>
        get() = _loadingState

    val data = emocaoRepository.data

    init {
        fetchData()
    }

    fun add(emocao: Emocao) {
        viewModelScope.launch(Dispatchers.IO) {
            emocaoRepository.add(emocao)
        }
    }

    private fun fetchData() {
        viewModelScope.launch {
            try {
                _loadingState.value = LoadingState.LOADING
                emocaoRepository.refresh()
                _loadingState.value = LoadingState.LOADED
            } catch (e: Exception) {
                _loadingState.value = LoadingState.error(e.message)
            }
        }
    }

}