package com.example.remote.creator

import com.example.remote.adapter.JSONArrayAdapter
import com.example.remote.adapter.JSONObjectAdapter
import com.koo.remote.response.NetworkResponseCallAdapterFactory
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Inject

class RetrofitServiceCreator @Inject constructor(moshi: Moshi) : ApiServiceCreator {
    private val BASE_URL = "https://api.github.com/"
    override fun <T> create(
        serviceClass: Class<T>
    ): T = createRetrofitBuilder().build().create(serviceClass)

    private fun createRetrofitBuilder() =
        with(Retrofit.Builder()) {
            addCallAdapterFactory(NetworkResponseCallAdapterFactory)
            addConverterFactory(MoshiConverterFactory.create(defaultRemoteMoshi))
            baseUrl(BASE_URL)
        }

    private val defaultRemoteMoshi = moshi.newBuilder()
        .add(JSONArrayAdapter)
        .add(JSONObjectAdapter).build()
}