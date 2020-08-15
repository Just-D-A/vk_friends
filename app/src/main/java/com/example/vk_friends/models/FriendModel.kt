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

    fun setEmptyAvatar() {
        avatar = "https://upload.wikimedia.org/wikipedia/ru/8/86/%D0%98%D0%B2%D0%B0%D0%BD_%D0%98%D0%B2%D0%B0%D0%BD%D0%BE%D0%B2%D0%B8%D1%87_%D0%9F%D0%B5%D1%82%D1%80%D0%BE%D0%B2_%28%D0%BF%D0%B5%D0%B2%D0%B5%D1%86%29.jpg"
    }

    fun getIsOnline(): Boolean {
        return isOnline
    }
}