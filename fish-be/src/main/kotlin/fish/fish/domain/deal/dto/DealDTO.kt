package fish.fish.domain.deal.dto

import fish.fish.domain.deal.Deal
import fish.fish.domain.deal.DealItem

class DealDTO(

        var id: Long?,
        var cnt: Int,
        val client : String,
        var dealItems: MutableList<DealItemDTO>?

//        var test: String
) {
    companion object {
        fun of(deal: Deal) : DealDTO {

            deal.id ?: throw Exception("id가 null입니다.")

            val dealItemDTOs = deal.dealItem?.map { DealItemDTO.of(it) }?.toMutableList()

            return DealDTO(deal.id, deal.cnt, deal.client.name, dealItemDTOs)
        }
    }
}