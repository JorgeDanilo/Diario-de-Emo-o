package br.com.jd.sistemas.emocao.ui.viewholders

import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import br.com.jd.sistemas.emocao.data.domain.Emocao
import br.com.jd.sistemas.emocao.utils.dateFormatter
import kotlinx.android.synthetic.main.item_emocao.view.*

class EmocoesViewHolder(val view: View): RecyclerView.ViewHolder(view) {
    @RequiresApi(Build.VERSION_CODES.O)
    fun bindView(item: Emocao) {
        with(view) {
            tv_emocao.text = item.motivo
            tv_data.text = dateFormatter(item.dataCadastro)
        }
    }
}
