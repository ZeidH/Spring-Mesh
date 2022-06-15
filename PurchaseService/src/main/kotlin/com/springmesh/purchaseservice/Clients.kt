package com.springmesh.purchaseservice

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.web.reactive.function.client.WebClient


class Clients(
    @Value("\${debug}")
    private val debug: String
)  {
    @Bean
    fun InventoryService(): WebClient? {
        return if(this.debug.toBoolean()){
            WebClient.create("http://localhost:8084/api/")
        } else{
            WebClient.create("http://InventoryService:8080/api/")
        }
    }

    @Bean
    fun ItemService(): WebClient? {
        return if(this.debug.toBoolean()){
            WebClient.create("http://localhost:8082/api/")
        } else{
            WebClient.create("http://ItemService:8080/api/")
        }
    }
}