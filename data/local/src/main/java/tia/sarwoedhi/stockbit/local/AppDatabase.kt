package tia.sarwoedhi.stockbit.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import tia.sarwoedhi.stockbit.local.converter.Converters
import tia.sarwoedhi.stockbit.local.dao.ExampleDao
import tia.sarwoedhi.stockbit.model.ExampleModel

@Database(entities = [ExampleModel::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase: RoomDatabase() {

    // DAO
    abstract fun exampleDao(): ExampleDao

    companion object {

        fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "App.db")
                .build()
    }
}