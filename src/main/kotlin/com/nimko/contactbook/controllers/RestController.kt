package com.nimko.contactbook.controllers

import com.nimko.contactbook.dto.PersonDto
import com.nimko.contactbook.services.PersonsServices
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/contacts")
class RestController @Autowired constructor(
    val service:PersonsServices
){

    @GetMapping
    fun getAll() : ResponseEntity<String>
    = service.getAll()

    @PostMapping
    fun create(dto: PersonDto):ResponseEntity<String>
    = service.create(dto)

    @GetMapping("/{email}")
    fun getOneByEmail(@PathVariable email:String):ResponseEntity<String>
    = service.getOneByEmail(email)

    @GetMapping("/phones")
    fun getOneByPhone(@RequestParam("phone") phone:String):ResponseEntity<String>
    = service.getOneByPhone(phone)

}