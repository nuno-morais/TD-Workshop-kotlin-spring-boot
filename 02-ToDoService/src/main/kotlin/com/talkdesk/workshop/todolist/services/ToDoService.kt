package com.talkdesk.workshop.todolist.services

import com.talkdesk.workshop.todolist.entities.ToDo
import org.springframework.stereotype.Service

@Service
class ToDoService {

    private var currentId: Int = 1
    private val todoList = mutableMapOf<Int, ToDo>()

    fun all() = todoList.values

    fun create(todo: ToDo): ToDo {
        val newTodo = todo.copy(id = currentId)
        todoList.putIfAbsent(currentId, newTodo)
        currentId += 1
        return newTodo
    }

    fun get(id: Int) = todoList[id]

    fun update(todo: ToDo, id: Int) =
            todoList[id]?.let {
                val updateTodo = todo.copy(id = id, createdAt = it.createdAt)
                todoList[id] = updateTodo
                updateTodo
            }

    fun delete(id: Int): ToDo? {
        val todo = todoList[id]
        todoList.remove(id)
        return todo
    }
}