package com.springmesh.inventoryservice.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.reactive.function.client.WebClient


class ItemService(
    @Value("\${debug}")
    private val debug: String,
) {
    private val client: WebClient = this.ItemService()

    fun ItemService(): WebClient {
        return if(this.debug.toBoolean()){
            WebClient.create("http://localhost:8084/api/")
        } else{
            WebClient.create("http://InventoryService:8080/api/")
        }
    }
}