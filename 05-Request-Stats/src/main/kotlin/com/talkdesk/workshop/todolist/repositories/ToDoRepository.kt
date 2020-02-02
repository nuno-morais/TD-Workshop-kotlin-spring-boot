package com.talkdesk.workshop.todolist.repositories

import com.talkdesk.workshop.todolist.entities.ToDo
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

@Service
interface ToDoRepository : CrudRepository<ToDo, Int>