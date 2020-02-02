package com.talkdesk.workshop.todolist.controllers

import com.talkdesk.workshop.todolist.entities.ToDo
import com.talkdesk.workshop.todolist.services.ToDoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class ToDoController(
        private val toDoService: ToDoService
) {
    @RequestMapping("/todos")
    fun all() = toDoService.all()

    @PostMapping("/todos")
    fun create(@RequestBody todo: ToDo): ResponseEntity<ToDo> {
        val newTodo = toDoService.create(todo)
        return ResponseEntity(newTodo, HttpStatus.CREATED);
    }

    @RequestMapping("/todos/{id}")
    fun get(@PathVariable id: Int): ResponseEntity<ToDo?> {
        val todo = toDoService.get(id)
        return if (todo.isPresent) {
            ResponseEntity(todo.get(), HttpStatus.OK)
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @PutMapping("/todos/{id}")
    fun update(@RequestBody todo: ToDo, @PathVariable id: Int): ResponseEntity<ToDo?> {
        toDoService.update(todo, id)?.let {
            return ResponseEntity(it, HttpStatus.OK)
        } ?: return ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @DeleteMapping("/todos/{id}")
    fun delete(@PathVariable id: Int): ResponseEntity<Any> {
        toDoService.delete(id)?.let {
            return ResponseEntity(HttpStatus.NO_CONTENT)
        } ?: return ResponseEntity(HttpStatus.NOT_FOUND)
    }
}
