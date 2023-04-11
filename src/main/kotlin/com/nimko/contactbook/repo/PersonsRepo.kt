package com.nimko.contactbook.repo

import com.nimko.contactbook.models.Person
import org.springframework.data.jpa.repository.JpaRepository


interface PersonsRepo:JpaRepository<Person,Long> {
}