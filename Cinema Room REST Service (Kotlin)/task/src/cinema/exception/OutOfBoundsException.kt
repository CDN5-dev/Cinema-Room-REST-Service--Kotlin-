package cinema.exception

import java.lang.RuntimeException

class OutOfBoundsException( error: String = "The number of a row or a column is out of bounds!") : RuntimeException(error)
