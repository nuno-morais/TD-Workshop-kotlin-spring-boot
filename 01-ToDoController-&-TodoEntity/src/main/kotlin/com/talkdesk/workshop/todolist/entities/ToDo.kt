package com.talkdesk.workshop.todolist.entities

import java.time.LocalDateTime
import com.fasterxml.jackson.annotation.JsonProperty
data class ToDo(
    val id: Int?,
    val title: String,
    val description: String?,
    @JsonProperty("user_id")
    val userId: String,
    @JsonProperty("created_at")
    val createdAt: LocalDateTime? = LocalDateTime.now(),
    val completed: Boolean? = false
)
