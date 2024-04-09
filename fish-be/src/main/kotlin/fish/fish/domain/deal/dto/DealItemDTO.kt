package fish.fish.domain.deal.dto

import fish.fish.domain.deal.DealItem
import fish.fish.domain.fish.dto.FishDTO

class DealItemDTO(

    var id: Long,
    var fish: FishDTO,
    var weight: Int,
    var quantity: Int,
    var unit: Int,
    var unitPrice: Int,
    var totalPrice: Int,
    var note: String?
) {

    companion object{
        fun of(dealItem: DealItem) : DealItemDTO{

            val id = dealItem.id ?: throw Exception("id가 null이면 에러")

            val fish = FishDTO.of(dealItem.fish)

            return DealItemDTO(id, fish, dealItem.weight, dealItem.quantity,
                    dealItem.unit, dealItem.unitPrice, dealItem.totalPrice, dealItem.note)
        }
    }
}