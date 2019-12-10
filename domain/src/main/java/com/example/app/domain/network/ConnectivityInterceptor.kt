package com.example.app.domain.network
import android.content.Context
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class ConnectivityInterceptor(private val context: Context) : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        try {
            if (!context.hasNetworkConnection()) {
                throw NoConnectivityException()
            }

            val builder = chain.request().newBuilder()
            return chain.proceed(builder.build())
        } catch (e: Throwable) {
            if (e is IOException)
                throw e
            else
                throw IOException(e)
        }
    }
}

class NoConnectivityException : IOException() {
    override val message: String?
        get() = "No connectivity exception"
}
