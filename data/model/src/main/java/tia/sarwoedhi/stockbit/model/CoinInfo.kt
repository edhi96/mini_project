/**
 * created by Tia Sarwoedhi on 10/9/2021
 **/

package tia.sarwoedhi.stockbit.model


import com.google.gson.annotations.SerializedName

data class CoinInfo(
    @SerializedName("Algorithm") var algorithm: String? = null,
    @SerializedName("AssetLaunchDate") var assetLaunchDate: String? = null,
    @SerializedName("BlockNumber") var blockNumber: Int? = null,
    @SerializedName("BlockReward") var blockReward: Double? = null,
    @SerializedName("BlockTime") var blockTime: Double? = null,
    @SerializedName("DocumentType") var documentType: String? = null,
    @SerializedName("FullName") var fullName: String? = null,
    @SerializedName("Id") var id: String? = null,
    @SerializedName("ImageUrl") var imageUrl: String? = null,
    @SerializedName("Internal") var internal: String? = null,
    @SerializedName("MaxSupply") var maxSupply: Double? = null,
    @SerializedName("Name") var name: String? = null,
    @SerializedName("NetHashesPerSecond") var netHashesPerSecond: Double? = null,
    @SerializedName("ProofType") var proofType: String? = null,
    @SerializedName("Rating") var rating: Rating? = null,
    @SerializedName("Type") var type: Int? = null,
    @SerializedName("Url") var url: String? = null
)