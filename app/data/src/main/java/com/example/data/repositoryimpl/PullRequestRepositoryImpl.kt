package com.example.data.repositoryimpl

import com.example.data.api.PullRequestApi
import com.example.data.mapper.PullRequestDataMapper
import com.example.domain.entity.PullRequestEntity
import com.example.domain.repository.PullRequestRepository
import com.example.remote.response.map
import com.example.remote.response.toResult
import javax.inject.Inject

internal class PullRequestRepositoryImpl @Inject constructor(
    private val pullRequestApi: PullRequestApi
) : PullRequestRepository {
    override suspend fun getAllClosedPullRequest(): Result<List<PullRequestEntity>> {
        return pullRequestApi.getPullRequest().map {
            PullRequestDataMapper.map(it)
        }.toResult()
    }
}