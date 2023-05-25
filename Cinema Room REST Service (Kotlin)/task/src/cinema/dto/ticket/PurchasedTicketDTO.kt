package cinema.dto.ticket

import cinema.dto.theater.SeatDTO

data class PurchasedTicketDTO (
    val token: String,
    val ticket: SeatDTO
    )