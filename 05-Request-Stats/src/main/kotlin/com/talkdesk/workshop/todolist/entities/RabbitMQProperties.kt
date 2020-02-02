package com.talkdesk.workshop.todolist.entities

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "rabbitmq")
class RabbitMQProperties {
    var queueName: String = "stats"
    var username: String = "guest"
    var password: String = "guest"
    var host: String = "localhost"
    var port: Int = 5672
}