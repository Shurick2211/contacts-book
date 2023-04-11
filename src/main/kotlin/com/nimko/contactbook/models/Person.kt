package com.nimko.contactbook.models


import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id


@Entity
data class Person(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id:Long,
    val firstName : String,
    val lastName : String,
    val phoneNumber : String,
    val email : String,
    val app : String,
    val date : LocalDateTime
) {


}