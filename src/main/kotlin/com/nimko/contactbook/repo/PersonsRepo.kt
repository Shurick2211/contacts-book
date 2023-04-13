package com.nimko.contactbook.repo

import com.nimko.contactbook.models.Person
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*


interface PersonsRepo:JpaRepository<Person,Long> {
    fun findByEmail(email:String):Optional<Person>
    fun findByPhoneNumber(phoneNumber:String):Optional<Person>
}