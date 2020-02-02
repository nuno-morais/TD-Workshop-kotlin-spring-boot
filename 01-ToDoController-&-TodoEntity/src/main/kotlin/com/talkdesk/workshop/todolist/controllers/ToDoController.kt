package com.talkdesk.workshop.todolist.controllers

import com.talkdesk.workshop.todolist.entities.ToDo
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ToDoController {
    private var currentId: Int = 1
    private val todoList = mutableMapOf<Int, ToDo>()

    @RequestMapping("/todos")
    fun all() = todoList.values

    @PostMapping("/todos")
    fun create(@RequestBody todo: ToDo): ResponseEntity<ToDo> {
        val newTodo = todo.copy(id = currentId)
        todoList.putIfAbsent(currentId, newTodo)
        currentId += 1
        return ResponseEntity(newTodo, HttpStatus.CREATED);
    }

    @RequestMapping("/todos/{id}")
    fun get(@PathVariable id: Int): ResponseEntity<ToDo?> {
        val todo = todoList[id]
        return if (todo != null) {
            ResponseEntity(todo, HttpStatus.OK)
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @PutMapping("/todos/{id}")
    fun update(@RequestBody todo: ToDo, @PathVariable id: Int): ResponseEntity<ToDo?> {
        todoList[id]?.let {
            val updateTodo = todo.copy(id = id, createdAt = it.createdAt)
            todoList[id] = updateTodo
            return ResponseEntity(updateTodo, HttpStatus.OK)
        } ?: return ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @DeleteMapping("/todos/{id}")
    fun delete(@PathVariable id: Int): ResponseEntity<Any> {
        return if (todoList[id] != null) {
            todoList.remove(id)
            ResponseEntity(HttpStatus.NO_CONTENT)
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
}
