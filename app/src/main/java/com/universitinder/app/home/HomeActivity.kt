package com.universitinder.app.home

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.preferences.core.edit
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.universitinder.app.accountSetup.AccountSetupActivity
import com.universitinder.app.helpers.ActivityStarterHelper
import com.universitinder.app.login.LoginActivity
import com.universitinder.app.models.User
import com.universitinder.app.models.UserState
import com.universitinder.app.models.UserType
import com.universitinder.app.navigation.NavigationScreen
import com.universitinder.app.navigation.NavigationViewModel
import com.universitinder.app.ui.theme.UniversitinderTheme
import com.universitinder.app.userDataStore

class HomeActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    private fun currentUserIsEmpty(user: User) : Boolean {
        return user.type == UserType.UNKNOWN && user.email.isEmpty() && user.address.isEmpty() && user.contactNumber.isEmpty() &&
        user.name.isEmpty()
    }

    override fun onStart() {
        super.onStart()

        if (auth.currentUser != null){
            val currentUser = UserState.currentUser
            if (currentUser == null || currentUserIsEmpty(currentUser)) {
                val intent = Intent(this@HomeActivity, AccountSetupActivity::class.java)
                startActivity(intent)
            }
        } else {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = Firebase.auth

        val activityStarterHelper = ActivityStarterHelper(this)
        val homeViewModel = HomeViewModel(auth = auth, activityStarterHelper = activityStarterHelper, clearUser = this::clearUser)
        val navigationViewModel = NavigationViewModel(homeViewModel = homeViewModel)

        setContent {
            UniversitinderTheme {
                NavigationScreen(navigationViewModel = navigationViewModel)
            }
        }
    }

    private suspend fun clearUser() {
        this.userDataStore.edit { preferences ->
            preferences.clear()
        }
    }
}