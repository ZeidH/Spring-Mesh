package com.springmesh.inventoryservice.service

import com.springmesh.inventoryservice.model.Inventory
import com.springmesh.inventoryservice.model.Item
import com.springmesh.inventoryservice.repositories.InventoryRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class InventoryService(
    @Autowired
    val inventoryRepository: InventoryRepository
) {
    var logger: Logger = LoggerFactory.getLogger(InventoryService::class.java)

    fun getInventory(userId: Int): List<Inventory> {
        logger.info("Getting inventory for user: $userId")
        return inventoryRepository.findAllByUserId(userId) // todo implement exception handling
    }

    fun getAllInventories(): List<Inventory> {
        logger.info("Getting all inventories")
        return inventoryRepository.findAll() as List<Inventory>
    }

    fun addToInventory(userId: Int, item: Item) {
        logger.info("Adding item ${item.id} to inventory for user: $userId")
        inventoryRepository.save(Inventory(null,userId, item.id!!))
    }
}