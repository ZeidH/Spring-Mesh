package com.springmesh.inventoryservice

import com.springmesh.inventoryservice.model.Inventory
import com.springmesh.inventoryservice.repositories.InventoryRepository
import com.springmesh.inventoryservice.service.ItemService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.text.ParseException

@SpringBootApplication
class InventoryServiceApplication(
    @Value("\${debug}")
    private val debug: String,
    @Autowired
    private val itemService:ItemService
) {
    var logger: Logger = LoggerFactory.getLogger(InventoryServiceApplication::class.java)

    @Bean
    fun init(repository: InventoryRepository): ApplicationRunner {
        if (this.debug.toBoolean()) {
            logger.warn("Application running in local mode")
        } else {
            logger.warn("Application running in cloud mode")
        }
        if(repository.findAll().count() > 0)
            return ApplicationRunner {}
        val inventoryList = mutableListOf<Inventory>()
        this.itemService.getAllItems().map {
            inventoryList.add(Inventory(null,it.id!!,10))
        }

        return ApplicationRunner {
            inventoryList.forEach {
                try {
                    repository.save(it)
                } catch (e: ParseException) {
                    e.printStackTrace()
                }
            }
            repository.findAll().forEach(System.out::println)
        }
    }
}

fun main(args: Array<String>) {
    runApplication<InventoryServiceApplication>(*args)
}
