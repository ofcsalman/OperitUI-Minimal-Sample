package com.operit.ui.sample.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.operit.ui.sample.navigation.Screen

data class ToolCard(
    val title: String,
    val description: String
)

@Composable
fun ToolboxScreen(onNavigate: (Screen) -> Unit) {
    val tools = listOf(
        ToolCard("Extra Info Injection", "Inject time, battery, weather, location, current screen ap..."),
        ToolCard("Linux SSH Manager", "Linux SSH toolkit powered by terminal integration for ..."),
        ToolCard("QQ Bot Settings", "Expose Tencent QQ Bot configuration, background ..."),
        ToolCard("Remote Operit Setup", "Let the current Operit call another Operit device over ..."),
        ToolCard("Windows Quick Setup", "Windows one-click setup and control bundle"),
        ToolCard("Tool Test Center", "Test the availability and functionality of AI tools"),
        ToolCard("File Manager", "Browse and manage device files with various operatio..."),
        ToolCard("Text-to-Speech", "Convert text to speech with adjustable speed and pitch")
    )

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
                "Toolbox",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.width(48.dp))
        }

        // Grid of tools
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(tools.size) { index ->
                ToolCardItem(tools[index])
            }
        }
    }
}

@Composable
fun ToolCardItem(tool: ToolCard) {
    Card(
        modifier = Modifier
            .height(180.dp)
            .clickable { /* Mock click */ },
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF2A2635)
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Surface(
                modifier = Modifier
                    .size(60.dp),
                shape = RoundedCornerShape(12.dp),
                color = Color(0xFF6C63FF)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Text("⚙", fontSize = 32.sp)
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                tool.title,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                tool.description,
                fontSize = 11.sp,
                color = Color(0xFFB0B0B0),
                maxLines = 2
            )
        }
    }
}