package com.operit.ui.sample.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.operit.ui.sample.navigation.Screen

@Composable
fun SetupWorkspaceScreen(onNavigate: (Screen) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            "Setup Workspace",
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            color = Color.White,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        // Create Default Button
        Button(
            onClick = { onNavigate(Screen.Chat) },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .padding(bottom = 16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF6C63FF)
            ),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(
                "Create Default",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }

        // Select Existing Button
        OutlinedButton(
            onClick = { onNavigate(Screen.Chat) },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Color(0xFF6C63FF)
            ),
            shape = RoundedCornerShape(12.dp),
            border = androidx.compose.material3.BorderStroke(
                1.dp,
                Color(0xFF6C63FF)
            )
        ) {
            Text(
                "Select Existing",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}