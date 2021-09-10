/**
 * created by Tia Sarwoedhi on 10/9/2021
 **/

package tia.sarwoedhi.stockbit.features.home.watch_list

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import tia.sarwoedhi.stockbit.common.utils.Params
import tia.sarwoedhi.stockbit.repository.AppDispatchers
import tia.sarwoedhi.stockbit.repository.coin.CryptoEntity
import tia.sarwoedhi.stockbit.repository.coin.CryptoUseCase
import tia.sarwoedhi.stockbit.repository.user.UserRepositoryLocal
import tia.sarwoedhi.stockbit.repository.utils.Resource

class WatchListViewModel(private val userRepositoryLocal: UserRepositoryLocal, private val cryptoUseCase: CryptoUseCase, private val dispatchers: AppDispatchers) :ViewModel(){

    private var page = 1
    val cryptoResult : MutableLiveData<Resource<List<CryptoEntity>>> = MutableLiveData()
    private val logout : MutableLiveData<Resource<Boolean>> = MutableLiveData()
    private var loading = false
    init {
        getCoins()
    }

    fun doLogout(): MutableLiveData<Resource<Boolean>> {
        logout.postValue(Resource.loading(false))
        try {
            userRepositoryLocal.doLogOut(Params.EXTRA_KEY_CONDITIONS)
            logout.postValue(Resource.success(true))
        } catch (e: Exception) {
            Log.e("NetworkBoundResource", "An error happened: $e")
            logout.postValue(Resource.error(e.message?:"",false))
        }
        return logout
    }

    fun refreshCoins() = getCoins(refresh=true)

    private fun getCoins(tysm:String =Params.REQUEST_TYPE_USD,refresh: Boolean=false) {
        cryptoResult.postValue(Resource.loading(null))
        if (refresh) page = 1
        viewModelScope.launch {
            withContext(dispatchers.io) {
                try {
                    val result = cryptoUseCase(tsym = tysm,page = page)
                    if(result!=null && result.isNotEmpty()) cryptoResult.postValue(Resource.success(result))
                    else cryptoResult.postValue(Resource.error("Empty Data",null))
                } catch (e: Exception) {
                    cryptoResult.postValue(Resource.error(e.message?:"", null))
                }
            }
            loading = false
        }
    }

    fun updatePageNumber() {
        page++
    }

    fun fetchPage() {
        if (!loading) {
            loading = true
            getCoins()
        }
    }
}