package com.nimko.contactbook.models

open class Owner(
    open var firstName: String,
    open var lastName: String,
    open var phoneNumber: String,
    open var email: String,
    open var contacts:MutableList<Person>
) {
}