package com.example.vk_friends.models

class FriendModel(
    private var name: String, private var surname: String, private var city: String?,
    private var avatar: String?, private var isOnline: Boolean
) {

    fun getName(): String {
        return name
    }

    fun getSurname(): String {
        return surname
    }

    fun getCity(): String? {
        return city
    }

    fun getAvatar(): String? {
        return avatar
    }

    fun getIsOnline(): Boolean {
        return isOnline
    }
}