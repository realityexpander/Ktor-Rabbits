package com.athanas.routes

import com.athanas.data.model.Rabbit
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*

private const val BASE_URL = "http://192.168.2.114:8100"
private val rabbits = listOf(
    Rabbit("Carl", "A cute brown rabbit", "$BASE_URL/rabbits/rabbit1.jpg"),  // BAD IMAGE!
//    Rabbit("Carl", "A cute brown rabbit", "$BASE_URL/rabbits/rabbit1.webp"),
    Rabbit("Emma", "Emma likes to eat apples", "$BASE_URL/rabbits/rabbit2.webp"),
    Rabbit("Florian", "Florian is always hungry", "$BASE_URL/rabbits/rabbit3.webp"),
    Rabbit("Federico", "Federico likes to climb mountains", "$BASE_URL/rabbits/rabbit4.webp"),
    Rabbit("Gina", "Gina is a true beauty", "$BASE_URL/rabbits/rabbit5.webp"),
)

fun Route.randomRabbit() {
    get("/randomrabbit") {
        call.respond(
            HttpStatusCode.OK,
            rabbits.random()
        )
    }
}


fun main() {
    val burg = Hamburger.Builder()
        .beef("100% turkey")
        .cheese(false)
        .build()

    println(burg)
}


data class Hamburger private constructor(
    val cheese: Boolean,
    val beef: String
) {

    class Builder {
        private var cheese: Boolean = true
        private var beef: String = "100% beef"

        fun cheese(value: Boolean) = apply {
            cheese = value
        }
        fun beef(value: String) = apply {
            beef = value
        }
        fun build() = Hamburger(cheese, beef)
    }
}