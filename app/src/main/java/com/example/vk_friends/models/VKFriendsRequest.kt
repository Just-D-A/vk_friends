package com.example.vk_friends.models

import com.vk.api.sdk.requests.VKRequest
import org.json.JSONObject

class VKFriendsRequest(uids: IntArray = intArrayOf()) : VKRequest<List<VKUser>>("users.get") {
    init {
        if (uids.isNotEmpty()) {
            addParam("user_ids", uids.joinToString(","))
        }
        addParam("fields", "photo_200")
    }

    override fun parse(r: JSONObject): List<VKUser> {
        val users = r.getJSONArray("response")
        val result = ArrayList<VKUser>()
        for (i in 0 until users.length()) {
            result.add(VKUser.parse(users.getJSONObject(i)))
        }
        return result
    }
}