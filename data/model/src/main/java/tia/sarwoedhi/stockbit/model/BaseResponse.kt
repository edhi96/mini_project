/**
 * created by Tia Sarwoedhi on 10/9/2021
 **/

package tia.sarwoedhi.stockbit.model


import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    @SerializedName("Message") var message: String? = null,
    @SerializedName("Type") var type: Int? = null,
    @SerializedName("MetaData") var metaData: MetaData? = null,
    @SerializedName("SponsoredData") var sponsoredData: List<SponsoredData?>? = null,
    @SerializedName("Data") var data: List<T>? = null,
    @SerializedName("RateLimit") var rateLimit: RateLimit? = null,
    @SerializedName("HasWarning") var hasWarning: Boolean? = null
)