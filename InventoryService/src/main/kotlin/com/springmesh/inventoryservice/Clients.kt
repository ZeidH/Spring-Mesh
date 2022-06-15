package com.springmesh.inventoryservice

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.web.reactive.function.client.WebClient


class Clients(
    @Value("\${debug}")
    private val debug: String
)  {
    @Bean
    fun ItemService(): WebClient? {
        return if(this.debug.toBoolean()){
            WebClient.create("http://localhost:8082/api/")
        } else{
            WebClient.create("http://ItemService:8080/api/")
        }
    }
}