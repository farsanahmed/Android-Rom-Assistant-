# Android Desktop Environment

A complete PC-like desktop environment for Android phones. This project transforms an Android device into a traditional desktop computing experience with windowed applications, taskbar, file manager, and more.

## Project Status

**Phase 1: Foundation & Empty Desktop** ✅ COMPLETE

### Phase 1 Deliverables
- ✅ Android Gradle project initialized
- ✅ Jetpack Compose UI framework configured
- ✅ Hilt dependency injection wired
- ✅ Base theme system (light/dark)
- ✅ DesktopActivity with Compose integration
- ✅ Empty desktop with taskbar
- ✅ Start menu (placeholder, non-functional)
- ✅ Logging with Timber
- ✅ All Gradle and manifest configuration

### Current Features
- Blank desktop environment
- Taskbar at bottom with Start button and clock
- Start menu overlay (toggles, shows placeholder text)
- Dark theme with desktop-specific color palette
- Responsive to screen size
- Logging for debugging

## Build & Run

### Prerequisites
- Android SDK API 24+ (minimum)
- Android Gradle Plugin 8.1+
- Gradle 8.5+
- Kotlin 1.9.20+
- Java 11+
- Physical Android device or emulator (4+ GB RAM recommended)

### Building

```bash
# Clone repository
git clone https://github.com/farsanahmed/Android-Rom-Assistant-.git
cd Android-Rom-Assistant-

# Create Gradle wrapper (if not already present)
gradle wrapper --gradle-version=8.5

# Build debug APK
./gradlew clean assembleDebug

# Install on device/emulator
./gradlew installDebug

# Launch app
adb shell am start -n com.android.desktop/.app.DesktopActivity

# View logs
adb logcat -s "DesktopActivity:*" "AndroidRuntime:E"
```

### Quick Build & Run

```bash
./gradlew installDebug && adb shell am start -n com.android.desktop/.app.DesktopActivity
```

## Architecture

### Current (Phase 1)
```
app/
├── src/main/
│   ├── AndroidManifest.xml
│   ├── kotlin/com/android/desktop/
│   │   ├── App.kt (Hilt Application)
│   │   ├── app/
│   │   │   └── DesktopActivity.kt (Entry point)
│   │   └── ui/
│   │       ├── desktop/
│   │       │   └── DesktopScreen.kt (Main desktop)
│   │       ├── taskbar/
│   │       │   └── TaskbarScreen.kt (Taskbar with clock)
│   │       ├── startmenu/
│   │       │   └── StartMenuScreen.kt (Start menu overlay)
│   │       └── theme/
│   │           ├── Color.kt
│   │           ├── Type.kt
│   │           └── Theme.kt
│   └── res/
│       ├── values/
│       │   ├── strings.xml
│       │   ├── colors.xml
│       │   ├── themes.xml
│       │   ├── dimens.xml
│       │   └── themes/
│       │       └── styles.xml
│       └── mipmap-*/
└── build.gradle.kts
```

### Dependencies (Phase 1)
- **Jetpack Compose**: UI framework
- **Hilt**: Dependency injection
- **Lifecycle/ViewModel**: State management
- **Coroutines**: Async operations
- **Room**: Database (prepared, not yet used)
- **DataStore**: Preferences (prepared, not yet used)
- **Timber**: Logging

## Next Phase: Phase 2 - Desktop Shell

Phase 2 will implement:
- Polished desktop workspace
- Enhanced taskbar with system indicators
- Functional Start menu with app launcher
- Desktop search interface
- Wallpaper support
- System tray placeholders
- Improved responsive layout

## Known Limitations (Phase 1)

- Start menu is non-functional (no apps to display)
- No window management yet
- No file manager
- No terminal
- No settings screen
- Desktop state not persisted
- No app icons
- Theme switching not implemented

All limitations are planned for future phases.

## Development Notes

### Logging
The app uses Timber for structured logging. Check logs with:
```bash
adb logcat | grep "Desktop"
```

### Code Structure
- **MVVM Pattern**: ViewModels manage state, Composables are stateless
- **Repository Pattern**: All data access through repositories (prepared for Phase 2+)
- **Reactive**: StateFlow for reactive state management
- **Dependency Injection**: Hilt provides all dependencies

### Performance Target
- Baseline memory: ~80-120 MB
- Supported devices: 3-4 GB RAM minimum
- No unnecessary background processes
- Hardware-accelerated rendering

## Testing

### Unit Tests
```bash
./gradlew testDebugUnitTest
```

### Instrumented Tests (Requires device/emulator)
```bash
./gradlew connectedDebugAndroidTest
```

## Roadmap

| Phase | Title | Status | ETA |
|-------|-------|--------|-----|
| 1 | Foundation & Empty Desktop | ✅ Complete | - |
| 2 | Desktop Shell | 📅 Planned | Week 2 |
| 3 | Window Manager (Core) | 📅 Planned | Week 3-4 |
| 4 | Android App Integration | 📅 Planned | Week 4-5 |
| 5 | File Manager | 📅 Planned | Week 5-6 |
| 6 | Terminal (Basic) | 📅 Planned | Week 6-7 |
| 7 | Settings & Customization | 📅 Planned | Week 7-8 |
| 8 | Notifications & System Tray | 📅 Planned | Week 8-9 |
| 9 | Polish & Performance | 📅 Planned | Week 9-10 |
| 10 | Final Release | 📅 Planned | Week 10-11 |

## Contributing

This is an active development project. Contributions welcome once we reach a stable Phase 2+.

## License

TBD

## Contact

Created by: farsanahmed
GitHub: [@farsanahmed](https://github.com/farsanahmed)
