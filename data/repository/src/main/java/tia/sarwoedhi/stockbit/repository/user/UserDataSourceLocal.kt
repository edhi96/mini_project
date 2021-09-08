package tia.sarwoedhi.stockbit.repository.user

interface UserDataSourceLocal {
    fun getUserLogin(keyLogin:String):Boolean

    fun doLogin(keyLogin:String)
}