package cinema.exception

import java.lang.RuntimeException

class InvalidPasswordException( error: String = "The password is wrong!") : RuntimeException(error)