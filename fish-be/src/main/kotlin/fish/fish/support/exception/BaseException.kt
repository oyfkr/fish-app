package fish.fish.support.exception

class BaseException(
    val errorType: ErrorType,
    val msg: String?
) : RuntimeException() {

    constructor(errorType: ErrorType) : this(errorType, null)
}