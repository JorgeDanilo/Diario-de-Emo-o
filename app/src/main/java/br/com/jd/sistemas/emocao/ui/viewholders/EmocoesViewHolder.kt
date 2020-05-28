package br.com.jd.sistemas.emocao.ui.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import br.com.jd.sistemas.emocao.data.domain.Emocao
import kotlinx.android.synthetic.main.item_emocao.view.*

class EmocoesViewHolder(val view: View): RecyclerView.ViewHolder(view) {
    fun bindView(item: Emocao) {
        with(view) {
            tv_emocao.text = item.motivo
            tv_data.text = item.dataCadastro.toString()
        }
    }
}
