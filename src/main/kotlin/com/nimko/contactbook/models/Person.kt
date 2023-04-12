package com.nimko.contactbook.models


import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDateTime
import javax.persistence.*

@Schema(name = "Схема Entity", description = "Entity for use")
@Entity
data class Person(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    var id:Long? = null,
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
    val email: String,
    val app: String,
    val date: LocalDateTime
) {


}