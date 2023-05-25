package cinema.dto.theater

import com.fasterxml.jackson.annotation.JsonProperty

data class RoomDTO (
    @JsonProperty("total_rows")
    val totalRow: Int,

    @JsonProperty("total_columns")
    val totalColumns: Int,

    @JsonProperty("available_seats")
    val availableSeats: MutableList<SeatDTO> = mutableListOf<SeatDTO>().apply {
        for (i in 1..9) {
            for (j in 1..9) {
                add(SeatDTO(i, j))
            }
        }
    },

)
