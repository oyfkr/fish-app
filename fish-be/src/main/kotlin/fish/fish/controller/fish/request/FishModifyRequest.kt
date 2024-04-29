package fish.fish.controller.fish.request

import fish.fish.domain.fish.enums.InOutComeStatus
import java.time.LocalDate

class FishModifyRequest(

    val name : String,

    val code : Int,

    val purchasePrice : Int?,

    val salePrice : Int?,

    val major : String?,

    val middle : String?,

    val small : String?,

    val weight : Int?,

    val properInventory : Int?,

    val registerDate : LocalDate?,

    val vat : Int?,

    val inOutComeStatus : InOutComeStatus,

    val image : String?,

    val note : String?,

    val aPrice : Int?,

    val bPrice : Int?,

    val cPrice : Int?,

    val dPrice : Int?,

    val ePrice : Int?
) {
}