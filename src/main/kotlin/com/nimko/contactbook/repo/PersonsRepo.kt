package com.nimko.contactbook.repo

import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber
import com.nimko.contactbook.models.Person
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional


interface PersonsRepo:JpaRepository<Person,Long> {
    fun findByEmail(email:String):Optional<Person>
    fun findByPhoneNumber(phoneNumber:String):Optional<Person>
}