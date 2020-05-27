package br.com.jd.sistemas.emocao

import android.app.Application
import br.com.jd.sistemas.emocao.di.databaseModule
import br.com.jd.sistemas.emocao.di.repositoryModule
import br.com.jd.sistemas.emocao.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@App)
            printLogger(Level.DEBUG)
            modules(listOf(viewModelModule, repositoryModule, databaseModule))
        }
    }
}