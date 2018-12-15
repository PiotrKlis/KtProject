package com.example.piotr.ktproject

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

data class User(val test: String)

class UserProfileViewModel : ViewModel() {

    private var userId: String? = null
    private val user: User? = null

    fun init(userId: String?) {
        this.userId = userId
    }

    fun getUser(): User? {
        return user
    }
}

class UserProfileFragment : Fragment() {
    private val UID_KEY: String = "uid"
    private lateinit var viewModel: UserProfileViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val userId = arguments?.getString(UID_KEY)
        viewModel = ViewModelProviders.of(this).get(UserProfileViewModel().javaClass)
        viewModel.init(userId)

        val user: User = User("")
        userMethod(user)

    }

    fun userMethod(user: User) {

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    companion object {
        private val UID_KEY = "uid"
    }
}
