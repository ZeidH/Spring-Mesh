package com.springmesh.inventoryservice.controller

import com.springmesh.inventoryservice.model.Inventory
import com.springmesh.inventoryservice.model.Item
import com.springmesh.inventoryservice.service.InventoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/inventory")
class InventoryController(
    @Autowired
    val inventoryService: InventoryService
) {

    @GetMapping
    fun getAllInventories(): ResponseEntity<List<Inventory>> {
        return ResponseEntity(inventoryService.getAllInventories(), HttpStatus.OK)
    }

    @GetMapping("/{userId}")
    fun getInventoryOfUser(@PathVariable("userId") userId: Int): ResponseEntity<List<Inventory>> {
        return ResponseEntity(inventoryService.getInventory(userId), HttpStatus.OK)
    }
}