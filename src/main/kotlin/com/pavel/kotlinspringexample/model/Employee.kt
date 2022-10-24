package com.pavel.kotlinspringexample.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "employees")
data class Employee(
    @Id
    var id: String? = ObjectId().toHexString(),

    val firstName: String,

    val lastName: String,

    val email: String

)
