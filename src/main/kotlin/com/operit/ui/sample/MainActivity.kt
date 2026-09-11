package com.operit.ui.sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.operit.ui.sample.screens.AIChatScreen
import com.operit.ui.sample.screens.ModelConfigScreen
import com.operit.ui.sample.screens.PermissionScreen
import com.operit.ui.sample.screens.SetupWorkspaceScreen
import com.operit.ui.sample.screens.ToolboxScreen
import com.operit.ui.sample.theme.OperitTheme
import com.operit.ui.sample.navigation.Screen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OperitTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val currentScreen = remember { mutableStateOf<Screen>(Screen.Toolbox) }

                    when (currentScreen.value) {
                        Screen.Toolbox -> ToolboxScreen { currentScreen.value = it }
                        Screen.Setup -> SetupWorkspaceScreen { currentScreen.value = it }
                        Screen.Chat -> AIChatScreen { currentScreen.value = it }
                        Screen.ModelConfig -> ModelConfigScreen { currentScreen.value = it }
                        Screen.Permissions -> PermissionScreen { currentScreen.value = it }
                        Screen.Navigation -> {} // Drawer navigation
                    }
                }
            }
        }
    }
}