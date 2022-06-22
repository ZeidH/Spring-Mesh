package com.springmesh.purchaseservice.service

import com.springmesh.purchaseservice.model.Item
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Service
class ItemService(
    @Value("\${debug}")
    private val debug: String,
) {
    private val client: WebClient = this.ItemService()
    var logger: Logger = LoggerFactory.getLogger(ItemService::class.java)

    private fun ItemService(): WebClient {
        logger.info("Initializing connection with Item Service")
        return if(this.debug.toBoolean()){
            WebClient.create("http://localhost:8082/api/")
        } else{
            WebClient.create("http://InventoryService:8080/api/")
        }
    }

    fun getItem(id:Int): Item {
        logger.info("Fetching item with id: $id")
        return this.client.get()
            .uri("/items/$id")
            .retrieve()
            .bodyToMono(Item::class.java).block()!!
    }
    fun getItemAsync(id:Int): Mono<Item> {
        logger.info("Fetching item with id: $id")
        return this.client.get()
            .uri("/items/$id")
            .retrieve()
            .bodyToMono(Item::class.java)
    }
}

