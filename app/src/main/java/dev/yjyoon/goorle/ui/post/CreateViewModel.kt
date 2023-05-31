package dev.yjyoon.goorle.ui.post

import android.graphics.Bitmap
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.yjyoon.goorle.ui.model.FilterType
import dev.yjyoon.goorle.ui.model.ThemeType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class CreateViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(CreateState())
    val uiState: StateFlow<CreateState> = _uiState.asStateFlow()

    fun modifyTag(tag: ThemeType) {
        val tags = _uiState.value.tags
        if (tag in tags) {
            _uiState.update { it.copy(tags = tags.filterNot { it == tag }) }
        } else {
            _uiState.update { it.copy(tags = tags + tag) }
        }
    }

    fun modifyFilter(filter: FilterType) {
        val filters = _uiState.value.filters
        if (filter in filters) {
            _uiState.update { it.copy(filters = filters.filterNot { it == filter }) }
        } else {
            _uiState.update { it.copy(filters = filters + filter) }
        }
    }

    fun onPickImage(bitmap: Bitmap) {
        _uiState.update { it.copy(images = _uiState.value.images + bitmap) }
    }

    fun deleteImage(bitmap: Bitmap) {
        _uiState.update { it.copy(images = _uiState.value.images.filterNot { it == bitmap }) }
    }
}
