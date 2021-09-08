package tia.sarwoedhi.stockbit.repository

import tia.sarwoedhi.stockbit.local.dao.ExampleDao
import tia.sarwoedhi.stockbit.model.ExampleModel
import tia.sarwoedhi.stockbit.remote.ExampleDatasource
import tia.sarwoedhi.stockbit.repository.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface ExampleRepository {
    suspend fun getExample(): Flow<Resource<ExampleModel>>
}

class ExampleRepositoryImpl(private val datasource: ExampleDatasource,
                            private val dao: ExampleDao
): ExampleRepository {

    override suspend fun getExample(): Flow<Resource<ExampleModel>> {
        return flow {  }
    }

}