package com.springmesh.inventoryservice.model

import javax.persistence.*


@Entity
@Table(name = "USERS")
data class Inventory(
    @Id
    var id: Int? = null,
    val item: Int,
) {
    constructor(item:Int) : this(null,item) {

    }
}