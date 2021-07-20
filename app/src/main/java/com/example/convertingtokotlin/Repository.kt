package com.example.convertingtokotlin

import java.util.*

// object is singleton
object Repository {

    // get list of users
    private val users = mutableListOf<User>()
    fun getUsers(): List<User> {
        return users
    }

    // get formatted user names
    val formattedUserNames: List<String>
        get() {

            return users.map{ user ->
                if (user.lastName != null) {
                    if (user.firstName != null) "$user.firstName $user.lastName"
                    else user.lastName ?: "Unknown"
                } else user.firstName ?: "Unknown"
            }
        }

    // initialize some example users
    init {

        // create some users
        val user1 = User("Jane", "")
        val user2 = User("John", null)
        val user3 = User("Anne", "Doe")

        // create list of users
        users.add(user1)
        users.add(user2)
        users.add(user3)
    }
}