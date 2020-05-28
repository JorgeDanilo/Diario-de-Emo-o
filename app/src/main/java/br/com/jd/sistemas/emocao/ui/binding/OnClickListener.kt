package br.com.jd.sistemas.emocao.ui.binding

import br.com.jd.sistemas.emocao.data.domain.Emocao

interface OnClickListener {
    fun onCliCK(emocao: Emocao)
}