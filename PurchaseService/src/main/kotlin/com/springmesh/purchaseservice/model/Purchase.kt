package com.springmesh.userservice.model

import javax.persistence.*


@Entity
@Table(name = "Purchases")
data class Purchase(
    @field:Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int? = null,
    val user: Int,
    val item: Int
)