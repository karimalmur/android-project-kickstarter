package com.example.app.domain

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.example.app.domain.network.ConnectivityInterceptor
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

val coreModule = module {
    single {
        val cacheSize = 10 * 1024 * 1024L // 10 MiB
        Cache(androidApplication().cacheDir, cacheSize)
    }

    single {
        HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }
    }

    single {
        ConnectivityInterceptor(get())
    }

    single {
        OkHttpClient
            .Builder()
            .cache(get())
            .addInterceptor(get<HttpLoggingInterceptor>())
            .addInterceptor(get<ConnectivityInterceptor>())
            .addNetworkInterceptor(StethoInterceptor())
            .readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(getProperty<String>("app_endpoint"))
            .client(get())
            .build()
    }
}
