package dev.yjyoon.goorle.ui.post

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.yjyoon.goorle.R
import dev.yjyoon.goorle.ui.model.FilterType
import dev.yjyoon.goorle.ui.model.RegionType
import dev.yjyoon.goorle.ui.model.ThemeType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class GridViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val type =
        requireNotNull(savedStateHandle.get<GridViewType>(GridActivity.EXTRA_KEY_TYPE))

    private val _uiState = MutableStateFlow(
        GridState(
            when (type) {
                GridViewType.Theme -> R.string.home_section_title_01
                GridViewType.Region -> R.string.home_section_title_02
            }
        )
    )
    val uiState: StateFlow<GridState> = _uiState.asStateFlow()

    fun modifyFilter(filter: FilterType) {
        val filters = _uiState.value.filters
        if (filter in filters) {
            _uiState.update { it.copy(filters = filters.filterNot { it == filter }) }
        } else {
            _uiState.update { it.copy(filters = filters + filter) }
        }
    }

    fun loadThemeList(themeType: ThemeType) {
        _uiState.update { it.copy(titleRes = themeType.stringRes, posts = List(10) { Post() }) }
    }

    fun loadRegionList(regionType: RegionType) {
        _uiState.update { it.copy(titleRes = regionType.stringRes, posts = List(10) { Post() }) }
    }
}
