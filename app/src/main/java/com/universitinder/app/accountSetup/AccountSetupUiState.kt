package com.universitinder.app.accountSetup

import com.universitinder.app.models.ResultMessage
import com.universitinder.app.models.UserType

data class AccountSetupUiState (
    val type: UserType = UserType.STUDENT,
    val openTypeMenu: Boolean = false,
    val email: String = "",
    val name: String = "",
    val address: String = "",
    val contactNumber: String = "",
    val createLoading: Boolean = false,
    val resultMessage: ResultMessage = ResultMessage()
)