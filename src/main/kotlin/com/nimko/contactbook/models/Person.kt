package com.nimko.contactbook.models


import org.hibernate.validator.constraints.UniqueElements
import java.time.LocalDateTime
import javax.persistence.*


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