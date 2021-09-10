/**
 * created by Tia Sarwoedhi on 10/9/2021
 **/

package tia.sarwoedhi.stockbit.features.di

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import tia.sarwoedhi.stockbit.features.home.HomeViewModel
import tia.sarwoedhi.stockbit.features.home.chat.ChatViewModel
import tia.sarwoedhi.stockbit.features.home.portfolio.PortfolioViewModel
import tia.sarwoedhi.stockbit.features.home.search.SearchViewModel
import tia.sarwoedhi.stockbit.features.home.stream.StreamViewModel
import tia.sarwoedhi.stockbit.features.home.watch_list.WatchListViewModel
import tia.sarwoedhi.stockbit.features.login.LoginViewModel

var featureModules = module {

    viewModel { LoginViewModel(get()) }

    viewModel { HomeViewModel() }

    viewModel { WatchListViewModel(get(),get(),get()) }

    viewModel { StreamViewModel() }

    viewModel { SearchViewModel() }

    viewModel { PortfolioViewModel() }

    viewModel { ChatViewModel() }
}