package com.springmesh.inventoryservice.model

import javax.persistence.*


@Entity
@Table(name = "INVENTORY")
data class Inventory(
    @field:Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int? = null,
    val itemId: Int,
    var inventory: Int,
)
