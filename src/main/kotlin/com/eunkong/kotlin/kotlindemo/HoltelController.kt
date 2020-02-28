package com.eunkong.kotlin.kotlindemo

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = "/hotels")
class HotelController(val hotelRepository: HotelRepository) {

    @GetMapping("/all")
    fun all(): MutableIterable<Hotel> = this.hotelRepository.findAll()

    @GetMapping(value = "/{name}")
    fun byName(@PathVariable(value = "name") name: String) : List<Hotel> {
        val hotelsByName = this.hotelRepository.findByName(name)
        return hotelsByName
    }

    @PostMapping(value = "/checkin")
    fun chekin(@RequestBody checkInRequest: CheckInRequest) {
        val hotelByName = this.hotelRepository.findByName(checkInRequest.hotelName).get(0)
        hotelByName.checkIn(checkInRequest.nbGuests)
        hotelRepository.save(hotelByName)
    }

}