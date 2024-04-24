package com.android.mvvm.repository

import com.android.mvvm.data.remote.apiservice.ApiService
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    apiService: ApiService
): MainRepository