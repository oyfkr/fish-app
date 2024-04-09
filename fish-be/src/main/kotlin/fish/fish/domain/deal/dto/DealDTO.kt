package fish.fish.domain.deal.dto

import fish.fish.domain.deal.Deal
import fish.fish.domain.deal.DealItem

class DealDTO(

        var id: Long?,
        var cnt: Int,
        var dealItems: MutableList<DealItemDTO>?

//        var test: String
) {
    companion object {
        fun of(deal: Deal) : DealDTO {

            deal.id ?: throw Exception("id가 null입니다.")

            var dealItemDTOs = deal.dealItem?.map { DealItemDTO.of(it) }?.toMutableList()

            return DealDTO(deal.id, deal.cnt, dealItemDTOs)
        }
    }
}