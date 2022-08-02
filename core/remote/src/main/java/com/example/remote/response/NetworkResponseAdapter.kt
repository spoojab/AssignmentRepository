package com.example.remote.response

import java.lang.reflect.Type
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Response

internal class NetworkResponseAdapter(
    private val type: Type,
) : CallAdapter<Any?, Call<NetworkResponse<Any?>>> {
    private val voidMapper = { _: Response<Any?> ->
        NetworkResponse.Success(null)
    }

    private val unitMapper = { _: Response<Any?> ->
        NetworkResponse.Success(Unit)
    }

    private val typeMapper = { response: Response<Any?> ->
        val body = response.body()
        if (body == null) {
            // This unfortunate behaviour is result of https://github.com/square/retrofit/issues/3075
            val unexpectedNullBodyException = IllegalArgumentException(
                "Unexpected null response. Parametrize NetworkResponse with Void or Unit instead."
            )
            NetworkResponse.Failure(unexpectedNullBodyException)
        } else {
            NetworkResponse.Success(
                body
            )
        }
    }

    private val successMapper: (Response<Any?>) -> NetworkResponse<Any?> = when (type) {
        Void::class.java -> voidMapper
        Unit::class.java -> unitMapper
        else -> typeMapper
    }

    override fun responseType() = type

    override fun adapt(call: Call<Any?>) = NetworkResponseCall(call, successMapper)
}
