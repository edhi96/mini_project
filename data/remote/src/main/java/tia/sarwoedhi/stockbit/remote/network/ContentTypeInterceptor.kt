/**
 * created by Tia Sarwoedhi on 10/9/2021
 **/

package tia.sarwoedhi.stockbit.remote.network

import com.stockbit.remote.BuildConfig.APPLICATION_JSON
import com.stockbit.remote.BuildConfig.CONTENT_TYPE_HEADER
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class ContentTypeInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(addHeader(chain.request()))
    }

    private fun addHeader(oriRequest: Request): Request {
        return oriRequest.newBuilder().addHeader(CONTENT_TYPE_HEADER, APPLICATION_JSON).build()
    }
}