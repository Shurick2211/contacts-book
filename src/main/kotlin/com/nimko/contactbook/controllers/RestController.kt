package com.nimko.contactbook.controllers

import com.nimko.contactbook.dto.PersonDto
import com.nimko.contactbook.models.Person
import com.nimko.contactbook.services.PersonsServices
import com.nimko.contactbook.utils.PhoneValidation
import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Contact
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid
import javax.validation.constraints.Email
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

@RestController
@RequestMapping("/contacts")
@OpenAPIDefinition(info =
Info(
    title = "Contacts Book",
    version = "0.0.1",
    description = "My Test API for UpUp",
    contact = Contact(name = "Shurick", email = "shurick2211@gmail.com")
)
)
@Tag(name = "Controller",description = "My ToDo Controller")
@Validated
class RestController @Autowired constructor(
    val service:PersonsServices
){

    @GetMapping
    fun getAll() : ResponseEntity<List<Person>>
    = service.getAll()

    @PostMapping
    fun create(@Validated @RequestBody dto: PersonDto): ResponseEntity<Person>
    = service.create(dto)

    @GetMapping("/{email}")
    fun getOneByEmail(@PathVariable @Email email:String):ResponseEntity<Person>
    = service.getOneByEmail(email)

    @GetMapping("/phones")
    fun getOneByPhone( @RequestParam("phone") @PhoneValidation phone:String):ResponseEntity<Person>
    = service.getOneByPhone(phone)

}