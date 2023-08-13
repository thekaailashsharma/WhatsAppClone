package com.example.kmp.ui.theme

import platform.UIKit.UIScreen
import platform.UIKit.UIUserInterfaceStyle

actual fun isSystemInDarkTheme(): Boolean {
    return UIScreen.mainScreen.traitCollection.userInterfaceStyle ==
            UIUserInterfaceStyle.UIUserInterfaceStyleDark
}