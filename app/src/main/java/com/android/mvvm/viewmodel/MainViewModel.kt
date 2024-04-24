package com.android.mvvm.viewmodel

import androidx.lifecycle.ViewModel
import com.android.mvvm.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {
}