package cinema.exception

import java.lang.RuntimeException

class AlreadyPurchasedTicketException ( error: String = "The ticket has been already purchased!") : RuntimeException(error)
