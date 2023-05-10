package com.binar.latihanmvvm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.binar.latihanmvvm.databinding.ItemUserBinding
import com.binar.latihanmvvm.model.GetAllUserItem

class UserAdapter(var listUser : List<GetAllUserItem> ):  RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    class ViewHolder(var binding : ItemUserBinding) : RecyclerView.ViewHolder(binding.root)  {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.ViewHolder {
        val view = ItemUserBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: UserAdapter.ViewHolder, position: Int) {
        holder.binding.namaUser.text = listUser[position].name
        holder.binding.umurUser.text = listUser[position].age.toString()
        holder.binding.alamatUser.text = listUser[position].address

    }

    override fun getItemCount(): Int {
        return  listUser.size

    }
}