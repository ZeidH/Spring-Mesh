package com.springmesh.itemservice

import com.springmesh.itemservice.model.Item
import com.springmesh.itemservice.repositories.ItemRepository
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.text.ParseException
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@SpringBootApplication
class ItemServiceApplication(
    @Value("\${debug}")
    private val debug: String
)
{
    var logger: Logger = LoggerFactory.getLogger(ItemServiceApplication::class.java)

    @Bean
    fun init(repository: ItemRepository): ApplicationRunner? {
        if(this.debug.toBoolean()){
            logger.warn("Application running in local mode")
        } else {
            logger.warn("Application running in cloud mode")
        }
        if(repository.findAll().count() > 0)
            return ApplicationRunner {}
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
        return ApplicationRunner {
            data.forEach {
                try {
                    val item = Item(null,
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
