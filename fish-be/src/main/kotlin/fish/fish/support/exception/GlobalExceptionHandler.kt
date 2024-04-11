package fish.fish.support.exception

import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    private val log = KotlinLogging.logger{}

    @ExceptionHandler(value = [BaseException::class])
    fun handlingException(e : BaseException) : ResponseEntity<ErrorResponseDTO> {

        val errorResponseDTO = ErrorResponseDTO(e.errorType, e.errorType.message)
        return ResponseEntity(errorResponseDTO, e.errorType.httpStatus)
    }

    @ExceptionHandler(value = [RuntimeException::class])
    fun handlingRunTimeException(e : Exception) : ResponseEntity<Any?> {

        log.error { e }
        val serverError = ErrorType.SERVER_ERROR

        return ResponseEntity(serverError, serverError.httpStatus)
    }
}