package com.example.noteappfirebase.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteappfirebase.model.UsersModel
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth
    var showAlert by mutableStateOf(false)

    fun login(Email: String, Password: String, onSuccess: () -> Unit) {
        try {
            auth.signInWithEmailAndPassword(Email, Password)
                .addOnCompleteListener { tasks ->
                    if (tasks.isSuccessful) {
                        onSuccess()
                    } else {
                        Log.d("Error Firebase", "ERROR Usuario y contraseña incorrecta")
                        showAlert = true
                    }
                }

        } catch (e: Exception) {
            Log.d("Error login", "ERROR ${e.localizedMessage}")
        }
    }


    fun createUaer(Email: String, username: String, Password: String, onSuccess: () -> Unit) {
        try {
            auth.createUserWithEmailAndPassword(Email, Password)
                .addOnCompleteListener { tasks ->
                    if (tasks.isSuccessful) {
                        saveUser(username)
                        onSuccess()
                    } else {
                        Log.d("Error Firebase", "ERROR Usuario y contraseña incorrecta")
                        showAlert = true
                    }
                }

        } catch (e: Exception) {
            Log.d("Error login", "ERROR ${e.localizedMessage}")
        }
    }

    private fun saveUser(Username: String) {
        val id = auth.currentUser?.uid
        val email = auth.currentUser?.email

        viewModelScope.launch(Dispatchers.IO) {
            val user = UsersModel(
                userid = id.toString(),
                email = email.toString(),
                username = Username
            )

            FirebaseFirestore.getInstance().collection("Users")
                .add(user)
                .addOnSuccessListener {
                    Log.d(" GUARDADO", "GUARDO Correctamente!!")
                }.addOnFailureListener {
                    Log.d("ERROR AL GUARDAR", "ERROR al guardar en firestore")
                }
        }


    }

    fun closeAlert() {
        showAlert = false
    }
}