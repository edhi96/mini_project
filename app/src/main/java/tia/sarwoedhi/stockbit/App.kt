package tia.sarwoedhi.stockbit

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import tia.sarwoedhi.stockbit.di.appComponent

open class App: Application() {
    override fun onCreate() {
        super.onCreate()
        configureDi()
    }

    // CONFIGURATION ---
    open fun configureDi()  =
        startKoin {
            androidContext(this@App)
            modules(provideComponent())
        }

    // PUBLIC API ---
    open fun provideComponent() = appComponent
}