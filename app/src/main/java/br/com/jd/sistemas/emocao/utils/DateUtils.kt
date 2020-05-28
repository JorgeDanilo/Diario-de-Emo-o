package br.com.jd.sistemas.emocao.utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.util.*

@RequiresApi(Build.VERSION_CODES.O)
fun dateFormatter(date: Date): String? {
    val simpleDateFormat = SimpleDateFormat("dd/MM/YYYY hh:mm")
    return simpleDateFormat.format(date)
}