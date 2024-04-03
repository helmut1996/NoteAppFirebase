package com.example.noteappfirebase.model

data class UsersModel(
    val userid:String,
    val email:String,
    val username:String
){
    fun toMap(): MutableMap<String, Any>{
        return mutableMapOf(
            "userid" to this.userid,
            "email" to this.email,
            "username" to this.username,
            )
    }
}
