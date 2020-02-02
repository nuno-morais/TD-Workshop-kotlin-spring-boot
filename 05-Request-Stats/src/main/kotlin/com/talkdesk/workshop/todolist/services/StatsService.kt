package com.talkdesk.workshop.todolist.services

import com.talkdesk.workshop.todolist.entities.Stats
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class StatsService(
        @Value("\${stats.url}") private val statsUrl: String,
        private val restTemplate: RestTemplate
) {
    fun get(userId: String) =
            this.restTemplate.getForEntity("$statsUrl/stats?user_id=$userId", Stats::class.java)
}