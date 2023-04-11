package com.nimko.contactbook.services

import com.nimko.contactbook.dto.PersonDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class PersonsServices {
    fun getAll():ResponseEntity<String>{
        return ResponseEntity.ok("Get All")
    }

    fun create(dto:PersonDto):ResponseEntity<String>{
        return ResponseEntity.status(HttpStatus.CREATED).build()
    }

    fun getOneByPhone(phone:String):ResponseEntity<String>{
        return ResponseEntity.ok("Phone $phone")
    }

    fun getOneByEmail(email:String):ResponseEntity<String>{
        return ResponseEntity.ok("Email $email")
    }
}