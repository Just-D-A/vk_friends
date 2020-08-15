package com.example.vk_friends.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.vk_friends.R
import com.example.vk_friends.models.FriendModel
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

@Suppress("NAME_SHADOWING")
class FriendsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var mFriendsList: ArrayList<FriendModel> = ArrayList()
    var mSourceList: ArrayList<FriendModel> = ArrayList()

    fun setupFriends(friendsList: ArrayList<FriendModel>) {
        mSourceList.clear()
        mSourceList.addAll(friendsList)
        filter(query = "")
    }

    fun filter(query: String) {
        mFriendsList.clear()
        mSourceList.forEach {
            if ((it.getName().contains(query, ignoreCase = true)) || (it.getSurname()
                    .contains(query, ignoreCase = true))
            ) {
                mFriendsList.add(it)
            } else {
                val city = it.getCity()
                city?.let { city ->
                    if (city.contains(query, ignoreCase = true)) {
                        mFriendsList.add(it)
                    }
                }
            }
        }
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is FriendsViewHolder) {
            holder.bind(friendModel = mFriendsList[position])
        }
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
        private var mCivAvatar: CircleImageView = itemView.findViewById(R.id.friend_civ_avatar)
        private var mTxtName: TextView = itemView.findViewById(R.id.friend_txt_name)
        private var mTxtCity: TextView = itemView.findViewById(R.id.friend_txt_city)
        private var mImgIsOnline: View = itemView.findViewById(R.id.friend_img_online)

        @SuppressLint("SetTextI18n")
        fun bind(friendModel: FriendModel) {
            if(friendModel.getAvatar() == null) {
                friendModel.setEmptyAvatar()
            }
            friendModel.getAvatar()?.let { url ->
                Picasso.get().load(url)
                    .into(mCivAvatar)
            }
            mTxtName.text = "${friendModel.getName()} ${friendModel.getSurname()}"
            mTxtCity.text = itemView.context.getString(R.string.friend_no_city)
            friendModel.getCity()?.let { mTxtCity.text = "${friendModel.getCity()}" }
            if (friendModel.getIsOnline()) {
                mImgIsOnline.visibility = View.VISIBLE
            } else {
                mImgIsOnline.visibility = View.GONE
            }
        }
    }
}