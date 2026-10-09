package com.android.desktop.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.android.desktop.ui.desktop.DesktopScreen
import com.android.desktop.ui.theme.DesktopTheme
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class DesktopActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d("DesktopActivity created")
        
        setContent {
            DesktopTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.DarkGray
                ) {
                    DesktopScreen()
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        Timber.d("DesktopActivity resumed")
    }

    override fun onPause() {
        super.onPause()
        Timber.d("DesktopActivity paused")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.d("DesktopActivity destroyed")
    }
}
