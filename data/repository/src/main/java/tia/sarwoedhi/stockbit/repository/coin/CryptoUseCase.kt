/**
 * created by Tia Sarwoedhi on 10/9/2021
 **/

package tia.sarwoedhi.stockbit.repository.coin

class CryptoUseCase(private val repository: CryptoRepository) {
    suspend operator fun invoke(tsym: String,page:Int): List<CryptoEntity>? {
        return repository.getTopCoins(tsym,page).data?.map {
            CryptoEntity(
                it.coinInfo?.name,
                it.coinInfo?.fullName,
                it.raw?.detail?.price,
                it.raw?.detail?.changeHour,
                it.raw?.detail?.changePctHour
            )
       }
    }
}