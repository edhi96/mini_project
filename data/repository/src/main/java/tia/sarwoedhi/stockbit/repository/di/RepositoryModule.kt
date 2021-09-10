/**
 * created by Tia Sarwoedhi on 10/9/2021
 **/

package tia.sarwoedhi.stockbit.repository.di

import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module
import tia.sarwoedhi.stockbit.repository.AppDispatchers
import tia.sarwoedhi.stockbit.repository.ExampleRepositoryImpl
import tia.sarwoedhi.stockbit.repository.coin.CryptoRepository
import tia.sarwoedhi.stockbit.repository.coin.CryptoRepositoryImpl
import tia.sarwoedhi.stockbit.repository.coin.CryptoUseCase
import tia.sarwoedhi.stockbit.repository.user.UserRepositoryLocal

val repositoryModule = module {
    factory { AppDispatchers(Dispatchers.Main, Dispatchers.IO) }
    factory <CryptoRepository> { CryptoRepositoryImpl(get()) }
    factory { CryptoRepositoryImpl(get()) }
    factory { CryptoUseCase(get()) }
    factory { ExampleRepositoryImpl(get(), get()) }
    factory { UserRepositoryLocal(get(),get()) }
}