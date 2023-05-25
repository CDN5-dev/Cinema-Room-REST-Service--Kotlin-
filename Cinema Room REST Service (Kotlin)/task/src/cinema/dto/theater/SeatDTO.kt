package cinema.dto.theater

open class SeatDTO (
        val row: Int,
        val column: Int,
        val price: Int = if (row <= 4) 10 else 8,
)

