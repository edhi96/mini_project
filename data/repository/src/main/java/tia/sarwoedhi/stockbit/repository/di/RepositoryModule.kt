package tia.sarwoedhi.stockbit.repository.di

import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module
import tia.sarwoedhi.stockbit.repository.AppDispatchers
import tia.sarwoedhi.stockbit.repository.ExampleRepository
import tia.sarwoedhi.stockbit.repository.ExampleRepositoryImpl
import tia.sarwoedhi.stockbit.repository.user.UserRepositoryLocal

val repositoryModule = module {
    factory { AppDispatchers(Dispatchers.Main, Dispatchers.IO) }
    factory { ExampleRepositoryImpl(get(), get()) as ExampleRepository }
    factory { UserRepositoryLocal(get(),get()) }
}