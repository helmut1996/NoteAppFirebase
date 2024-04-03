package com.example.noteappfirebase.views.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth

@Composable
fun SplashScreen(navController: NavController) {

    LaunchedEffect(Unit) {
        if (!FirebaseAuth.getInstance().currentUser?.email.isNullOrEmpty()) {
            navController.navigate("Home")
        } else {
            navController.navigate("Login")
        }

    }

}