package cinema.exception

import java.lang.RuntimeException

class WrongTokenException(error: String = "Wrong token!") : RuntimeException(error)

