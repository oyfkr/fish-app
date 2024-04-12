package fish.fish.domain.deal

import fish.fish.controller.deal.request.DealItemModifyRequest
import fish.fish.domain.client.Client
import fish.fish.domain.fish.Fish
import jakarta.persistence.*

@Table(name = "deal_item")
@Entity
class DealItem(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long?,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fish_id")
    var fish: Fish,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deal_id")
    var deal: Deal,

    @Column(name = "weight")
    var weight: Int,

    @Column(name = "quantity")
    var quantity: Int,

    @Column(name = "unit")
    var unit: String,

    @Column(name = "unit_price")
    var unitPrice: Int,

    @Column(name = "total_price")
    var totalPrice: Int,

    @Column(name = "note")
    var note: String?
) {

    fun modifyDealItem(dealItemModifyRequest: DealItemModifyRequest, fish: Fish) {
        this.fish = fish
        this.weight = dealItemModifyRequest.weight
        this.quantity = dealItemModifyRequest.quantity
        this.unit = dealItemModifyRequest.unit
        this.unitPrice = dealItemModifyRequest.unitPrice
        this.totalPrice = dealItemModifyRequest.totalPrice
        this.note = dealItemModifyRequest.note
    }

    fun isEqualFish(name: String) : Boolean {
        return this.fish.name == name
    }
}