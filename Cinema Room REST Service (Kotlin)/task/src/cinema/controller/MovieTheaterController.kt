package cinema.controller

import cinema.dto.theater.RoomDTO
import cinema.dto.theater.SeatDTO
import cinema.dto.ticket.PurchasedTicketDTO
import cinema.dto.ticket.ReturnedTicketDTO
import cinema.dto.ticket.TokenDTO

import cinema.service.MovieTheatreService

import org.springframework.web.bind.annotation.*

@RestController
class MovieTheaterController (
    private val movieTheatreService: MovieTheatreService
) {
    @GetMapping("/seats")
    fun getAvailableSeats(): RoomDTO = movieTheatreService.getAvailableSeats()

    @PostMapping("/purchase")
    fun bookSeat(@RequestBody seat: SeatDTO) : PurchasedTicketDTO = movieTheatreService.bookSeat(seat)

    @PostMapping("/return")
    fun returnTicket(@RequestBody token: TokenDTO) : ReturnedTicketDTO = movieTheatreService.returnTicket(token)

    @PostMapping("/stats")
    fun getStats(@RequestParam password: String?): Map<String, Int> = movieTheatreService.getStats(password)

}

