package com.example.utaronew.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.utaronew.R
import com.example.utaronew.databinding.LoginBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Query
import com.google.firebase.database.ValueEventListener

class Login : Fragment() {

    lateinit var binding: LoginBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = LoginBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginButton.setOnClickListener{
            if (!validateEmail() || !validatePassword()){

            }else{
                checkUser()
            }
        }
        binding.signupRedirectText.setOnClickListener {
            findNavController().navigate(R.id.action_login_to_signUp)
        }

    }

    fun validateEmail(): Boolean{
        val value = binding.loginEmail.text.toString()
        if (value.isEmpty()){
            binding.loginEmail.setError("Логин не может быть пустым")
            return false
        }
        else{
            binding.loginEmail.setError(null)
            return true
        }
    }
    fun validatePassword(): Boolean{
        val value = binding.loginPassword.text.toString()
        if (value.isEmpty()){
            binding.loginPassword.setError("Пароль не может быть пустым")
            return false
        }
        else{
            binding.loginPassword.setError(null)
            return true
        }
    }
    fun checkUser(){
        val userUsername = binding.loginEmail.text.toString().trim()
        val userPassword = binding.loginPassword.text.toString().trim()

        val reference: DatabaseReference = FirebaseDatabase.getInstance().getReference("USERS")
        val checkUserDatabase: Query = reference.orderByChild("email").equalTo(userUsername)

        checkUserDatabase.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    binding.loginEmail.error = null
                    val passwordFromDB = snapshot.child(userUsername).child("password").getValue(String::class.java)
                    if (passwordFromDB == userPassword) {
                        binding.loginEmail.error = null
                        val nameFromDB = snapshot.child(userUsername).child("name").getValue(String::class.java)
                        val emailFromDB = snapshot.child(userUsername).child("email").getValue(String::class.java)
                        val usernameFromDB = snapshot.child(userUsername).child("username").getValue(String::class.java)
                        findNavController().navigate(R.id.action_login_to_taroMain, bundleOf("nameFromDB" to nameFromDB, "emailFromDB" to emailFromDB, "usernameFromDB" to usernameFromDB))
                    } else {
                        binding.loginPassword.error = "Invalid Credentials"
                        binding.loginPassword.requestFocus()
                    }
                } else {
                    binding.loginEmail.error = "User does not exist"
                    binding.loginEmail.requestFocus()
                }
            }

            override fun onCancelled(error: DatabaseError) {
            }
        })
    }
}