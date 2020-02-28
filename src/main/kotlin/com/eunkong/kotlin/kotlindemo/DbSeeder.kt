package com.eunkong.kotlin.kotlindemo

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class DbSeeder(val hotelRepository: HotelRepository) : CommandLineRunner {
    override fun run(vararg args: String?) {
        this.hotelRepository.deleteAll();

        val ibis = Hotel("Ibis", 3, 30)
        val intercontinental = Hotel("Intercontinental", 4, 90)
        val goldenTulip = Hotel(name ="Golden Tulip", classification = 4, nbRooms = 40)

        val hotels = mutableListOf<Hotel>()
        hotels.add(ibis)
        hotels.add(intercontinental)
        hotels.add(goldenTulip)

        this.hotelRepository.saveAll(hotels)

        println(" --- Database has been initialized")
    }
}