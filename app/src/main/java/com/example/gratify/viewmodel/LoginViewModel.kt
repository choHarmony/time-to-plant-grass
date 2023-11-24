package com.example.gratify.viewmodel

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.gratify.model.EncryptedGithubIdSharedPreferences
import com.example.gratify.view.MainActivity

class LoginViewModel(private val githubIdSharedPreferences: EncryptedGithubIdSharedPreferences) : ViewModel() {
    val githubId = ObservableField<String>()

    fun loginBtnClicked(view: View) {
        githubIdSharedPreferences.saveUserGithubId(githubId.get().toString())

        val intent = Intent(view.context, MainActivity::class.java)
        view.context.startActivity(intent)

        if (view.context is Activity) {
            (view.context as Activity).finish()
        }
    }



}
