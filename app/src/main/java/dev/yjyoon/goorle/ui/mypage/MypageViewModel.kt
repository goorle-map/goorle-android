package dev.yjyoon.goorle.ui.mypage

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MypageViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(MypageState())
    val uiState: StateFlow<MypageState> = _uiState.asStateFlow()
}
