package com.example.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PullRequestResponseDto(
    @Json(name = "title") val title: String?,
    @Json(name = "user") val user: UserDto,
    @Json(name = "created_at") val created_date: String?,
    @Json(name = "closed_at") val closed_date: String?,
)

@JsonClass(generateAdapter = true)
data class UserDto(
    @Json(name = "login") val name: String?,
    @Json(name = "avatar_url") val avatar_url: String?
)