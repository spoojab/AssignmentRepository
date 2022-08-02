package com.example.naviproject.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.PullRequestEntity
import com.example.domain.usecase.PullRequestUseCase
import com.example.util.ViewStateValue
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Viewmodel @Inject constructor(
    private val pullRequestUseCase: PullRequestUseCase
) : ViewModel() {

    private val _pullRequestFlow = MutableStateFlow<ViewStateValue<List<PullRequestEntity>>>(ViewStateValue.Idle)
    val pullRequestFlow: StateFlow<ViewStateValue<List<PullRequestEntity>>> get() = _pullRequestFlow.asStateFlow()

    fun getPullRequestResponse() {
        viewModelScope.launch {
            _pullRequestFlow.value = ViewStateValue.Loading
            pullRequestUseCase.execute().onSuccess {
                _pullRequestFlow.value = ViewStateValue.Success(it)
            }.onFailure {
                _pullRequestFlow.value = ViewStateValue.Failure(it)
            }
        }
    }
}
