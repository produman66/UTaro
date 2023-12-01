package com.example.utaronew.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.utaronew.R
import com.example.utaronew.data.models.Firebase.UserModel
import com.example.utaronew.databinding.SignUpBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignUp : Fragment() {

    private lateinit var binding: SignUpBinding
    private lateinit var database: FirebaseDatabase
    private lateinit var reference: DatabaseReference

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = SignUpBinding.inflate(inflater, container, false)
        binding.signupButton.setOnClickListener{
            findNavController().navigate(R.id.action_signUp_to_taroMain)
            // Инициализация Firebase
            database = FirebaseDatabase.getInstance()
            reference = database.getReference("USERS")

            val name = binding.signupName.text.toString()
            val email = binding.signupEmail.text.toString()
            val username = binding.signupUsername.text.toString()
            val pass = binding.signupPassword.text.toString()
            Toast.makeText(requireContext(), "Регистрация успешно завершена", Toast.LENGTH_SHORT).show()
            val user = UserModel(name, email, username, pass)
            reference.child(email).setValue(user).addOnSuccessListener {

                binding.signupEmail.text.clear()
                binding.signupPassword.text.clear()
                binding.signupUsername.text.clear()
                binding.signupName.text.clear()
                Toast.makeText(requireContext(), "Регистрация успешно завершена", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_signUp_to_taroMain)
            }.addOnFailureListener{
                Toast.makeText(requireContext(), "Fuck", Toast.LENGTH_SHORT).show()
            }
        }

        binding.loginRedirectText.setOnClickListener{
            findNavController().popBackStack()
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}