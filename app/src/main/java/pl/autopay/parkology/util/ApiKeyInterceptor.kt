package pl.autopay.parkology.util

import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder().url(
            chain.request().url.newBuilder().addQueryParameter(API_KEY_QUERY, API_KEY_VALUE).build()
        ).build()
        return chain.proceed(request)
    }
    companion object {
        private const val API_KEY_QUERY = "api_key"
        private const val API_KEY_VALUE = "wtk94Kiaff3AdfhdrjrXe44JK2zIU9FlLR0hScT5"
    }
}