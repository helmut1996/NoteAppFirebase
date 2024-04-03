package com.example.noteappfirebase.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.noteappfirebase.viewmodel.LoginViewModel
import com.example.noteappfirebase.viewmodel.NotesViewModel
import com.example.noteappfirebase.views.login.SplashScreen
import com.example.noteappfirebase.views.login.TabsView
import com.example.noteappfirebase.views.notes.HomeView

@Composable
fun NavManager(loginVM:LoginViewModel, notesVM:NotesViewModel){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Splash") {
        composable("Splash"){
            SplashScreen(navController)
        }

        composable("Login"){
            TabsView(navController, loginVM)
        }

        composable("Home"){
            HomeView(notesVM,navController)
        }
    }
}