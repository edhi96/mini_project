/**
 * created by Tia Sarwoedhi on 10/9/2021
 **/

package tia.sarwoedhi.stockbit.model


import com.google.gson.annotations.SerializedName

data class DetailDisplay(
    @SerializedName("CHANGE24HOUR") var change24HOUR: String? = null,
    @SerializedName("CHANGEDAY") var changeDay: String? = null,
    @SerializedName("CHANGEHOUR") var changeHour: String? = null,
    @SerializedName("CHANGEPCT24HOUR") var changePct24Hour: String? = null,
    @SerializedName("CHANGEPCTDAY") var changePctDay: String? = null,
    @SerializedName("CHANGEPCTHOUR") var changePctHour: String? = null,
    @SerializedName("CONVERSIONSYMBOL") var conversionSymbol: String? = null,
    @SerializedName("CONVERSIONTYPE") var conversionType: String? = null,
    @SerializedName("FROMSYMBOL") var fromSymbol: String? = null,
    @SerializedName("HIGH24HOUR") var high24Hour: String? = null,
    @SerializedName("HIGHDAY") var highDay: String? = null,
    @SerializedName("HIGHHOUR") var highHour: String? = null,
    @SerializedName("IMAGEURL") var imageUrl: String? = null,
    @SerializedName("LASTMARKET") var lastMarket: String? = null,
    @SerializedName("LASTTRADEID") var LastTradeId: String? = null,
    @SerializedName("LASTUPDATE") var lastUpdate: String? = null,
    @SerializedName("LASTVOLUME") var lastVolume: String? = null,
    @SerializedName("LASTVOLUMETO") var lastVolumeTo: String? = null,
    @SerializedName("LOW24HOUR") var low24Hour: String? = null,
    @SerializedName("LOWDAY") var lowDay: String? = null,
    @SerializedName("LOWHOUR") var lowHour: String? = null,
    @SerializedName("MARKET") var market: String? = null,
    @SerializedName("MKTCAP") var mktCap: String? = null,
    @SerializedName("MKTCAPPENALTY") var mktCappenalty: String? = null,
    @SerializedName("OPEN24HOUR") var open24Hour: String? = null,
    @SerializedName("OPENDAY") var openDay: String? = null,
    @SerializedName("OPENHOUR") var openHour: String? = null,
    @SerializedName("PRICE") var price: String? = null,
    @SerializedName("SUPPLY") var supply: String? = null,
    @SerializedName("TOPTIERVOLUME24HOUR") var topTierVolume24Hour: String? = null,
    @SerializedName("TOPTIERVOLUME24HOURTO") var topTierVolume24HourTo: String? = null,
    @SerializedName("TOSYMBOL") var toSymbol: String? = null,
    @SerializedName("TOTALTOPTIERVOLUME24H") var totalTopTierVolume24H: String? = null,
    @SerializedName("TOTALTOPTIERVOLUME24HTO") var totalTopTierVolume24HTo: String? = null,
    @SerializedName("TOTALVOLUME24H") var totalVolume24H: String? = null,
    @SerializedName("TOTALVOLUME24HTO") var totalVolume24HTo: String? = null,
    @SerializedName("VOLUME24HOUR") var volume24Hour: String? = null,
    @SerializedName("VOLUME24HOURTO") var volume24HourTo: String? = null,
    @SerializedName("VOLUMEDAY") var volumeDay: String? = null,
    @SerializedName("VOLUMEDAYTO") var volumeDayTo: String? = null,
    @SerializedName("VOLUMEHOUR") var volumeHour: String? = null,
    @SerializedName("VOLUMEHOURTO") var volumeHourTo: String? = null
)