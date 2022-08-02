package com.example.domain.usecase

import com.example.domain.entity.PullRequestEntity
import com.example.util.NoInputSuspendingUseCase

interface PullRequestUseCase : NoInputSuspendingUseCase<Result<List<PullRequestEntity>>>