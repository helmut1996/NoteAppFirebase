package com.example.noteappfirebase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.noteappfirebase.navigation.NavManager
import com.example.noteappfirebase.ui.theme.NoteAppFirebaseTheme
import com.example.noteappfirebase.viewmodel.LoginViewModel
import com.example.noteappfirebase.viewmodel.NotesViewModel
import com.example.noteappfirebase.views.login.TabsView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val loginVM : LoginViewModel by viewModels ()
        val notesVM : NotesViewModel by viewModels ()
        setContent {
            NoteAppFirebaseTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavManager(loginVM = loginVM, notesVM =notesVM )
                }
            }
        }
    }
}

