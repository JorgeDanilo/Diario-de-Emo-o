package br.com.jd.sistemas.emocao.ui.adapters

import android.os.Build
import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import br.com.jd.sistemas.emocao.R
import br.com.jd.sistemas.emocao.data.domain.Emocao
import br.com.jd.sistemas.emocao.ui.binding.OnClickListener
import br.com.jd.sistemas.emocao.ui.viewholders.EmocoesViewHolder
import kotlinx.android.synthetic.main.item_emocao.view.*

class EmocoesAdapter(val data: MutableList<Emocao> = mutableListOf(), val mListener: OnClickListener): RecyclerView.Adapter<EmocoesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmocoesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_emocao, parent, false)
        return EmocoesViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: EmocoesViewHolder, position: Int) {
        holder.setIsRecyclable(false)
        holder.view.btn_remove.setOnClickListener {
            if (mListener != null) {
                var position = holder.adapterPosition
                var emocao: Emocao = data[position]
                mListener.onCliCK(emocao)
            }
        }
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