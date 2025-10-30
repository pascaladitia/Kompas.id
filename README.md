# Kompas.id by Pascal Aditia Muclis

## Features

- **Dark Mode**: Seamlessly switch between light and dark themes.  
- **Audio Playback**: Stream and play audio with smooth controls.  
- **Bookmark**: Save your favorite content for quick access.  
- **Share**: Easily share content with others via Android sharing intent.  
- **Reusable Components**: Clean, composable UI components for fast development.  
- **Smooth Animations**: Includes transitions, fade-ins, and **shared element transitions** for enhanced UX.  

## Tech Stack

- **Language**: Kotlin  
- **UI Framework**: Jetpack Compose  
- **Networking**: Ktor (HTTP client)  
- **Local Storage**: Room Database & DataStore  
- **Serialization**: Kotlin Serialization  
- **Architecture**: MVVM + Clean Architecture  
- **Animations**: Compose Animations, Shared Element Transitions  

## Architecture

This project follows **Clean Architecture principles** to separate concerns and ensure maintainability:  

- **MVVM Pattern**: ViewModels handle UI state and communicate with Use Cases.  
- **Repositories**: Abstract data sources (network & local).  
- **Use Cases**: Encapsulate business logic for a clean separation of concerns.  


