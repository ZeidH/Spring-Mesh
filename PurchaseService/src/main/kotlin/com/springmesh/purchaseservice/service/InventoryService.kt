package com.springmesh.purchaseservice.service

import com.springmesh.purchaseservice.model.Item
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono


@Service
class InventoryService(
    @Value("\${debug}")
    private val debug: String,
) {
    private val client: WebClient = this.InventoryService()
    var logger: Logger = LoggerFactory.getLogger(InventoryService::class.java)

    private fun InventoryService(): WebClient {
        logger.info("Initializing connection with Inventory Service")

        return if(this.debug.toBoolean()){
            WebClient.create("http://localhost:8084/api/")
        } else{
            WebClient.create("http://InventoryService:8080/api/")
        }
    }


    fun updateInventory(userId:Int, item: Item){
        logger.info("Updating inventory for user: $userId with item ${item.id}")

        this.client.post()
            .uri("/inventory/$userId")
            .bodyValue(item)
            .retrieve()
            .bodyToMono(String::class.java);
    }
}