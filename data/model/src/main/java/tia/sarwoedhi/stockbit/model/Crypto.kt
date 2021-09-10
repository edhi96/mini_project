/**
 * created by Tia Sarwoedhi on 10/9/2021
 **/

package tia.sarwoedhi.stockbit.model


import com.google.gson.annotations.SerializedName

data class Crypto(
    @SerializedName("CoinInfo") var coinInfo: CoinInfo? = null,
    @SerializedName("DISPLAY") var display: Display? = null,
    @SerializedName("RAW") var raw: Raw? = null
)