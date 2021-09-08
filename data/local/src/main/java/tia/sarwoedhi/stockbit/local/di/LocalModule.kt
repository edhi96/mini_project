package tia.sarwoedhi.stockbit.local.di

import com.google.gson.Gson
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module
import tia.sarwoedhi.stockbit.local.AppDatabase

private const val DATABASE = "DATABASE"

val localModule = module {
    single(named(DATABASE)) { AppDatabase.buildDatabase(androidContext()) }
    factory { Gson() }
    factory { (get(named(DATABASE)) as AppDatabase).exampleDao() }
}