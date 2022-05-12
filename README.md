# Permissions
Android categorizes permissions into different types
- install-time permissions
- runtime permissions 
- special permissions </br>
Runtime permissions, also known as dangerous permissions, give your app additional access to restricted data, and they allow your app to
perform restricted actions that more substantially affect the system and other apps. Therefore, you need to request runtime permissions in
your app before you can access the restricted data or perform restricted actions. When your app requests a runtime permission, the system 
presents a runtime permission prompt.

## Overview
In this application, asking following Runtime Permissions
- WRITE_EXTERNAL_STORAGE
- ACCESS_COARSE_LOCATION
- ACCESS_BACKGROUND_LOCATION

Displaying in Log, permissions granted by user.

## Working 
![Screenshot (23)](https://user-images.githubusercontent.com/56642290/168093242-3b2b9c55-f4a0-4944-bcdf-cd3f280edd08.png)
<p align="center"> Fig i. Asking for location permission </p> 

![Screenshot (24)](https://user-images.githubusercontent.com/56642290/168093254-062b49a4-3781-4318-82cd-3e2656c5dd0a.png)
<p align="center"> Fig ii. Asking for storage permission </p>

![Screenshot (26)](https://user-images.githubusercontent.com/56642290/168093260-e4315f76-463e-45ff-aef6-c6adf60a5022.png)
<p align="center"> Fig iii. Permissions granted by user displayed in Log </p>

## Requirements
- Android version below 10

## Note
On earlier versions of Android (before API Level 29), when your app receives foreground location access,
it automatically receives background location access as well

## References
- https://developer.android.com/guide/topics/permissions/overview
- https://www.youtube.com/watch?v=S4jkcRhembY

