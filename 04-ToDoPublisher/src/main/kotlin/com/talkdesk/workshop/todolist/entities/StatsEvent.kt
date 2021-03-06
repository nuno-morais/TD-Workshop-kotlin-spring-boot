package com.talkdesk.workshop.todolist.entities

class StatsEvent(
    val name: StatsOperation = StatsOperation.CREATED,
    val userId: String = ""
)

enum class StatsOperation(val op: String) {
    CREATED("created"),
    UPDATED("updated"),
    Deleted("deleted")
}