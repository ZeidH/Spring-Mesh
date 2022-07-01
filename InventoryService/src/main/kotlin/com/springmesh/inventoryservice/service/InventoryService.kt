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

    fun getInventory(itemId: Int): Inventory {
        logger.info("Getting inventory for item: $itemId")
        return inventoryRepository.findByItemId(itemId)
    }

    fun getAllInventories(): List<Inventory> {
        logger.info("Getting all inventories")
        return inventoryRepository.findAll() as List<Inventory>
    }

    fun updateInventory(itemId: Int) {
        logger.info("Reducing amount of item: ${itemId} in inventory")
        val inventory =  inventoryRepository.findByItemId(itemId)
        val newInventory = inventory.inventory -1
        inventoryRepository.save(Inventory(inventory.id, inventory.itemId, newInventory))
    }
}