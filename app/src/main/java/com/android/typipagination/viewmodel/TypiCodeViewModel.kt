package com.android.typipagination.viewmodel

import androidx.lifecycle.ViewModel
import com.android.typipagination.repository.TypiCodeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TypiCodeViewModel @Inject constructor(
    private val repository: TypiCodeRepository
) : ViewModel() {
}