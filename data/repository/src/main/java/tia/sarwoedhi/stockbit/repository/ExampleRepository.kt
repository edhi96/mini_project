/**
 * created by Tia Sarwoedhi on 10/9/2021
 **/

package tia.sarwoedhi.stockbit.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import tia.sarwoedhi.stockbit.local.dao.ExampleDao
import tia.sarwoedhi.stockbit.model.ExampleModel
import tia.sarwoedhi.stockbit.remote.CryptoDatasource
import tia.sarwoedhi.stockbit.repository.utils.Resource

interface ExampleRepository {
    suspend fun getExample(): Flow<Resource<ExampleModel>>
}

class ExampleRepositoryImpl(private val datasource: CryptoDatasource,
                            private val dao: ExampleDao
): ExampleRepository {

    override suspend fun getExample(): Flow<Resource<ExampleModel>> {
        return flow {  }
    }

}