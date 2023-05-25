package cinema.dto.ticket

import cinema.dto.theater.SeatDTO
import com.fasterxml.jackson.annotation.JsonProperty

data class ReturnedTicketDTO (
    @JsonProperty("returned_ticket")
    val returnedTicket: SeatDTO
)