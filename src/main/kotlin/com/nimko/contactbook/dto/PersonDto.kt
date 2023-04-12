package com.nimko.contactbook.dto

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDateTime
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

data class PersonDto(
    @JsonProperty("first_name")
    val firstName : String,
    @JsonProperty("last_name")
    val lastName : String,
    @NotEmpty
    @JsonProperty("phone_number")
    val phoneNumber : String,
    @NotEmpty
    @Email
    val email : String,
    val app : String,
    @DateTimeFormat(pattern = "yyyy-MM-dd['T'HH:mm:ss.SSS'Z']")
    val date : LocalDateTime
) {
}