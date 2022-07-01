package com.springmesh.purchaseservice.service

import com.springmesh.purchaseservice.model.Item
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.ClientResponse
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono
import reactor.core.publisher.Mono


@Service
class InventoryService(
    @Value("\${debug}")
    private val debug: String,
) {
    private val client: WebClient = this.InventoryService()
    var logger: Logger = LoggerFactory.getLogger(InventoryService::class.java)

    private fun InventoryService(): WebClient {
        return if(this.debug.toBoolean()){
            WebClient.create("http://localhost:8084/api/")
        } else{
            WebClient.create("http://InventoryService:8080/api/")
        }
    }


    fun updateInventory(item: Item) {
        logger.info("Updating inventory for item ${item.id}")

        this.client.post()
            .uri("/inventory/${item.id}")
            .retrieve()
            .onStatus({t: HttpStatus -> t.is4xxClientError}, { Mono.error(Throwable("This item is out of inventory"))})
            .bodyToMono<String>().block()
    }
}