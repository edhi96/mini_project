/**
 * created by Tia Sarwoedhi on 10/9/2021
 **/

package tia.sarwoedhi.stockbit.repository.coin

data class CryptoEntity(
    var name: String?,
    var companyName: String?,
    var price: Double?,
    var changeHour: Double?,
    var changePctHour: Double?
)