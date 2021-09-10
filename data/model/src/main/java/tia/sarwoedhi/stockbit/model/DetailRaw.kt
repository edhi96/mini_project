/**
 * created by Tia Sarwoedhi on 10/9/2021
 **/

package tia.sarwoedhi.stockbit.model

import com.google.gson.annotations.SerializedName

data class DetailRaw(
    @SerializedName("CHANGE24HOUR") var change24HOUR: String? = null,
    @SerializedName("CHANGEDAY") var changeDay: String? = null,
    @SerializedName("CHANGEHOUR") var changeHour: Double? = null,
    @SerializedName("CHANGEPCT24HOUR") var changePct24Hour: Double? = null,
    @SerializedName("CHANGEPCTDAY") var changePctDay: Double? = null,
    @SerializedName("CHANGEPCTHOUR") var changePctHour: Double? = null,
    @SerializedName("CONVERSIONSYMBOL") var conversionSymbol: String? = null,
    @SerializedName("CONVERSIONTYPE") var conversionType: String? = null,
    @SerializedName("FROMSYMBOL") var fromSymbol: String? = null,
    @SerializedName("HIGH24HOUR") var high24Hour: Double? = null,
    @SerializedName("HIGHDAY") var highDay: Double? = null,
    @SerializedName("HIGHHOUR") var highHour: Double? = null,
    @SerializedName("IMAGEURL") var imageUrl: String? = null,
    @SerializedName("LASTMARKET") var lastMarket: String? = null,
    @SerializedName("LASTTRADEID") var LastTradeId: String? = null,
    @SerializedName("LASTUPDATE") var lastUpdate: Double? = null,
    @SerializedName("LASTVOLUME") var lastVolume: Double? = null,
    @SerializedName("LASTVOLUMETO") var lastVolumeTo: Double? = null,
    @SerializedName("LOW24HOUR") var low24Hour: Double? = null,
    @SerializedName("LOWDAY") var lowDay: Double? = null,
    @SerializedName("LOWHOUR") var lowHour: Double? = null,
    @SerializedName("MARKET") var market: String? = null,
    @SerializedName("MKTCAP") var mktCap: Double? = null,
    @SerializedName("MKTCAPPENALTY") var mktCappenalty: Double? = null,
    @SerializedName("OPEN24HOUR") var open24Hour: Double? = null,
    @SerializedName("OPENDAY") var openDay: Double? = null,
    @SerializedName("OPENHOUR") var openHour: Double? = null,
    @SerializedName("PRICE") var price: Double? = null,
    @SerializedName("SUPPLY") var supply: Double? = null,
    @SerializedName("TOPTIERVOLUME24HOUR") var topTierVolume24Hour: Double? = null,
    @SerializedName("TOPTIERVOLUME24HOURTO") var topTierVolume24HourTo: Double? = null,
    @SerializedName("TOSYMBOL") var toSymbol: String? = null,
    @SerializedName("TOTALTOPTIERVOLUME24H") var totalTopTierVolume24H: Double? = null,
    @SerializedName("TOTALTOPTIERVOLUME24HTO") var totalTopTierVolume24HTo: Double? = null,
    @SerializedName("TOTALVOLUME24H") var totalVolume24H: Double? = null,
    @SerializedName("TOTALVOLUME24HTO") var totalVolume24HTo: Double? = null,
    @SerializedName("VOLUME24HOUR") var volume24Hour: Double? = null,
    @SerializedName("VOLUME24HOURTO") var volume24HourTo: Double? = null,
    @SerializedName("VOLUMEDAY") var volumeDay: Double? = null,
    @SerializedName("VOLUMEDAYTO") var volumeDayTo: Double? = null,
    @SerializedName("VOLUMEHOUR") var volumeHour: Double? = null,
    @SerializedName("VOLUMEHOURTO") var volumeHourTo: Double? = null
)