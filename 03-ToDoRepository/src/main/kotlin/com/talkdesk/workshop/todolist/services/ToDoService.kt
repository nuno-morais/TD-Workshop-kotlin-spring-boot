package com.talkdesk.workshop.todolist.services

import com.talkdesk.workshop.todolist.entities.ToDo
import com.talkdesk.workshop.todolist.repositories.ToDoRepository
import org.springframework.stereotype.Service

@Service
class ToDoService(
        private val toDoRepository: ToDoRepository
) {
    fun all() = toDoRepository.findAll()

    fun create(todo: ToDo) = toDoRepository.save(todo)

    fun get(id: Int) = toDoRepository.findById(id)

    fun update(todo: ToDo, id: Int): ToDo? {
        val todoExists = get(id).isPresent
        return if (todoExists) {
            toDoRepository.save(todo)
        } else null
    }

    fun delete(id: Int): ToDo? {
        val todo = get(id)
        if (todo.isPresent) {
            toDoRepository.deleteById(id)
        }
        return todo.orElse(null)
    }
}