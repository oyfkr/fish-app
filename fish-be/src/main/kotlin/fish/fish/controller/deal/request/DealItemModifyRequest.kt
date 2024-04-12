package fish.fish.controller.deal.request

class DealItemModifyRequest(
    var id : Long?,

    var fishCode: String,

    var fishName: String,

    var weight: Int,

    var quantity: Int,

    var unit: String,

    var unitPrice: Int,

    var totalPrice: Int,

    var note: String
) {
}