package com.example.utaronew

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import com.example.utaronew.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bindingclass: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingclass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingclass.root)
    }
}