package com.operit.ui.sample.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import com.operit.ui.sample.navigation.Screen

data class DrawerItem(
    val label: String,
    val icon: String
)

@Composable
fun DrawerNavigation(onNavigate: (Screen) -> Unit) {
    val items = listOf(
        DrawerItem("AI Chat", "💬"),
        DrawerItem("Assistant Config", "⚙"),
        DrawerItem("Memory Base", "🧠"),
        DrawerItem("Toolbox", "🛠"),
        DrawerItem("Packages", "📦"),
        DrawerItem("Permissions", "🔐"),
        DrawerItem("Workflow", "⚡")
    )

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .width(280.dp)
            .background(Color(0xFF1A1922))
            .padding(16.dp)
    ) {
        // Header
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
        ) {
            Text(
                "Operit AI",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Color.White
            )
            Row(
                modifier = Modifier.padding(top = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("🟢", fontSize = 12.sp)
                Spacer(modifier = Modifier.width(8.dp))
                Text("WiFi", fontSize = 12.sp, color = Color(0xFFB0B0B0))
            }
        }

        // Stats
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            StatItem("39", "Packages")
            StatItem("Normal", "Permissions")
            StatItem("0", "Workflow")
        }

        // AI Features
        Text(
            "AI Features",
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            color = Color(0xFF6C63FF),
            modifier = Modifier.padding(bottom = 12.dp)
        )

        items.forEach { item ->
            DrawerItemRow(item) { onNavigate(Screen.Chat) }
        }
    }
}

@Composable
fun StatItem(value: String, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(value, fontWeight = FontWeight.Bold, fontSize = 14.sp, color = Color.White)
        Text(label, fontSize = 10.sp, color = Color(0xFFB0B0B0))
    }
}

@Composable
fun DrawerItemRow(item: DrawerItem, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(item.icon, fontSize = 20.sp)
        Spacer(modifier = Modifier.width(12.dp))
        Text(item.label, fontSize = 14.sp, color = Color.White)
    }
}