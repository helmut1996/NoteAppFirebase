package com.example.noteappfirebase.views.notes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.noteappfirebase.viewmodel.NotesViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(notesVM:NotesViewModel,navigationController: NavController){
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Mis Notas") },
                navigationIcon = {
                    IconButton(onClick = {
                        notesVM.logOut()
                        navigationController.popBackStack()
                    }) {
                        Icon(imageVector = Icons.Default.ExitToApp, contentDescription = "")
                    }
                }
            )
        }
    ) {padd->
        Column(
            modifier = Modifier.padding(padd),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Home View")
        }
    }
}