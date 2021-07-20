package com.example.convertingtokotlin

// extension property
val User.formattedName: String
    get() {
        return if (lastName != null) {
            if (firstName != null) "$firstName $lastName"
            else lastName ?: "Unknown"
        } else firstName ?: "Unknown"
    }

// object is singleton
object Repository {

    // get list of users
    private val _users = mutableListOf<User>()
    val users: List<User>
        get() = _users

    // get formatted user names
    val formattedUserNames: List<String>
        get() {
            return _users.map{ user -> user.formattedName }
        }

    // initialize some example users
    init {

        // create some users
        val user1 = User("Jane", "")
        val user2 = User("John", null)
        val user3 = User("Anne", "Doe")

        // create list of users using scope function
        _users.apply {
            add(user1)
            add(user2)
            add(user3)
        }
    }
}