package com.springmesh.inventoryservice.controller

import com.springmesh.inventoryservice.model.Item
import com.springmesh.inventoryservice.service.InventoryService
import com.springmesh.inventoryservice.service.ItemService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/inventory/items")
class InventoryItemsController(
    @Autowired
    val inventoryService: InventoryService,
    @Autowired
    val itemService: ItemService
) {

    @GetMapping("/{userId}")
    fun getAllItemsOfUser(@PathVariable("userId") userId: Int): ResponseEntity<List<Item>> {
        val items = inventoryService.getInventory(userId).map { this.itemService.getItem(it.item) }.toList()
        return ResponseEntity(items, HttpStatus.OK)
    }

}