package fish.fish.controller.deal.request

import java.time.LocalDate

class DealCreateRequest(

    var dealItemCreateRequests: List<DealItemCreateRequest>,

    var clientName : String,
    var cnt: Int,
    var dealDate: LocalDate
) {
}