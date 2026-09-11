package com.operit.ui.sample.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.operit.ui.sample.navigation.Screen

@Composable
fun AIChatScreen(onNavigate: (Screen) -> Unit) {
    var showBottomSheet by remember { mutableStateOf(false) }
    var thinkingMode by remember { mutableStateOf(true) }
    var maxMode by remember { mutableStateOf(false) }
    var thinkingIntensity by remember { mutableStateOf(2f) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        // Header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primary)
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { onNavigate(Screen.Navigation) }) {
                Icon(Icons.Default.Menu, contentDescription = "Menu", tint = Color.White)
            }
            Text(
                "AI Chat - New Conversation",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.width(48.dp))
        }

        // Chat messages
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(3) {
                ChatBubble("Prompt", true)
                ChatBubble("Hi", false)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }

        // Input area
        Button(
            onClick = { showBottomSheet = true },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6C63FF))
        ) {
            Text("Show Settings")
        }
    }

    if (showBottomSheet) {
        BottomSheetSettings(
            thinkingMode = thinkingMode,
            onThinkingModeChange = { thinkingMode = it },
            maxMode = maxMode,
            onMaxModeChange = { maxMode = it },
            thinkingIntensity = thinkingIntensity,
            onThinkingIntensityChange = { thinkingIntensity = it },
            onDismiss = { showBottomSheet = false }
        )
    }
}

@Composable
fun ChatBubble(text: String, isUser: Boolean) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = if (isUser) Alignment.CenterEnd else Alignment.CenterStart
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth(0.8f),
            shape = RoundedCornerShape(12.dp),
            color = if (isUser) Color(0xFF6C63FF) else Color(0xFF2A2635)
        ) {
            Text(
                text,
                color = Color.White,
                modifier = Modifier.padding(12.dp)
            )
        }
    }
}

@Composable
fun BottomSheetSettings(
    thinkingMode: Boolean,
    onThinkingModeChange: (Boolean) -> Unit,
    maxMode: Boolean,
    onMaxModeChange: (Boolean) -> Unit,
    thinkingIntensity: Float,
    onThinkingIntensityChange: (Float) -> Unit,
    onDismiss: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.6f),
        color = Color(0xFF1A1922),
        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                "Thinking: mode",
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = Color.White
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Thinking Mode", color = Color.White)
                Switch(
                    checked = thinkingMode,
                    onCheckedChange = onThinkingModeChange,
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Color(0xFF6C63FF)
                    )
                )
            }

            Text("Thinking intensity: $thinkingIntensity", color = Color.White, fontSize = 12.sp)
            Slider(
                value = thinkingIntensity,
                onValueChange = onThinkingIntensityChange,
                valueRange = 1f..5f,
                modifier = Modifier.fillMaxWidth()
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Max Mode", color = Color.White)
                Switch(
                    checked = maxMode,
                    onCheckedChange = onMaxModeChange,
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Color(0xFF6C63FF)
                    )
                )
            }

            Text("Model: gemini-3.8-flash", color = Color.White, fontSize = 12.sp)
            Text(
                "Default Config",
                color = Color(0xFF6C63FF),
                fontSize = 12.sp,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}