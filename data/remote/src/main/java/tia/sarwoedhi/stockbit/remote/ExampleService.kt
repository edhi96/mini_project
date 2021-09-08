package tia.sarwoedhi.stockbit.remote

import tia.sarwoedhi.stockbit.model.ExampleModel
import retrofit2.Response
import retrofit2.http.GET

interface ExampleService {

    @GET("get/example")
    fun fetchExampleAsync(): Response<ExampleModel>

}