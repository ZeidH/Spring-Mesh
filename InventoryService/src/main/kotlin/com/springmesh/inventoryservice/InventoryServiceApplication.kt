package com.springmesh.inventoryservice

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class InventoryServiceApplication(
    @Value("\${debug}")
    private val debug: String
) {
    var logger: Logger = LoggerFactory.getLogger(InventoryServiceApplication::class.java)

    @Bean
    fun init() {
        if (this.debug.toBoolean()) {
            logger.warn("Application running in local mode")
        } else {
            logger.warn("Application running in cloud mode")
        }
    }
}

fun main(args: Array<String>) {
    runApplication<InventoryServiceApplication>(*args)
}
