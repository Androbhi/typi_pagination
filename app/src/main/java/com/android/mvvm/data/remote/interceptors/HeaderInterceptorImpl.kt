package com.android.mvvm.data.remote.interceptors

import com.android.mvvm.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
private const val VERSION = "Version"
internal class HeaderInterceptorImpl @Inject constructor() : HeaderInterceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        // Adding the header items only if it base url
        val isUnSplashAPi = chain.request().url.toString().startsWith(BuildConfig.BASE_URL, true)

        return if (isUnSplashAPi) {
            val requestBuilder = chain.request().newBuilder()
            requestBuilder.addHeader(VERSION, BuildConfig.VERSION_NAME)
            chain.proceed(request = requestBuilder.build())
        } else {
            chain.proceed(chain.request())
        }

    }

}