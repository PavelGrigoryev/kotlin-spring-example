package com.pavel.kotlinspringexample.service

import com.pavel.kotlinspringexample.model.Employee
import java.util.*

interface EmployeeService {

    fun findAll(): List<Employee>

    fun create(employee: Employee): Employee

    fun findById(id: String): Optional<Employee>

    fun update(id: String, newEmployee: Employee): Optional<Employee>

    fun deleteById(id: String)

}