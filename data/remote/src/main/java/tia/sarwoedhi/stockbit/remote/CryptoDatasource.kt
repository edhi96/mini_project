/**
 * created by Tia Sarwoedhi on 10/9/2021
 **/

/**
 * created by Tia Sarwoedhi on 9/9/2021
 **/

package tia.sarwoedhi.stockbit.remote

/**
 * Implementation of [CryptoService] interface
 */
class CryptoDatasource(private val cryptoService: CryptoService) {

suspend fun fetchTopTier(tsym: String,page:Int) = cryptoService.fetchTopTier(tsym = tsym,page = page)

}