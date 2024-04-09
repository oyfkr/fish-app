package fish.fish.controller.deal.request

import fish.fish.domain.deal.Deal

class DealItemCreateRequest(

    var fishCode: String,

    var fishName: String,

    var weight: Int,

    var quantity: Int,

    var unit: Int,

    var unitPrice: Int,

    var totalPrice: Int,

    var note: String

) {

}