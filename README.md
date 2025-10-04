# 📰 HeadlineNow  

HeadlineNow is a **modern, fast, and reliable news application** built with the latest Android technologies.  
It delivers **up-to-date headlines** from multiple trusted sources through [NewsAPI](https://newsapi.org),  
allowing users to **stay informed anywhere, anytime**.  

---

## ✨ Features
- 🌍 Browse top headlines from trusted sources
- 📱 Smooth and responsive **Jetpack Compose UI**
- 🎬 Lottie animations for delightful user experience
- 📂 Clean Architecture with MVVM design pattern
- ⚡ Optimized and lightweight

---

## 🛠 Tech Stack
- **Kotlin** – Modern language for Android
- **Jetpack Compose** – Declarative UI framework
- **MVVM + Clean Architecture** – For maintainable & scalable code
- **Retrofit2 + OkHttp3** – REST API client
- **Coroutines + StateFlow** – Asynchronous & reactive programming
- **Hilt (Dagger)** – Dependency Injection
- **Coil** – Image loading with caching
- **Lottie** – Beautiful animations
- **Navigation Compose** – In-app navigation

---

## 📐 Architecture
The app follows **Clean Architecture + MVVM** pattern:

```
Presentation (Jetpack Compose, ViewModel, StateFlow)
       ↓
Domain (UseCases, Domain Models)
       ↓
Data (Repository, Retrofit API, Local/Remote data sources)
```

This separation of concerns ensures **testability, scalability, and maintainability**.

---

## 🚀 Getting Started

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/HeadlineNow.git
   ```
2. Open the project in **Android Studio (Giraffe+ or latest)**.
3. Add your NewsAPI key in `local.properties`:
   ```properties
   NEWS_API_KEY=your_api_key_here
   ```
4. Build and run the app 🚀

---

## 📸 Screenshots (optional)
![HeadlineNow Splash](screenshots/splash.jpeg)
![HeadlineNow Main](screenshots/main.jpeg)
![HeadlineNow Detail](screenshots/detail.jpeg)
---

## 📄 License
```
Copyright (c) 2025 Your Name

Licensed under the MIT License.  
You may obtain a copy of the License at

    https://opensource.org/licenses/MIT
```

---

## 🙌 Acknowledgements
- [NewsAPI](https://newsapi.org) for providing the news data.
- Jetpack Compose & Android Dev community for modern Android tools.

---
