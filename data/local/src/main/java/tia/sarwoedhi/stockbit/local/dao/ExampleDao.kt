package tia.sarwoedhi.stockbit.local.dao

import androidx.room.Dao
import androidx.room.Query
import tia.sarwoedhi.stockbit.model.ExampleModel

@Dao
abstract class ExampleDao: BaseDao<ExampleModel>() {

    @Query("SELECT * FROM ExampleModel WHERE name = :name LIMIT 1")
    abstract suspend fun getExample(name: String): ExampleModel

    suspend fun save(data: ExampleModel) {
        insert(data)
    }

    suspend fun save(datas: List<ExampleModel>) {
        insert(datas)
    }
}