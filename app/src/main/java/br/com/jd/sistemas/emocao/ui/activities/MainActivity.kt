package br.com.jd.sistemas.emocao.ui.activities

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.jd.sistemas.emocao.R
import br.com.jd.sistemas.emocao.data.domain.Emocao
import br.com.jd.sistemas.emocao.ui.adapters.EmocoesAdapter
import br.com.jd.sistemas.emocao.utils.LoadingState
import br.com.jd.sistemas.emocao.viewmodel.EmocaoViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class MainActivity : AppCompatActivity() {

    private val emocaoViewModel: EmocaoViewModel by viewModel()
    private val emocoesAdapter: EmocoesAdapter by lazy {
        EmocoesAdapter()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv_emocoes.adapter = emocoesAdapter
        rv_emocoes.layoutManager = LinearLayoutManager(this)
        addObservables()
        addMotivo()
    }

    private fun addObservables() {
        emocaoViewModel.data.observe(this, androidx.lifecycle.Observer {
            it.let { emocoes ->
                emocoes.forEach {
                    emocoesAdapter.add(it)
                }
            }
        })

        emocaoViewModel.loadingState.observe(this, androidx.lifecycle.Observer {
            when(it.status) {
                LoadingState.Status.FAILED -> Toast.makeText(baseContext, it.msg, Toast.LENGTH_SHORT).show()
                LoadingState.Status.RUNNING -> Toast.makeText(baseContext, "Loading", Toast.LENGTH_SHORT).show()
                LoadingState.Status.SUCCESS -> Toast.makeText(baseContext, "Success", Toast.LENGTH_SHORT).show()
            }
        })
    }

    fun addMotivo() {
        btn_salvar.setOnClickListener {
            if (!txt_emocao.text.isNullOrEmpty()) {
                val emocao = Emocao(motivo = txt_emocao.text.toString(), dataCadastro = Date())
                emocaoViewModel.add(emocao).apply {
                    Toast.makeText(this@MainActivity, "Motivo Salvo com sucesso!", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "O campo motivo é obrigatório", Toast.LENGTH_SHORT).show()
            }
        }
    }


}
