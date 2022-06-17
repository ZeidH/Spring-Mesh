package com.springmesh.inventoryservice.service

import com.springmesh.inventoryservice.model.Item
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient

@Service
class ItemService(
    @Value("\${debug}")
    private val debug: String,
) {
    private val client: WebClient = this.ItemService()

    private fun ItemService(): WebClient {
        return if(this.debug.toBoolean()){
            WebClient.create("http://localhost:8082/api/")
        } else{
            WebClient.create("http://InventoryService:8080/api/")
        }
    }


    fun getItem(id:Int): Item {
        return this.client.get()
            .uri("/items/$id")
            .retrieve()
            .bodyToMono(Item::class.java).block()!!
    }

}

