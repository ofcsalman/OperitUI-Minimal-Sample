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

data class PermissionItem(
    val name: String,
    val icon: String,
    val granted: Boolean
)

@Composable
fun PermissionScreen(onNavigate: (Screen) -> Unit) {
    var selectedTab by remember { mutableStateOf(0) }
    val tabs = listOf("Admin", "User", "Custom")

    val permissions = listOf(
        PermissionItem("Overlay Window", "🪟", true),
        PermissionItem("File Operations", "📁", true),
        PermissionItem("Terminal Support", "⌨️", true),
        PermissionItem("Camera", "📷", false),
        PermissionItem("Microphone", "🎤", false)
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
                "Permissions",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.width(48.dp))
        }

        // Tabs
        TabRow(
            selectedTabIndex = selectedTab,
            modifier = Modifier.fillMaxWidth(),
            containerColor = Color(0xFF1A1922),
            contentColor = Color(0xFF6C63FF)
        ) {
            tabs.forEachIndexed { index, tab ->
                Tab(
                    selected = selectedTab == index,
                    onClick = { selectedTab = index },
                    text = { Text(tab, color = if (selectedTab == index) Color.White else Color(0xFFB0B0B0)) }
                )
            }
        }

        // Permission list
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(permissions.size) { index ->
                PermissionItemRow(permissions[index])
            }
        }
    }
}

@Composable
fun PermissionItemRow(permission: PermissionItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF2A2635))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(permission.icon, fontSize = 24.sp)
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text(permission.name, color = Color.White, fontWeight = FontWeight.Bold)
                    Text(
                        if (permission.granted) "Granted" else "Denied",
                        fontSize = 11.sp,
                        color = if (permission.granted) Color(0xFF00D9FF) else Color(0xFFFF6B9D)
                    )
                }
            }
            Switch(
                checked = permission.granted,
                onCheckedChange = { /* Toggle permission */ },
                colors = SwitchDefaults.colors(checkedThumbColor = Color(0xFF6C63FF))
            )
        }
    }
}