package com.example.domain.repository

import com.example.domain.entity.PullRequestEntity

interface PullRequestRepository {
    suspend fun getAllClosedPullRequest(): Result<List<PullRequestEntity>>
}