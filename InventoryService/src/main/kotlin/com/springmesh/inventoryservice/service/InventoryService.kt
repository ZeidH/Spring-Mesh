package com.springmesh.inventoryservice.service

import com.springmesh.inventoryservice.model.Inventory
import com.springmesh.inventoryservice.repositories.InventoryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class InventoryService(
    @Autowired
    val inventoryRepository: InventoryRepository
) {
    fun getInventory(userId: Int): List<Inventory> {
        return inventoryRepository.findAllByUserId(userId) // todo implement exception handling
    }

    fun getAllInventories(): List<Inventory> {
        return inventoryRepository.findAll() as List<Inventory>
    }
}