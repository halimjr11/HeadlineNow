package com.halimjr11.headlinenow.ui.theme

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.text.googlefonts.Font
import com.halimjr11.headlinenow.R

val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

// Merriweather (Serif, untuk headline)
val Merriweather = FontFamily(
    Font(
        googleFont = GoogleFont("Merriweather"),
        fontProvider = provider
    )
)

// Inter (Sans-serif, untuk body)
val Inter = FontFamily(
    Font(
        googleFont = GoogleFont("Inter"),
        fontProvider = provider
    )
)