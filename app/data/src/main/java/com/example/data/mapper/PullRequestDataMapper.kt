package com.example.data.mapper

import com.example.data.dto.PullRequestResponseDto
import com.example.domain.entity.PullRequestEntity
import com.example.util.Mapper

object PullRequestDataMapper : Mapper<List<PullRequestResponseDto>, List<PullRequestEntity>> {

    override suspend fun map(input: List<PullRequestResponseDto>): List<PullRequestEntity> {
        return input.map {
            PullRequestEntity(
                title = it?.title.orEmpty(),
                userName = it?.user?.name.orEmpty(),
                userProfileUrl = it?.user?.avatar_url.orEmpty(),
                createdDate = it?.created_date.orEmpty(),
                closedDate = it?.closed_date.orEmpty(),
            )
        }.orEmpty()
    }
}