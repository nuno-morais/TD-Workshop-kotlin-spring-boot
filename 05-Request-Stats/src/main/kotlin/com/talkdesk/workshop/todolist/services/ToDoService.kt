package com.talkdesk.workshop.todolist.services

import com.talkdesk.workshop.todolist.entities.ToDo
import com.talkdesk.workshop.todolist.repositories.ToDoRepository
import org.springframework.stereotype.Service

@Service
class ToDoService(
        private val toDoRepository: ToDoRepository,
        private val toDoPublisher: ToDoPublisher
) {
    fun all() = toDoRepository.findAll()

    fun create(todo: ToDo): ToDo {
        val nTodo = toDoRepository.save(todo)
        toDoPublisher.publishCreateOption(todo.userId)
        return nTodo
    }

    fun get(id: Int) = toDoRepository.findById(id)

    fun update(todo: ToDo, id: Int): ToDo? {
        val todoExists = get(id).isPresent
        return if (todoExists) {
            val uTodo = toDoRepository.save(todo)
            toDoPublisher.publishUpdateOption(todo.userId)
            uTodo
        } else null
    }

    fun delete(id: Int): ToDo? {
        val todo = get(id)
        if (todo.isPresent) {
            toDoRepository.deleteById(id)
            toDoPublisher.publishDeleteOption(todo.get().userId)
        }
        return todo.orElse(null)
    }
}