package com.pavel.kotlinspringexample.controller

import com.pavel.kotlinspringexample.model.Employee
import com.pavel.kotlinspringexample.service.EmployeeService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/employees")
class EmployeeController(private val employeeService: EmployeeService) {

    @GetMapping
    fun findAll(): List<Employee> = employeeService.findAll()

    @PostMapping
    fun create(@RequestBody employee: Employee): Employee = employeeService.create(employee)

    @GetMapping("/{id}")
    fun findById(@PathVariable("id") id: String): ResponseEntity<Employee> {
        return employeeService.findById(id).map { employee ->
            ResponseEntity.ok(employee)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PutMapping("/{id}")
    fun update(@PathVariable("id") id: String, @RequestBody newEmployee: Employee): ResponseEntity<Employee> {
        return employeeService.update(id, newEmployee).map {
            ResponseEntity.ok().body(newEmployee)
        }.orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable("id") id: String) = employeeService.deleteById(id)

}