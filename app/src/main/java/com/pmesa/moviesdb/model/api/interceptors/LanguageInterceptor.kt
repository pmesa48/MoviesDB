package com.pmesa.moviesdb.model.api.interceptors

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.util.*

class LanguageInterceptor : Interceptor {

    companion object{
        const val LANGUAGE = "language"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val original: Request = chain.request()
        val originalHttpUrl: HttpUrl = original.url
        val url = originalHttpUrl.newBuilder()
            .addQueryParameter(LANGUAGE, Locale.getDefault().toLanguageTag())
            .build()
        val requestBuilder: Request.Builder = original.newBuilder()
            .url(url)
        val request: Request = requestBuilder.build()
        return chain.proceed(request)
    }
}