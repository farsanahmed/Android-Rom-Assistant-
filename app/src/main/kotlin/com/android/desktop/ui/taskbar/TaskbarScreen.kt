package com.android.desktop.ui.taskbar

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.desktop.ui.theme.TaskbarBackground
import com.android.desktop.ui.theme.TaskbarBorder
import com.android.desktop.ui.theme.TextPrimary
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@Composable
fun TaskbarScreen(
    modifier: Modifier = Modifier,
    onStartMenuToggle: () -> Unit = {}
) {
    val currentTime = remember { mutableStateOf(LocalTime.now()) }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(TaskbarBackground)
            .border(1.dp, TaskbarBorder, RectangleShape)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Start button
        Button(
            onClick = onStartMenuToggle,
            modifier = Modifier.padding(4.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF404040),
                contentColor = TextPrimary
            )
        ) {
            Text("Start", fontSize = 12.sp)
        }

        // Spacer in middle
        Spacer(modifier = Modifier.weight(1f))

        // Clock display
        Box(
            modifier = Modifier
                .clickable { 
                    currentTime.value = LocalTime.now()
                }
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = currentTime.value.format(DateTimeFormatter.ofPattern("HH:mm:ss")),
                color = TextPrimary,
                fontSize = 12.sp
            )
        }
    }
}
