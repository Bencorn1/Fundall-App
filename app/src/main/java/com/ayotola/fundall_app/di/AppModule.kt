package com.ayotola.fundall_app.di


import android.content.Context
import com.ayotola.fundall_app.BuildConfig.BASE_URL
import com.ayotola.fundall_app.network.FundallService
import com.ayotola.fundall_app.sharedpreference.FundallPreferences
import com.ayotola.fundall_app.sharedpreference.Preferences
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Singleton
    @Provides
    fun providesFundallService(retrofit: Retrofit): FundallService =
    retrofit.create(FundallService::class.java)

    @Singleton
    @Provides
    fun provideGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @Singleton
    @Provides
    fun providesRetrofit(gsonConverterFactory: GsonConverterFactory): Retrofit =
        Retrofit.Builder().addConverterFactory(gsonConverterFactory)
            .baseUrl(BASE_URL)
            .build()

    @Provides
    @Singleton
    fun providesAuthorizationHeaderInterceptor(preferences: Preferences) = Interceptor { chain ->
        val request = chain.request().newBuilder().addHeader("Authorization", "Bearer ${preferences.getToken()}").build()
        chain.proceed(request)
    }

    @Provides
    @Singleton
    fun providesOkhttp(loggingInterceptor: HttpLoggingInterceptor, authHeaderInterceptor: Interceptor): OkHttpClient =
        OkHttpClient.Builder()
            .connectTimeout(60L, TimeUnit.SECONDS)
            .readTimeout(60L, TimeUnit.SECONDS)
            .writeTimeout(60L, TimeUnit.SECONDS)
            .callTimeout(60L, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .addInterceptor(authHeaderInterceptor)
            .build()


    @Provides
    @Singleton
    fun provideOkHttpClient(authToken: String?): OkHttpClient {
        val client = OkHttpClient.Builder()
        if (!authToken.isNullOrEmpty()) {
            client.addInterceptor { chain ->
                val newRequest = chain.request().newBuilder()
                    .addHeader("Authorization", "Bearer $authToken")
                    .build()
                chain.proceed(newRequest)
            }
        }
        return client.build()
    }
    @Provides
    @Singleton
    fun providesPreferences(@ApplicationContext context: Context): Preferences {
        return FundallPreferences(context)
    }

}