package com.pavel.kotlinspringexample.service.impl

import com.pavel.kotlinspringexample.model.Employee
import com.pavel.kotlinspringexample.repository.EmployeeRepository
import com.pavel.kotlinspringexample.service.EmployeeService
import org.springframework.stereotype.Service
import java.util.*

@Service
class EmployeeServiceImpl(private val employeeRepository: EmployeeRepository) : EmployeeService {

    override fun findAll(): List<Employee> = employeeRepository.findAll()

    override fun create(employee: Employee): Employee = employeeRepository.save(employee)

    override fun findById(id: String): Optional<Employee> = employeeRepository.findById(id)

    override fun update(id: String, newEmployee: Employee): Optional<Employee> {
        return employeeRepository.findById(id).map { existingEmployee ->
            val updatedEmployee: Employee = existingEmployee
                .copy(firstName = newEmployee.firstName, lastName = newEmployee.lastName, email = newEmployee.email)
            employeeRepository.save(updatedEmployee)
        }
    }

    override fun deleteById(id: String) {
        employeeRepository.findById(id).map { employee ->
            employeeRepository.delete(employee)
        }
    }
}