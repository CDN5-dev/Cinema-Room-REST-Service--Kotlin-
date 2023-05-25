package cinema.service

import cinema.dto.theater.RoomDTO
import cinema.dto.theater.SeatDTO
import cinema.dto.ticket.PurchasedTicketDTO
import cinema.dto.ticket.ReturnedTicketDTO
import cinema.dto.ticket.TokenDTO

import cinema.exception.AlreadyPurchasedTicketException
import cinema.exception.OutOfBoundsException
import cinema.exception.WrongTokenException
import cinema.exception.InvalidPasswordException

import org.springframework.stereotype.Service
import java.util.*

@Service
class MovieTheatreService {

    private val totalRows = 9
    private val totalColumns = 9
    private val room = RoomDTO(totalRows, totalColumns) // Create 'room' DTO (Data Transfer Object)
    private val purchasedTickets = mutableListOf<PurchasedTicketDTO>() // Create list to hold purchased ticket objects

    fun getAvailableSeats(): RoomDTO = room

    /*
    * Book seat by row and column
     */
    fun bookSeat(seat: SeatDTO): PurchasedTicketDTO {
        val row = seat.row
        val column = seat.column

        if (row < 1 || row > totalRows || column < 1 || column > totalColumns)
            throw OutOfBoundsException()

        // create SeatDTO object by searching for available seats in room
        val purchasedSeat: SeatDTO =
            room.availableSeats.find {
                it.row == row && it.column == column
            } ?: throw AlreadyPurchasedTicketException() // if seat is not available, throw exception

        // remove purchased seat from available seats
        room.availableSeats.removeIf { it.row == row && it.column == column }

        // create PurchasedTicketDTO object - token param is a randomly generated UUID, ticket param is the purchased SeatDTO
        val purchasedTicket = PurchasedTicketDTO(token = "${UUID.randomUUID()}", ticket = purchasedSeat)

        // add purchased ticket to list of sold tickets
        purchasedTickets.add(purchasedTicket)

        return purchasedTicket
    }

    /*
    * Return ticket by token
     */
    fun returnTicket(token: TokenDTO): ReturnedTicketDTO {
        val returnedTicket: PurchasedTicketDTO = purchasedTickets.find{
            it.token == token.token } ?: throw WrongTokenException()

        purchasedTickets.remove(returnedTicket)

        room.availableSeats.add(returnedTicket.ticket)

        return ReturnedTicketDTO(returnedTicket.ticket)
    }

    /*
     * Get stats of sales, available seats, and theater occupancy
     */
    fun getStats(password: String?): Map<String, Int> {

        if(password != "super_secret")
            throw InvalidPasswordException()

        val stats = mutableMapOf<String, Int>()

        stats["current_income"] = purchasedTickets.sumBy { it.ticket.price }
        stats["number_of_available_seats"] = room.availableSeats.size
        stats["number_of_purchased_tickets"] = purchasedTickets.size

        return stats
    }

}
