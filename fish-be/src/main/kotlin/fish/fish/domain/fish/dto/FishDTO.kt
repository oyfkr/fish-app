package fish.fish.domain.fish.dto

import fish.fish.domain.fish.Fish
import fish.fish.domain.fish.enums.InOutComeStatus
import java.time.LocalDate

class FishDTO(
    val id : Long?,
    val name: String,
    val purchasePrice : Int?,
    val salePrice : Int?,
    val major : String?,
    val middle : String?,
    val small : String?,
    val weight : Int?,
    val properInventory : Int?,
    val registerDate: LocalDate?,
    val vat : Int?,
    val inOutComeStatus: InOutComeStatus,
    val image: String?,
    val aPrice : Int?,
    val bPrice : Int?,
    val cPrice : Int?,
    val dPrice : Int?,
    val ePrice : Int?
) {

    companion object{
        fun of(fish: Fish) : FishDTO {
            return FishDTO(fish.id, fish.name, fish.purchasePrice, fish.salePrice, fish.major, fish.middle, fish.small, fish.weight,fish.properInventory, fish.registerDate, fish.vat, fish.inOutComeStatus, fish.image, fish.aPrice, fish.bPrice, fish.cPrice, fish.dPrice, fish.ePrice)
        }
    }
}