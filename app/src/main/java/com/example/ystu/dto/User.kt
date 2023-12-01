package com.example.ystu.dto

data class UserDTO(
    val id: String,
    val name: String,
    val username: String,
    val email: String,
    val address: UserAddress,
    val phone: String,
    val website: String,
    val company: UserCompany,
)


data class UserAddress(
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String,
    val geo: AddressGeo,
)

data class AddressGeo(
    val lat: String,
    val zipcode: String,
)
data class UserCompany(
    val name: String,
    val catchPhrase: String,
    val bs: String,
)