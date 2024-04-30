package fish.fish.domain.client.dto

import fish.fish.domain.client.Client
import fish.fish.domain.client.ClientAgent
import jakarta.persistence.*
import java.time.LocalDate

class ClientDTO(

    val id : Long?,

    val processingClassification : String, // 처리구분

    val code : Int, // 거래처 코드

    val name : String, // 거래처명

    val taxInvoiceName : String?, // 세금계산서명

    val representationName : String?, // 대표자 성명

    val phoneNumber : String?, // 전화번호

    val faxNumber: String?, // 팩스번호

    val cellPhoneNumber: String?, // 휴대폰

    val transactionStartDate: LocalDate?, // 거래시작일

    val lastTransactionDate: LocalDate?, // 최종거래일자

    val unitPriceApplication: String?, // 단가적용

    val transactionPrintOption: String?, // 거래 영수증 출력 설정

    val businessStyle: String?, // 업태

    val event: String?, // 종목

    val businessRegistrationNumber: String?, // 사업자등록번호

    val sortation: String?, // 구분

    val bankName: String?, // 은행명

    val bankAccountNumber: String?, // 계좌번호

    val bankAccountName: String?, // 예금주명

    val note: String?, // 비고

    val smallAddress: String?, // 읍,면,동

    val address: String?, // 주소

    val postalCode: String?, // 우편번호

    val streetNumber: String?, // 주소번지

    val enabled: Boolean, // 삭제 여부

    val isTradingSuspended: Boolean, // 거래 중지 여부

    val isTradingSuspendedException: Boolean?, // 거래 중지 예외

    var clientAgent: ClientAgentDTO?,

    ) {
    companion object{
        fun ofByClient(client: Client): ClientDTO {

            var clientAgentDTO: ClientAgentDTO? = null

            if(client.clientAgent != null) {
                clientAgentDTO = ClientAgentDTO.ofByClientAgent(client.clientAgent!!)
            }

            return ClientDTO(client.id, client.processingClassification, client.code, client.name, client.taxInvoiceName, client.representationName, client.phoneNumber, client.faxNumber, client.cellPhoneNumber, client.transactionStartDate, client.lastTransactionDate, client.unitPriceApplication, client.transactionPrintOption, client.businessStyle, client.event, client.businessRegistrationNumber, client.sortation, client.bankName, client.bankAccountNumber, client.bankAccountName, client.note, client.smallAddress, client.address, client.postalCode, client.streetNumber, client.enabled, client.isTradingSuspended, client.isTradingSuspendedException, clientAgentDTO)
        }
    }
}