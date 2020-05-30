package br.com.jd.sistemas.emocao.ui.activities

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.jd.sistemas.emocao.R
import br.com.jd.sistemas.emocao.data.domain.Emocao
import br.com.jd.sistemas.emocao.ui.adapters.EmocoesAdapter
import br.com.jd.sistemas.emocao.ui.binding.OnClickListener
import br.com.jd.sistemas.emocao.utils.LoadingState
import br.com.jd.sistemas.emocao.viewmodel.EmocaoViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*


class MainActivity : AppCompatActivity() {

    private val emocaoViewModel: EmocaoViewModel by viewModel()
    private val emocoesAdapter: EmocoesAdapter by lazy {
        EmocoesAdapter(mListener = mListener)
    }


    @RequiresApi(Build.VERSION_CODES.O)
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
                emocoesAdapter.add(emocoes)
            }
        })

        emocaoViewModel.loadingState.observe(this, androidx.lifecycle.Observer {
            when(it.status) {
                LoadingState.Status.FAILED -> Toast.makeText(baseContext, it.msg, Toast.LENGTH_SHORT).show()
//                LoadingState.Status.RUNNING -> Toast.makeText(baseContext, "Loading", Toast.LENGTH_SHORT).show()
//                LoadingState.Status.SUCCESS -> Toast.makeText(baseContext, "Success", Toast.LENGTH_SHORT).show()
            }
        })
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun addMotivo() {
        btn_salvar.setOnClickListener {
            if (!txt_emocao.text.isNullOrEmpty()) {
                val emocao = Emocao(motivo = txt_emocao.text.toString(), dataCadastro = Date())
                emocaoViewModel.add(emocao).apply {
                    txt_emocao.text = null
                    Toast.makeText(this@MainActivity, "Motivo Salvo com sucesso!", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, getString(R.string.msg_emocao_required), Toast.LENGTH_SHORT).show()
            }
        }
    }

    var mListener: OnClickListener = object : OnClickListener {
        override fun onCliCK(emocao: Emocao) {
            emocoesAdapter.remove(emocao).apply {
                emocaoViewModel.remove(emocao).apply {
                    Toast.makeText(this@MainActivity, "Emoção excluída com Sucesso!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


}
