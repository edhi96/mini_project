package tia.sarwoedhi.stockbit.di

import tia.sarwoedhi.stockbit.features.di.featureModules
import tia.sarwoedhi.stockbit.local.di.localModule
import tia.sarwoedhi.stockbit.remote.di.createRemoteModule
import tia.sarwoedhi.stockbit.repository.di.repositoryModule

val appComponent= listOf(createRemoteModule("https://api.github.com/"), repositoryModule, localModule,featureModules)