package com.example.vk_friends.activities

import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity

import com.example.vk_friends.R
import com.example.vk_friends.views.LoginView

class LoginActivity : MvpAppCompatActivity(), LoginView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun startLoading() {
        TODO("Not yet implemented")
    }

    override fun endLoading() {
        TODO("Not yet implemented")
    }

    override fun openFriends() {
        TODO("Not yet implemented")
    }

    override fun showError(text: String) {
        TODO("Not yet implemented")
    }
}