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
    open var id:Long? = null,
    open var firstName: String,
    open var lastName: String,
    open var phoneNumber: String,
    open var email: String,
    open var app: String,
    open var date: LocalDateTime?,
) {


}