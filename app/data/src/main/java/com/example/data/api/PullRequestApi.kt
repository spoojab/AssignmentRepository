package com.example.data.api

import com.example.data.dto.PullRequestResponseDto
import com.example.remote.response.NetworkResponse
import retrofit2.http.GET

interface PullRequestApi {
    @GET("repos/spoojab/PublicRepository/pulls?state=closed")
    suspend fun getPullRequest(): NetworkResponse<List<PullRequestResponseDto>>
}