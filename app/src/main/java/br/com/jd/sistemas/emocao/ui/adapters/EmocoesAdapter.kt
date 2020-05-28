package br.com.jd.sistemas.emocao.ui.adapters

import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.jd.sistemas.emocao.R
import br.com.jd.sistemas.emocao.data.domain.Emocao
import br.com.jd.sistemas.emocao.ui.viewholders.EmocoesViewHolder

class EmocoesAdapter(val data: MutableList<Emocao> = mutableListOf()): RecyclerView.Adapter<EmocoesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmocoesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_emocao, parent, false)
        return EmocoesViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: EmocoesViewHolder, position: Int) {
        holder.setIsRecyclable(false)
        holder.bindView(data[position])
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    fun add(item: Emocao) {
        data.add(item)
        notifyDataSetChanged()
    }
    fun add(itens: List<Emocao>) {
        data.clear()
        data.addAll(itens)
        notifyDataSetChanged()
    }

    fun remove(item: Emocao) {
        data.remove(item)
        notifyDataSetChanged()
    }
}