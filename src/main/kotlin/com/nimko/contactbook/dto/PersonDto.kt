package com.nimko.contactbook.dto

import com.nimko.contactbook.utils.PhoneValidation
import io.swagger.v3.oas.annotations.media.Schema
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDateTime
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

@Schema(name = "Схема Dto", description = "DTO for use")
data class PersonDto(
    val firstName : String,
    val lastName : String,
    @field:NotBlank(message = "Empty phone number!")
    @field:PhoneValidation
    val phoneNumber : String,
    @field:NotBlank(message = "Empty email")
    @field:Email
    val email : String,
    val app : String,
    @DateTimeFormat(pattern = "yyyy-MM-dd['T'HH:mm:ss.SSS'Z']")
    val date : LocalDateTime
) {
}