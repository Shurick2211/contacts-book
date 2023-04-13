package com.nimko.contactbook.models


import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDateTime
import javax.persistence.*

@Schema(name = "Schema Entity", description = "Entity for use in database.")
@Entity
open class Person(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    var id:Long? = null,
    var firstName: String,
    var lastName: String,
    var phoneNumber: String,
    var email: String,
    var app: String,
    var date: LocalDateTime?
) {


}