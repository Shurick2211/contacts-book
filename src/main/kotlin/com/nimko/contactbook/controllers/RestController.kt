package com.nimko.contactbook.controllers

import com.nimko.contactbook.dto.PersonDto
import com.nimko.contactbook.models.Person
import com.nimko.contactbook.services.PersonServices
import com.nimko.contactbook.utils.PhoneValidation
import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.info.Contact
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RestController
import javax.validation.constraints.Email

@RestController
@RequestMapping("/contacts")
@OpenAPIDefinition(info =
Info(
    title = "Contacts Book",
    version = "0.1.1",
    description = "My Test API for UpUp",
    contact = Contact(name = "Olexandr Nimko",
        email = "shurick2211@gmail.com",
        url = "https://github.com/Shurick2211/contacts-book.git")
)
)
@Tag(name = "REST Controller",description = "My Contacts-book Controller")
@Validated
class RestController @Autowired constructor(
    val service:PersonServices
){

    @GetMapping
    @Operation(summary = "Get all Contacts",
        description = "You can get all Contacts in this method from Database.")
    fun getAll() : ResponseEntity<List<Person>>
    = service.getAll()

    @PostMapping
    @Operation(summary = "Create Contact",
        description = "You can create Contact, in this method." +
            "The email & phone number of it have to be unique.")
    fun create(@Validated @RequestBody dto: PersonDto): ResponseEntity<Person>
    = service.create(dto)

    @PutMapping
    @Operation(summary = "Update Contact",
        description = "You can update Contact, in this method." +
                "The email & phone number of it have to be unique.")
    fun update(@Validated @RequestBody dto: PersonDto): ResponseEntity<Person>
            = service.update(dto)
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Contact",
        description = "You can delete Contact, in this method.")
    fun delete(@PathVariable id:Long): ResponseEntity<Any>
        = service.delete(id)

    @GetMapping("/{email}")
    @Operation(summary = "Get Contact by email",
        description = "You can get a Contact in this method from Database by email.")
    fun getOneByEmail(@PathVariable @Email email:String):ResponseEntity<Person>
    = service.getOneByEmail(email)

    @GetMapping("/phones")
    @Operation(summary = "Get Contact by phone number",
        description = "You can get a Contact in this method from Database by phone number.")
    fun getOneByPhone( @RequestParam("phone") @PhoneValidation phone:String):ResponseEntity<Person>
    = service.getOneByPhone(phone)

}