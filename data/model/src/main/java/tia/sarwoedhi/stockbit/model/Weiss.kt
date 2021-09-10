/**
 * created by Tia Sarwoedhi on 10/9/2021
 **/

package tia.sarwoedhi.stockbit.model


import com.google.gson.annotations.SerializedName

data class Weiss(
    @SerializedName("MarketPerformanceRating") var marketPerformanceRating: String? = null,
    @SerializedName("Rating") var rating: String? = null,
    @SerializedName("TechnologyAdoptionRating") var technologyAdoptionRating: String? = null
)