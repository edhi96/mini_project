/**
 * created by Tia Sarwoedhi on 10/9/2021
 **/

package tia.sarwoedhi.stockbit.model


import com.google.gson.annotations.SerializedName

data class MetaData(
    @SerializedName("Count") var count: Int? = null
)