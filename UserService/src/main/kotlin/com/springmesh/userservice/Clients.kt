package com.springmesh.userservice

import org.springframework.context.annotation.Bean
import org.springframework.web.reactive.function.client.WebClient


class Clients {
    @Bean
    fun InventoryService(): WebClient? {
        return WebClient.create("http://InventoryService:8081/api/")
    }

}