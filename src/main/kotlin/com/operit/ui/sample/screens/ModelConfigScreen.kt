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
fun ModelConfigScreen(onNavigate: (Screen) -> Unit) {
    var apiProvider by remember { mutableStateOf("OpenAI") }
    var apiEndpoint by remember { mutableStateOf("https://api.openai.com/v1") }
    var apiKey by remember { mutableStateOf("sk-****") }
    var modelName by remember { mutableStateOf("gpt-4") }
    var visionEnabled by remember { mutableStateOf(true) }
    var audioEnabled by remember { mutableStateOf(false) }

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
                "Model Configuration",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.width(48.dp))
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                ConfigField("API Provider", apiProvider) { apiProvider = it }
            }
            item {
                ConfigField("API Endpoint", apiEndpoint) { apiEndpoint = it }
            }
            item {
                ConfigField("API Key", apiKey) { apiKey = it }
            }
            item {
                ConfigField("Model Name", modelName) { modelName = it }
            }
            item {
                ConfigToggle("Vision", visionEnabled) { visionEnabled = it }
            }
            item {
                ConfigToggle("Audio", audioEnabled) { audioEnabled = it }
            }
            item {
                Button(
                    onClick = { /* Save config */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6C63FF))
                ) {
                    Text("Save Configuration", fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

@Composable
fun ConfigField(label: String, value: String, onChange: (String) -> Unit) {
    Column {
        Text(label, fontWeight = FontWeight.Bold, fontSize = 12.sp, color = Color(0xFF6C63FF))
        OutlinedTextField(
            value = value,
            onValueChange = onChange,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Color(0xFF2A2635),
                focusedBorderColor = Color(0xFF6C63FF),
                unfocusedTextColor = Color.White,
                focusedTextColor = Color.White
            )
        )
    }
}

@Composable
fun ConfigToggle(label: String, value: Boolean, onChange: (Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(label, color = Color.White, fontWeight = FontWeight.Bold)
        Switch(
            checked = value,
            onCheckedChange = onChange,
            colors = SwitchDefaults.colors(checkedThumbColor = Color(0xFF6C63FF))
        )
    }
}