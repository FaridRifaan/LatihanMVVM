package com.binar.latihanmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.binar.latihanmvvm.adapter.UserAdapter
import com.binar.latihanmvvm.databinding.ActivityMainBinding
import com.binar.latihanmvvm.model.GetAllUserItem
import com.binar.latihanmvvm.network.ApiClient
import com.binar.latihanmvvm.viewmodel.UserViewModel
import retrofit2.Call
import retrofit2.Callback

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var useradapter: UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setVmAdapter()


    }

    fun setVmAdapter() {
        val viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        viewModel.getliveDataUser().observe(this, Observer {
            useradapter = it?.let { it1 -> UserAdapter(it1) }!!
            val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            binding.rvUser.layoutManager = layoutManager
            binding.rvUser.adapter = it?.let { it1 -> UserAdapter(it1) }
        })
        viewModel.callApiUser()
    }

}