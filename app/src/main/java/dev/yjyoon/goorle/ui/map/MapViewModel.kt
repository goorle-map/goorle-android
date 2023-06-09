package dev.yjyoon.goorle.ui.map

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.yjyoon.goorle.data.repository.ServiceRepository
import dev.yjyoon.goorle.ui.model.Post
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MapViewModel @Inject constructor(
    private val serviceRepository: ServiceRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(MapState())
    val uiState: StateFlow<MapState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            val posts = serviceRepository.getAllPosts().getOrThrow()
            _uiState.update { it.copy(posts = posts) }
        }
    }

    fun selectPost(post: Post) {
        _uiState.update { it.copy(selectedPost = post) }
    }
}
