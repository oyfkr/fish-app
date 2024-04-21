package fish.fish.domain.fish.enums

enum class InOutComeStatus(
    val code : String
) {
    ALL("전체"),
    INCOME("매입"),
    OUTCOME("매출");
}