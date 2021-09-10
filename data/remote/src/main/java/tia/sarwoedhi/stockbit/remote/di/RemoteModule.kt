/**
 * created by Tia Sarwoedhi on 10/9/2021
 **/

package tia.sarwoedhi.stockbit.remote.di

import com.google.gson.GsonBuilder
import com.stockbit.remote.BuildConfig.BASE_URL
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import tia.sarwoedhi.stockbit.remote.CryptoDatasource
import tia.sarwoedhi.stockbit.remote.CryptoService
import tia.sarwoedhi.stockbit.remote.network.ApiKeyInterceptor
import tia.sarwoedhi.stockbit.remote.network.ContentTypeInterceptor
import java.util.concurrent.TimeUnit

fun createRemoteModule() = module {

    fun loggingInterceptor(): Interceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

    fun okHttpClientBuilder(builder: OkHttpClient.Builder): OkHttpClient.Builder =
        builder.addInterceptor(loggingInterceptor()).addInterceptor(ContentTypeInterceptor()).addInterceptor(ApiKeyInterceptor())

    fun provideClient(): OkHttpClient = okHttpClientBuilder(OkHttpClient.Builder())
        .connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .writeTimeout(60, TimeUnit.SECONDS)
        .build()

    fun gsonHandler(builder: GsonBuilder): GsonBuilder {
        return builder
    }

    val gson = gsonHandler(GsonBuilder().setPrettyPrinting()).setDateFormat("yyyy-MM-dd\'T\'hh:mm:ssZ").create()

    factory {
        loggingInterceptor()
    }

    factory { okHttpClientBuilder(get()) }

    factory { provideClient() }

    single {

        Retrofit.Builder()
            .client(provideClient())
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    factory{ get<Retrofit>().create(CryptoService::class.java) }

    factory { CryptoDatasource(get()) }


}