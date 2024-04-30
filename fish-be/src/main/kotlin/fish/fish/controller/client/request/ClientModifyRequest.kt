package fish.fish.controller.client.request

import java.time.LocalDate

class ClientModifyRequest(

    var processingClassification : String, // 처리구분
    var name : String, // 거래처명
    var taxInvoiceName : String?, // 세금계산서명
    var representationName : String?, // 대표자 성명
    var phoneNumber : String?, // 전화번호
    var faxNumber: String?, // 팩스번호
    var cellPhoneNumber: String?, // 휴대폰
    var transactionStartDate: LocalDate?, // 거래시작일
    var lastTransactionDate: LocalDate?, // 최종거래일자
    var unitPriceApplication: String?, // 단가적용
    var transactionPrintOption: String?, // 거래 영수증 출력 설정
    var businessStyle: String?, // 업태
    var event: String?, // 종목
    var businessRegistrationNumber: String?, // 사업자등록번호
    var sortation: String?, // 구분
    var bankName: String?, // 은행명
    var bankAccountNumber: String?, // 계좌번호
    var bankAccountName: String?, // 예금주명
    var note: String?, // 비고
    var smallAddress: String?, // 읍,면,동
    var address: String?, // 주소
    var postalCode: String?, // 우편번호
    var streetNumber: String?, // 주소번지
    var isTradingSuspended: Boolean, // 거래 중지 여부
    var isTradingSuspendedException: Boolean?, // 거래 중지 예외
    var clientAgent: ClientAgentModifyRequest?

) {
}