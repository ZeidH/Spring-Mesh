package com.springmesh.purchaseservice.controller

import com.springmesh.purchaseservice.service.InventoryService
import com.springmesh.purchaseservice.service.PurchaseService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/purchase")
class PurchaseController(
    @Autowired
    val purchaseService: PurchaseService
) {
    var logger: Logger = LoggerFactory.getLogger(PurchaseController::class.java)

    @PostMapping("{userId}/{itemId}")
    fun purchaseItem(@PathVariable("userId") userId: Int, @PathVariable("itemId") itemId: Int){
        logger.info("Purchase request of item: $itemId for user $userId")
        this.purchaseService.purchaseItem(userId,itemId)
    }
}