package com.springmesh.inventoryservice.repositories

import com.springmesh.inventoryservice.model.Inventory
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface InventoryRepository :  CrudRepository<Inventory,Int> {
    fun findByItemId(itemId: Int):Inventory
}