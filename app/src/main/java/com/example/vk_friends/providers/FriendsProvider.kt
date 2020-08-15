package com.example.vk_friends.providers

import android.os.Handler
import com.example.vk_friends.models.FriendModel
import com.example.vk_friends.models.VKFriendsRequest
import com.example.vk_friends.models.VKUser
import com.example.vk_friends.presenters.FriendsPresenter
import com.vk.api.sdk.VK
import com.vk.api.sdk.VKApiCallback

class FriendsProvider(var presenter: FriendsPresenter) {
    fun testLoadFriends(hasFriends: Boolean) {
        Handler().postDelayed({
            val friendsList: ArrayList<FriendModel> = ArrayList()
            if(hasFriends) {
                val friend1 = FriendModel(name = "Иван", surname = "Иванов", city = null,
                    avatar = "https://upload.wikimedia.org/wikipedia/ru/8/86/%D0%98%D0%B2%D0%B0%D0%BD_%D0%98%D0%B2%D0%B0%D0%BD%D0%BE%D0%B2%D0%B8%D1%87_%D0%9F%D0%B5%D1%82%D1%80%D0%BE%D0%B2_%28%D0%BF%D0%B5%D0%B2%D0%B5%D1%86%29.jpg",
                    isOnline = true)
                val friend2 = FriendModel(name = "Даниил", surname = "Шипицын", city = "Йошкар-Ола",
                    avatar = "https://upload.wikimedia.org/wikipedia/ru/8/86/%D0%98%D0%B2%D0%B0%D0%BD_%D0%98%D0%B2%D0%B0%D0%BD%D0%BE%D0%B2%D0%B8%D1%87_%D0%9F%D0%B5%D1%82%D1%80%D0%BE%D0%B2_%28%D0%BF%D0%B5%D0%B2%D0%B5%D1%86%29.jpg",
                    isOnline = true)
                val friend3 = FriendModel(name = "Ivan", surname = "Иванов", city = "ForSearch",
                    avatar = "https://upload.wikimedia.org/wikipedia/ru/8/86/%D0%98%D0%B2%D0%B0%D0%BD_%D0%98%D0%B2%D0%B0%D0%BD%D0%BE%D0%B2%D0%B8%D1%87_%D0%9F%D0%B5%D1%82%D1%80%D0%BE%D0%B2_%28%D0%BF%D0%B5%D0%B2%D0%B5%D1%86%29.jpg",
                    isOnline = true)
                friendsList.add(friend1)
                friendsList.add(friend2)
                friendsList.add(friend3)
            }
            presenter.friendsLoaded(friendsList)
        }, 200)
    }

    fun loadFriends() {
        VK.execute(VKFriendsRequest(),object: VKApiCallback<List<VKUser>> {

            override fun success(result: List<VKUser>) {
                val friendsList: ArrayList<FriendModel> = ArrayList()

                result.forEach{
                    val friend: FriendModel = FriendModel(name = it.firstName, surname = it.lastName, city = "", avatar = it.photo, isOnline = false)
                    friendsList.add(friend)
                }
                presenter.friendsLoaded(friendsList)

            }

            override fun fail(error: Exception) {
                presenter.showError(error)
            }
        })

    }
}