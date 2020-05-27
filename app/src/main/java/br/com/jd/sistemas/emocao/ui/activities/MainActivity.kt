package br.com.jd.sistemas.emocao.ui.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.jd.sistemas.emocao.R
import br.com.jd.sistemas.emocao.data.domain.Emocao
import br.com.jd.sistemas.emocao.viewmodel.EmocaoViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class MainActivity : AppCompatActivity() {

    private val emocaoViewModel: EmocaoViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addMotivo()
    }

    fun addMotivo() {
        btn_salvar.setOnClickListener {
            if (!txt_emocao.text.isNullOrEmpty()) {
                val emocao = Emocao(motivo = txt_emocao.text.toString(), dataCadastro = Date())
                emocaoViewModel.add(emocao)
            } else {
                Toast.makeText(this, "O campo motivo é obrigatório", Toast.LENGTH_SHORT).show()
            }
        }
    }


}
