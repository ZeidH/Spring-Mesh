package com.springmesh.purchaseservice.model

import javax.persistence.*


@Entity
@Table(name = "PURCHASES")
data class Purchase(
    @field:Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int? = null,
    val userId: Int,
    val itemId: Int
)