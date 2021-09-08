package tia.sarwoedhi.stockbit.features.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import tia.sarwoedhi.stockbit.common.utils.Params
import tia.sarwoedhi.stockbit.repository.user.UserRepositoryLocal
import tia.sarwoedhi.stockbit.repository.utils.Resource

class LoginViewModel(private var userRepositoryLocal: UserRepositoryLocal): ViewModel() {

    private val loginCheck : MutableLiveData<Resource<Boolean>> = MutableLiveData()

    fun isLogin(): MutableLiveData<Resource<Boolean>> {
        loginCheck.postValue(Resource.loading(false))
        try {
            val data = userRepositoryLocal.getUserLogin(Params.EXTRA_KEY_CONDITIONS)
            if(data) loginCheck.postValue(Resource.success(data))
        } catch (e: Exception) {
            Log.e("NetworkBoundResource", "An error happened: $e")
            loginCheck.postValue(Resource.error(e,false))
        }
        return loginCheck
    }

    fun doLogin(): MutableLiveData<Resource<Boolean>> {
        loginCheck.postValue(Resource.loading(false))
        try {
            userRepositoryLocal.doLogin(Params.EXTRA_KEY_CONDITIONS)
            loginCheck.postValue(Resource.success(true))
        } catch (e: Exception) {
            Log.e("NetworkBoundResource", "An error happened: $e")
            loginCheck.postValue(Resource.error(e,false))
        }
        return loginCheck
    }

}