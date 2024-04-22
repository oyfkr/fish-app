package fish.fish.support.exception

import org.springframework.http.HttpStatus

enum class ErrorType(
    val httpStatus: HttpStatus,
    val message: String
) {

    SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "잠시만 기다려주세요."),

    BAD_REQUEST(HttpStatus.BAD_REQUEST, "요청 값이 올바르지 않습니다."),

    FISH_NOT_FOUNT(HttpStatus.NOT_FOUND, "물고기를 찾을 수 없습니다."),

    ACCOUNT_NOT_FOUND(HttpStatus.NOT_FOUND, "유저를 찾을 수 없습니다.")
}