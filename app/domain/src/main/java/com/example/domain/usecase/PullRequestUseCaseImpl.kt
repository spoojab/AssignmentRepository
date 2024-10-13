package com.example.domain.usecase

import com.example.domain.entity.PullRequestEntity
import com.example.domain.repository.PullRequestRepository
import javax.inject.Inject

internal class PullRequestUseCaseImpl @Inject constructor(private val pullRequestRepository: PullRequestRepository) :
    PullRequestUseCase {
    override suspend fun execute(): Result<List<PullRequestEntity>> {
       
        
        return 
        pullRequestRepository.getAllClosedPullRequest()
    }
}
