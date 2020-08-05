package com.example.vk_friends.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.vk_friends.R
import com.example.vk_friends.models.FriendModel

class FriendsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var mFriendsList: ArrayList<FriendModel> = ArrayList()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val itemView = layoutInflater.inflate(R.layout.cell_friend, parent, false)
        return FriendsViewHolder(itemView = itemView)
    }

    override fun getItemCount(): Int {
        return mFriendsList.count()
    }

    class FriendsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}