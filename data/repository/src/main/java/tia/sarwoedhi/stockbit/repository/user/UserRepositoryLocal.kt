package tia.sarwoedhi.stockbit.repository.user

import android.content.Context
import com.google.gson.Gson
import tia.sarwoedhi.stockbit.local.shared_preference.SharedPreference

class UserRepositoryLocal (context: Context, gson: Gson): SharedPreference(context,gson),
    UserDataSourceLocal {

    override fun getUserLogin(keyLogin: String): Boolean {
        return getBoolean(keyLogin)
    }

    override fun doLogin(keyLogin: String) {
       saveDataBoolean(keyLogin,true)
    }

}