package dev.yjyoon.goorle.ui.mypage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.yjyoon.goorle.data.repository.ServiceRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MypageViewModel @Inject constructor(
    private val searchRepository: ServiceRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(MypageState())
    val uiState: StateFlow<MypageState> = _uiState.asStateFlow()

    init {
        loadPosts()
        loadComments()
    }

    private fun loadPosts() {
        viewModelScope.launch {
            searchRepository.getAllPosts().onSuccess { posts ->
                _uiState.update { it.copy(posts = posts) }
            }
        }
    }

    private fun loadComments() {
        viewModelScope.launch {
            searchRepository.getRecentComments().onSuccess { comments ->
                _uiState.update { it.copy(comments = comments) }
            }
        }
    }
}
