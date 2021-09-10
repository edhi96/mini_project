/**
 * created by Tia Sarwoedhi on 10/9/2021
 **/

package tia.sarwoedhi.stockbit.repository.user

interface UserDataSourceLocal {
    fun getUserLogin(keyLogin:String):Boolean

    fun doLogin(keyLogin:String)

    fun doLogOut(key:String)
}