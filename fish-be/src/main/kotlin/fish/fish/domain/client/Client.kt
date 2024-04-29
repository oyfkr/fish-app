package fish.fish.domain.client

import jakarta.persistence.*
import java.time.LocalDate
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifier

@Table(name = "client")
@Entity
class Client(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long?,

    @Column(name = "processing_classification")
    var processingClassification : String, // 처리구분

    @Column(name = "code")
    var code : Int, // 거래처 코드

    @Column(name = "name")
    var name : String, // 거래처명

    @Column(name = "tax_invoice_name")
    var taxInvoiceName : String?, // 세금계산서명

    @Column(name = "representation_name")
    var representationName : String?, // 대표자 성명

    @Column(name = "phone_number")
    var phoneNumber : String?, // 전화번호

    @Column(name = "fax_number")
    var faxNumber: Number?, // 팩스번호

    @Column(name = "cell_phone_number")
    var cellPhoneNumber: String?, // 휴대폰

    @Column(name = "transaction_start_date")
    var transactionStartDate: LocalDate?, // 거래시작일

    @Column(name = "last_transaction_date")
    var lastTransactionDate: LocalDate?, // 최종거래일자

    @Column(name = "unit_price_application")
    var unitPriceApplication: String?, // 단가적용

    @Column(name = "transaction_print_option")
    var transactionPrintOption: String?, // 거래 영수증 출력 설정

    @Column(name = "business_style")
    var businessStyle: String?, // 업태

    @Column(name = "event")
    var event: String?, // 종목

    @Column(name = "business_registration_number")
    var businessRegistrationNumber: String?, // 사업자등록번호

    @Column(name = "sortation")
    var sortation: String?, // 구분

    @Column(name = "bank_name")
    var bankName: String?, // 은행명

    @Column(name = "bank_account_number")
    var bankAccountNumber: String?, // 계좌번호

    @Column(name = "bank_account_name")
    var bankAccountName: String?, // 예금주명

    @Column(name = "note")
    var note: String?, // 비고

    @Column(name = "small_address")
    var smallAddress: String?, // 읍,면,동

    @Column(name = "address")
    var address: String?, // 주소

    @Column(name = "postal_code")
    var postalCode: String?, // 우편번호

    @Column(name = "street_number")
    var streetNumber: String?, // 주소번지

    @Column(name = "enabled")
    var enabled: Boolean, // 삭제 여부

    @Column(name = "is_trading_suspended")
    var isTradingSuspended: Boolean, // 거래 중지 여부

    @Column(name = "is_trading_suspended_exception")
    var isTradingSuspendedException: Boolean?, // 거래 중지 예외

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
    var clientAgent: MutableList<ClientAgent>?
) {
}