package com.nimko.contactbook.services

import com.nimko.contactbook.dto.PersonDto
import com.nimko.contactbook.models.Person
import com.nimko.contactbook.repo.PersonsRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.time.LocalDateTime


@Service
class PersonServices @Autowired constructor(
    val db:PersonsRepo
){
    fun getAll():ResponseEntity<List<Person>>{
        return ResponseEntity.ok(db.findAll())
    }

    fun create(dto:PersonDto): ResponseEntity<Person> {
        if (db.findByEmail(dto.email).isEmpty && db.findByPhoneNumber(dto.phoneNumber).isEmpty){
            var date = dto.date ?: LocalDateTime.now()
            val person = db.save(
                Person(null,dto.firstName,dto.lastName,dto.phoneNumber, dto.email, dto.app, date))
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

    fun update(dto: PersonDto): ResponseEntity<Person> {
        val person =
            if(db.findById(dto.id!!).isPresent) {
                db.save(
                Person(
                    dto.id,
                    dto.firstName,
                    dto.lastName,
                    dto.phoneNumber,
                    dto.email,
                    dto.app,
                    LocalDateTime.now()
                ))
            } else {
                throw NotFoundException()
            }
       return ResponseEntity.status(HttpStatus.ACCEPTED).body(person)
    }

    fun delete(id:Long): ResponseEntity<Any>{
        if(db.findById(id).isPresent) {
            db.deleteById(id)
        } else {
            throw NotFoundException()
        }
        return ResponseEntity.ok().build()
    }
}

