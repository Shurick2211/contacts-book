package com.nimko.contactbook.services

import com.nimko.contactbook.dto.PersonDto
import com.nimko.contactbook.models.Person
import com.nimko.contactbook.repo.PersonsRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import javax.validation.ConstraintViolationException


@Service
class PersonsServices @Autowired constructor(
    val db:PersonsRepo
){
    fun getAll():ResponseEntity<List<Person>>{
        return ResponseEntity.ok(db.findAll())
    }

    fun create(dto:PersonDto): ResponseEntity<Person> {
        if (db.findByEmail(dto.email).isEmpty && db.findByPhoneNumber(dto.phoneNumber).isEmpty){
            val person = db.save(Person(null,dto.firstName,dto.lastName,dto.phoneNumber, dto.email, dto.app,dto.date))
            return ResponseEntity.status(HttpStatus.CREATED).body(person)
        } else throw Exception("Person is in database with this phone number or email")
    }

    fun getOneByPhone(phone:String):ResponseEntity<Person>{
        val person = db.findByPhoneNumber(phone).orElseThrow(::NotFoundException)
        return ResponseEntity.ok(person)



    }

    fun getOneByEmail(email:String):ResponseEntity<Person>{
        val person = db.findByEmail(email).orElseThrow(::NotFoundException)
        return ResponseEntity.ok(person)
    }
}

