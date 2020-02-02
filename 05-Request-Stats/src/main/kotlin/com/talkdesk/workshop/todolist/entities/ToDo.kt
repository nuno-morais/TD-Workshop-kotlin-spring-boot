package com.talkdesk.workshop.todolist.entities

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class ToDo(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Int? = null,
        val title: String = "",
        val description: String? = null,
        @JsonProperty("user_id")
        val userId: String = "",
        @JsonProperty("created_at")
        val createdAt: LocalDateTime? = LocalDateTime.now(),
        val completed: Boolean? = false
) {
    override fun toString(): String {
        return String.format("ToDo[id=%d, title='%s', description='%s', description='%s', " +
                "user_id='%s', created_at='%s', completed='%s']", id, title, description, userId,
                createdAt, completed)
    }
}
