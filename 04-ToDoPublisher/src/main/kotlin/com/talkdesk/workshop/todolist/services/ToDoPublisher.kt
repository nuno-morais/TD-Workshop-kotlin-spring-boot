package com.talkdesk.workshop.todolist.services

import com.fasterxml.jackson.databind.ObjectMapper
import com.rabbitmq.client.Channel
import com.talkdesk.workshop.todolist.entities.RabbitMQProperties
import com.talkdesk.workshop.todolist.entities.StatsEvent
import com.talkdesk.workshop.todolist.entities.StatsOperation
import org.springframework.stereotype.Service

@Service
class ToDoPublisher(
        private val objectMapper: ObjectMapper,
        private val channel: Channel,
        private val rabbitMQProperties: RabbitMQProperties
) {
    fun publishCreateOption(userId: String) {
        val event = StatsEvent(StatsOperation.CREATED, userId)
        send(event)
    }

    fun publishUpdateOption(userId: String) {
        val event = StatsEvent(StatsOperation.UPDATED, userId)
        send(event)
    }

    fun publishDeleteOption(userId: String) {
        val event = StatsEvent(StatsOperation.Deleted, userId)
        send(event)
    }

    private fun send(event: StatsEvent) {
        val message = objectMapper.writeValueAsString(event)
        channel.basicPublish("", rabbitMQProperties.queueName, null, message.toByteArray(Charsets.UTF_8))
    }
}