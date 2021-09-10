/**
 * created by Tia Sarwoedhi on 10/9/2021
 **/

package tia.sarwoedhi.stockbit.remote

import retrofit2.http.GET
import retrofit2.http.Query
import tia.sarwoedhi.stockbit.model.BaseResponse
import tia.sarwoedhi.stockbit.model.Crypto

interface CryptoService {

    @GET("top/totaltoptiervolfull")
   suspend fun fetchTopTier(@Query("limit")limit:Int?= 16,
                            @Query("tsym") tsym: String,
                            @Query("page") page: Int? = 1): BaseResponse<Crypto>
}