package com.nimko.contactbook.dto

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime
import javax.validation.constraints.Email

data class PersonDto(
    @JsonProperty("first_name")
    val firstName : String,
    @JsonProperty("last_name")
    val lastName : String,
    @JsonProperty("phone_number")
    val phoneNumber : String,
    @Email
    val email : String,
    val app : String,
    val date : LocalDateTime
) {
}