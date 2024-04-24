package com.android.typipagination.repository

import com.android.typipagination.data.remote.apiservice.ApiService
import javax.inject.Inject

class TypiCodeRepositoryImpl @Inject constructor(
    apiService: ApiService
): TypiCodeRepository