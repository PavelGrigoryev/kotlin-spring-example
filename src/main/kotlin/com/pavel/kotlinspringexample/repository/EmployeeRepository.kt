package com.pavel.kotlinspringexample.repository

import com.pavel.kotlinspringexample.model.Employee
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface EmployeeRepository : MongoRepository<Employee, String>