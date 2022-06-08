package com.springmesh.itemservice

import com.springmesh.itemservice.model.Item
import com.springmesh.itemservice.repositories.ItemRepository
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.text.ParseException

@SpringBootApplication
class ItemServiceApplication{
    @Bean
    fun init(repository: ItemRepository): ApplicationRunner? {
        val data = arrayOf(
            arrayOf("Potato"),
            arrayOf("Carrot"),
            arrayOf("Witlof"),
            arrayOf("Taco"),
            arrayOf("Tortilla"),
            arrayOf("Cheese"),
            arrayOf("Burger"),
            arrayOf("Onion")
            )
        return ApplicationRunner { args: ApplicationArguments? ->
            data.forEach {
                try {
                    val item = Item(
                        it[0],
                    )
                    repository.save(item)
                } catch (e: ParseException) {
                    e.printStackTrace()
                }
            }
            repository.findAll().forEach(System.out::println)
        }
    }
}

fun main(args: Array<String>) {
    runApplication<ItemServiceApplication>(*args)
}
