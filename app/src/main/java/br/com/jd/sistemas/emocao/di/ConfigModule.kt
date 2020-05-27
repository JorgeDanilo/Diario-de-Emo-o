package br.com.jd.sistemas.emocao.di

import android.app.Application
import androidx.room.Room
import br.com.jd.sistemas.emocao.data.database.EmocaoDao
import br.com.jd.sistemas.emocao.data.database.AppDataBase
import br.com.jd.sistemas.emocao.data.repository.EmocaoRepository
import br.com.jd.sistemas.emocao.viewmodel.EmocaoViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    single { EmocaoViewModel(get()) }
}

val databaseModule = module {
    fun provideDatabase(application: Application): AppDataBase {
        return Room.databaseBuilder(application, AppDataBase::class.java, "emocao.database")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    fun providerDao(database: AppDataBase): EmocaoDao {
        return database.emocaoDao
    }

    single { provideDatabase(androidApplication()) }
    single { providerDao(get()) }
}

val repositoryModule = module {
    fun providerEmocaoRepository(dao: EmocaoDao): EmocaoRepository {
        return EmocaoRepository(dao)
    }
    single { providerEmocaoRepository(get()) }
}