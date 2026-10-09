package com.android.desktop.ui.desktop

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.android.desktop.ui.startmenu.StartMenuScreen
import com.android.desktop.ui.taskbar.TaskbarScreen
import timber.log.Timber

data class DesktopState(
    val isStartMenuOpen: Boolean = false,
    val openWindows: List<DesktopWindow> = emptyList(),
    val focusedWindow: DesktopWindow? = null
)

data class DesktopWindow(
    val id: String,
    val title: String,
    val isMinimized: Boolean = false
)

@Composable
fun DesktopScreen() {
    val desktopState = remember { mutableStateOf(DesktopState()) }

    Timber.d("Rendering DesktopScreen - StartMenu open: ${desktopState.value.isStartMenuOpen}")

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1A1A1A))
    ) {
        // Main desktop area - reserved for windows in future phases
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF1A1A1A))
        )

        // Taskbar at bottom
        TaskbarScreen(
            modifier = Modifier.align(Alignment.BottomCenter),
            onStartMenuToggle = {
                desktopState.value = desktopState.value.copy(
                    isStartMenuOpen = !desktopState.value.isStartMenuOpen
                )
                Timber.d("Start menu toggled to: ${!desktopState.value.isStartMenuOpen}")
            }
        )

        // Start menu overlay
        if (desktopState.value.isStartMenuOpen) {
            StartMenuScreen(
                onClose = {
                    desktopState.value = desktopState.value.copy(isStartMenuOpen = false)
                    Timber.d("Start menu closed")
                }
            )
        }
    }
}
