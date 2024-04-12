package fish.fish.controller.deal.request

import java.time.LocalDate

class DealModifyRequest(

    var id : Long?,
    var clientName : String,
    var dealDate: LocalDate,
    var dealItemModifyRequests : MutableList<DealItemModifyRequest>
) {
}