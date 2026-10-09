package com.android.desktop.ui.startmenu

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.desktop.ui.theme.TaskbarBackground
import com.android.desktop.ui.theme.TextPrimary
import com.android.desktop.ui.theme.TextSecondary
import timber.log.Timber

@Composable
fun StartMenuScreen(
    onClose: () -> Unit = {}
) {
    Timber.d("Rendering StartMenuScreen")

    // Semi-transparent overlay to allow closing
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable(enabled = false) { }
    ) {
        // Start menu window
        Column(
            modifier = Modifier
                .width(280.dp)
                .wrapContentHeight()
                .background(TaskbarBackground)
                .border(1.dp, Color.Gray, RectangleShape)
                .padding(8.dp)
                .align(Alignment.BottomStart)
        ) {
            // Title
            Text(
                text = "Start Menu",
                color = TextPrimary,
                fontSize = 16.sp,
                modifier = Modifier.padding(12.dp)
            )

            // Placeholder text
            Text(
                text = "Phase 1: Applications will appear here",
                color = TextSecondary,
                fontSize = 12.sp,
                modifier = Modifier.padding(12.dp)
            )

            Text(
                text = "Phase 2: Application launcher",
                color = TextSecondary,
                fontSize = 11.sp,
                modifier = Modifier.padding(12.dp)
            )

            // Close instruction
            Text(
                text = "Click Start button to close",
                color = TextSecondary,
                fontSize = 10.sp,
                modifier = Modifier
                    .padding(12.dp)
                    .clickable { 
                        Timber.d("Start menu close triggered")
                        onClose()
                    }
            )
        }
    }
}
