package fish.fish.domain.fish

import fish.fish.controller.fish.request.FishCreateRequest
import fish.fish.domain.fish.enums.InOutComeStatus
import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@Table
class Fish(

    // 프로그램에서 코드로 사용
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long?,

    @Column(name = "name")
    var name : String,

    // 매입 단가
    @Column(name = "purchase_price")
    var purchasePrice : Int?,

    // 매출 단가
    @Column(name = "sale_price")
    var salePrice : Int?,

    @Column(name = "major")
    var major : String?,

    @Column(name = "middle")
    var middle : String?,

    @Column(name = "small")
    var small : String?,

    @Column(name = "weight")
    var weight : Int?,

    @Column(name = "proper_inventory")
    var properInventory : Int?,

    @Column(name = "register_date")
    var registerDate : LocalDate?,

    @Column(name = "vat")
    var vat : Int?,

    @Column(name = "in_out_come_status")
    @Enumerated(EnumType.STRING)
    var inOutComeStatus : InOutComeStatus,

    @Column(name = "image")
    var image : String?,

    @Column(name = "note")
    var note : String?,

    @Column(name = "a_price")
    var aPrice : Int?,

    @Column(name = "b_price")
    var bPrice : Int?,

    @Column(name = "c_price")
    var cPrice : Int?,

    @Column(name = "d_price")
    var dPrice : Int?,

    @Column(name = "e_price")
    var ePrice : Int?,

    @CreatedDate
    @Column(name = "created_date")
    var createdDate: LocalDateTime,

    @LastModifiedDate
    @Column(name = "modified_date")
    var modifiedDate: LocalDateTime?
) {

    companion object {
        fun ofByCreateRequest(fishCreateRequest: FishCreateRequest) : Fish {
            return Fish(null, fishCreateRequest.name, fishCreateRequest.purchasePrice, fishCreateRequest.salePrice, fishCreateRequest.major, fishCreateRequest.middle, fishCreateRequest.small, fishCreateRequest.weight, fishCreateRequest.properInventory, fishCreateRequest.registerDate, fishCreateRequest.vat, fishCreateRequest.inOutComeStatus, fishCreateRequest.image, fishCreateRequest.note,
                fishCreateRequest.aPrice, fishCreateRequest.bPrice, fishCreateRequest.cPrice, fishCreateRequest.dPrice, fishCreateRequest.ePrice, LocalDateTime.now(), null)
        }
    }
}