/**
 * created by Tia Sarwoedhi on 10/9/2021
 **/

package tia.sarwoedhi.stockbit.di

import tia.sarwoedhi.stockbit.features.di.featureModules
import tia.sarwoedhi.stockbit.local.di.localModule
import tia.sarwoedhi.stockbit.remote.di.createRemoteModule
import tia.sarwoedhi.stockbit.repository.di.repositoryModule

val appComponent= listOf(createRemoteModule(), repositoryModule, localModule,featureModules)