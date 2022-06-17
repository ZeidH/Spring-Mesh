package com.springmesh.inventoryservice.model

import javax.persistence.*


@Entity
@Table(name = "INVENTORY")
data class Inventory(
    @Id
    var id: Int? = null,
    var userId: Int,
    val item: Int,
)
