package com.talkdesk.workshop.todolist.controllers

import com.talkdesk.workshop.todolist.services.StatsService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class StatsController(
        val statsService: StatsService
) {
    @RequestMapping("/stats")
    fun stats(@RequestParam("user_id", required = true) userId: String) = statsService.get(userId)
}