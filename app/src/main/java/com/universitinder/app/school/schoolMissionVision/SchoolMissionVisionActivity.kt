package com.universitinder.app.school.schoolMissionVision

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.universitinder.app.controllers.SchoolController
import com.universitinder.app.ui.theme.UniversitinderTheme

class SchoolMissionVisionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val schoolController = SchoolController()
        val schoolMissionVisionViewModel = SchoolMissionVisionViewModel(schoolController = schoolController, popActivity = this::finish)

        setContent {
            UniversitinderTheme {
                SchoolMissionVisionScreen(viewModel = schoolMissionVisionViewModel)
            }
        }
    }
}