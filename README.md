# Operit UI - Minimal Jetpack Compose Sample

A minimal, runnable Jetpack Compose UI sample extracted from the Operit Android application. This sample showcases 6 key screens with mock data and no backend dependencies.

## Features

### 6 Main Screens

1. **Toolbox Screen** - Grid layout with tool cards (Extra Info Injection, Linux SSH Manager, File Manager, Text-to-Speech, etc.)
2. **Setup Workspace Screen** - Simple workspace initialization with "Create Default" and "Select Existing" options
3. **AI Chat Screen** - Chat interface with message bubbles and bottom sheet configuration panel
4. **Model Configuration Screen** - API provider and model settings with form inputs
5. **Permissions Screen** - Admin/User/Custom tabs showing permissions with toggle switches
6. **Navigation Drawer** - Left-side drawer with Operit AI header, stats, and feature menu

### UI Components
- Jetpack Compose Material 3 Design
- Custom theme with purple primary color (#6C63FF)
- Mock data states using `mutableStateOf`
- Navigation between screens
- Bottom sheet settings
- Tab layouts
- Grid layouts

## Project Structure

```
src/main/kotlin/com/operit/ui/sample/
├── MainActivity.kt              # Entry point
├── navigation/
│   └── Screen.kt               # Navigation sealed class
├── theme/
│   └── Theme.kt                # Material3 color scheme
└── screens/
    ├── ToolboxScreen.kt        # Tool grid display
    ├── DrawerNavigation.kt      # Side drawer menu
    ├── SetupWorkspaceScreen.kt  # Workspace setup
    ├── AIChatScreen.kt          # Chat interface
    ├── ModelConfigScreen.kt     # Model configuration
    └── PermissionScreen.kt      # Permissions management
```

## Running the Sample

1. Clone this repository
2. Open in Android Studio
3. Connect an Android device or start an emulator
4. Run the app: `./gradlew installDebug`

## Color Scheme

- **Primary**: #6C63FF (Purple)
- **Secondary**: #FF6B9D (Pink)
- **Tertiary**: #00D9FF (Cyan)
- **Background**: #0F0E17 (Dark)
- **Surface**: #1A1922 (Dark Gray)

## Mock Data

All state is managed with `mutableStateOf` and `remember` composables. No ViewModels, Repositories, or LLM calls are implemented. This is purely for UI demonstration.

## Based On

Extracted from: [ofcsalman/Operit](https://github.com/ofcsalman/Operit)
- Original repository: Operit - The most powerful AI agent and AI chat software on Android
- UI framework: Jetpack Compose
- Language: Kotlin

## License

MIT License - Feel free to use this as a reference or starting point for your own Jetpack Compose projects.
