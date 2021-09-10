/**
 * created by Tia Sarwoedhi on 10/9/2021
 **/

package tia.sarwoedhi.stockbit.repository.coin

import tia.sarwoedhi.stockbit.model.BaseResponse
import tia.sarwoedhi.stockbit.model.Crypto
import tia.sarwoedhi.stockbit.remote.CryptoDatasource

interface CryptoRepository {
    suspend fun getTopCoins(tsym:String,page:Int=1): BaseResponse<Crypto>
}

class CryptoRepositoryImpl(private val datasource: CryptoDatasource): CryptoRepository {

    override suspend fun getTopCoins(tsym:String,page:Int): BaseResponse<Crypto> {
        return datasource.fetchTopTier(tsym,page)
    }

}