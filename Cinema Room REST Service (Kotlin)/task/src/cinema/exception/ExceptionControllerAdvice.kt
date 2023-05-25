package cinema.exception

import cinema.dto.error.ErrorResponseDTO
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice


@RestControllerAdvice
class ExceptionControllerAdvice {

    @ExceptionHandler
    fun handleAlreadyPurchasedTicketException(ex: AlreadyPurchasedTicketException): ResponseEntity<ErrorResponseDTO> = ResponseEntity(
        ErrorResponseDTO(ex.message), HttpStatus.BAD_REQUEST)

    @ExceptionHandler
    fun handleOutOfBoundsException(ex: OutOfBoundsException): ResponseEntity<ErrorResponseDTO> = ResponseEntity(
        ErrorResponseDTO(ex.message), HttpStatus.BAD_REQUEST)

    @ExceptionHandler
    fun handleWrongTokenException(ex: WrongTokenException): ResponseEntity<ErrorResponseDTO> = ResponseEntity(
        ErrorResponseDTO(ex.message), HttpStatus.BAD_REQUEST)

    @ExceptionHandler
    fun handleInvalidPasswordException(ex: InvalidPasswordException): ResponseEntity<ErrorResponseDTO> = ResponseEntity(
        ErrorResponseDTO(ex.message), HttpStatus.UNAUTHORIZED)
}