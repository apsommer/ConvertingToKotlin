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
    val formattedUserNames: List<String?> get() {

        // create list of user names
        val userNames = ArrayList<String>(users.size)

        // build list of names using "destructing declaration"
        for ((firstName, lastName) in users) {

            // format display name
            val name = if (lastName != null) {
                if (firstName != null) "$firstName $lastName"
                else lastName
            } else firstName ?: "Unknown"

            // add formatted name to list
            userNames.add(name)
        }

        return userNames
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