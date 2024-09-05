package com.universitinder.app.school.schoolImages

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.universitinder.app.ui.theme.UniversitinderTheme

class SchoolImagesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val schoolImagesViewModel = SchoolImagesViewModel()

        setContent {
            UniversitinderTheme {
                SchoolImagesScreen(schoolImagesViewModel = schoolImagesViewModel)
            }
        }
    }
}