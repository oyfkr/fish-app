<template>
  <div class="container my-5">
    <div class="d-flex justify-content-between">
      <h2>거래처 등록</h2>
      <div class="d-flex align-items-end">
        <span class="btn btn-sm btn-primary" @click="save" id="save-btn"
          >저장</span
        ><span class="btn btn-sm btn-primary d-none" id="modify-btn">수정</span
        ><span class="btn btn-sm btn-primary ms-1">조회</span>
      </div>
    </div>
    <hr />
    <div class="plate">
      <table class="table" style="width: 350px">
        <tbody>
          <tr>
            <th>처리구분</th>
            <td>
              <select
                name=""
                id=""
                class="form-select form-select-sm"
                v-model="processingClassification"
              >
                <option value="">선택</option>
              </select>
            </td>
          </tr>
          <tr>
            <th>거래처코드</th>
            <td>
              <input
                type="text"
                class="form-control form-control-sm"
                v-model="clientInfo.code"
              />
            </td>
          </tr>
          <tr>
            <th>거래처명</th>
            <td>
              <input
                type="text"
                class="form-control form-control-sm"
                v-model="clientInfo.name"
              />
            </td>
          </tr>
          <tr>
            <th>세금계산서명</th>
            <td>
              <input
                type="text"
                class="form-control form-control-sm"
                v-model="clientInfo.taxInvoiceName"
              />
            </td>
          </tr>
          <tr>
            <th>대표자성명</th>
            <td>
              <input
                type="text"
                class="form-control form-control-sm"
                v-model="clientInfo.representationName"
              />
            </td>
          </tr>
          <tr>
            <th>전화번호</th>
            <td>
              <input
                type="text"
                class="form-control form-control-sm"
                v-model="clientInfo.phoneNumber"
              />
            </td>
          </tr>
          <tr>
            <th>팩스번호</th>
            <td>
              <input
                type="text"
                class="form-control form-control-sm"
                v-model="clientInfo.faxNumber"
              />
            </td>
          </tr>
          <tr>
            <th>휴대폰</th>
            <td>
              <input
                type="text"
                class="form-control form-control-sm"
                v-model="clientInfo.cellPhoneNumber"
              />
            </td>
          </tr>
          <tr>
            <th>거래시작일</th>
            <td>
              <input
                type="date"
                class="form-control form-control-sm"
                v-model="clientInfo.transactionStartDate"
              />
            </td>
          </tr>
          <tr>
            <th>최종거래일자</th>
            <td>
              <input
                type="text"
                class="form-control form-control-sm"
                v-model="clientInfo.lastTransactionDate"
              />
            </td>
          </tr>
          <tr>
            <th>단가적용</th>
            <td>
              <select
                name=""
                id=""
                class="form-select form-select-sm"
                v-model="clientInfo.unitPriceApplication"
              >
                <option value="">선택</option>
              </select>
            </td>
          </tr>
          <tr>
            <td colspan="2" class="pt-4 ps-3">
              <div class="border-box mb-2">
                <h6>거래 영수증 출력설정</h6>
                <div class="d-flex align-items-center">
                  <label for="print">
                    <input
                      type="radio"
                      id="print"
                      name="credit_print"
                      class="me-2"
                      v-model="clientInfo.transactionPrintOption"
                    />
                    하단 출력 </label
                  ><label for="print_no">
                    <input
                      type="radio"
                      id="print_no"
                      name="credit_print"
                      class="ms-3 me-2"
                      v-model="clientInfo.transactionPrintOption"
                    />
                    하단 미출력
                  </label>
                </div>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
      <div class="pt-4 px-3">
        <div class="d-flex">
          <table class="table" style="width: 350px">
            <tbody>
              <tr>
                <th>업태</th>
                <td>
                  <input
                    type="text"
                    class="form-control form-control-sm"
                    v-model="clientInfo.businessStyle"
                  />
                </td>
              </tr>
              <tr>
                <th>종목</th>
                <td>
                  <input
                    type="text"
                    class="form-control form-control-sm"
                    v-model="clientInfo.event"
                  />
                </td>
              </tr>
              <tr>
                <th>사업자등록번호</th>
                <td>
                  <input
                    type="text"
                    class="form-control form-control-sm"
                    v-model="clientInfo.businessRegistrationNumber"
                  />
                </td>
              </tr>
              <tr>
                <th>구분</th>
                <td>
                  <select
                    name=""
                    id=""
                    class="form-select form-select-sm"
                    v-model="clientInfo.sortation"
                  >
                    <option value="">선택</option>
                  </select>
                </td>
              </tr>
              <tr>
                <th>거래은행</th>
                <td>
                  <input
                    type="text"
                    class="form-control form-control-sm"
                    v-model="clientInfo.bankName"
                  />
                </td>
              </tr>
              <tr>
                <th>예금주명</th>
                <td>
                  <input
                    type="text"
                    class="form-control form-control-sm"
                    v-model="clientInfo.bankAccountName"
                  />
                </td>
              </tr>
            </tbody>
          </table>
          <div class="border-box mb-2 ms-4">
            <h6>담당자</h6>
            <table class="table">
              <tbody>
                <tr>
                  <th>성명</th>
                  <td>
                    <input
                      type="text"
                      class="form-control form-control-sm"
                      v-model="clientInfo.clientAgent.name"
                    />
                  </td>
                  <th>담당자2</th>
                  <td>
                    <input
                      type="text"
                      class="form-control form-control-sm"
                      v-model="clientInfo.clientAgent.agent2Name"
                    />
                  </td>
                </tr>
                <tr>
                  <th>직책</th>
                  <td>
                    <input
                      type="text"
                      class="form-control form-control-sm"
                      v-model="clientInfo.clientAgent.position"
                    />
                  </td>
                  <th>휴대폰2</th>
                  <td>
                    <input
                      type="text"
                      class="form-control form-control-sm"
                      v-model="clientInfo.clientAgent.agent2CellPhoneNumber"
                    />
                  </td>
                </tr>
                <tr>
                  <th>내선번호</th>
                  <td>
                    <input
                      type="text"
                      class="form-control form-control-sm"
                      v-model="clientInfo.clientAgent.extension"
                    />
                  </td>
                  <th>연락처2</th>
                  <td>
                    <input
                      type="text"
                      class="form-control form-control-sm"
                      v-model="clientInfo.clientAgent.agent2PhoneNumber"
                    />
                  </td>
                </tr>
                <tr>
                  <th>이메일</th>
                  <td>
                    <input
                      type="text"
                      class="form-control form-control-sm"
                      v-model="clientInfo.clientAgent.email"
                    />
                  </td>
                  <th>이메일2</th>
                  <td>
                    <input
                      type="text"
                      class="form-control form-control-sm"
                      v-model="clientInfo.clientAgent.agent2Email"
                    />
                  </td>
                </tr>
                <tr>
                  <th>자택전화</th>
                  <td>
                    <input
                      type="text"
                      class="form-control form-control-sm"
                      v-model="clientInfo.clientAgent.phoneNumber"
                    />
                  </td>
                  <th>색상</th>
                  <td>
                    <select
                      name=""
                      id=""
                      class="form-select form-select-sm"
                      v-model="clientInfo.clientAgent.name"
                    >
                      <option value="">선택</option>
                    </select>
                  </td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
        <div class="d-flex align-items-center justify-content-between px-3">
          <div class="d-flex align-items-center">
            <span class="fw-bold text-center" style="width: 80px">비고</span
            ><input type="text" class="form-control form-control-sm ms-2" />
          </div>
          <div>
            <label for="type4_1">
              <input
                type="checkbox"
                id="type4_1"
                name="type4"
                class="me-2"
                v-model="clientInfo.isTradingSuspended"
              />
              거래중지 </label
            ><label for="type4_2">
              <input
                type="checkbox"
                id="type4_2"
                name="type4"
                class="me-2"
                v-model="clientInfo.isTradingSuspended"
              />
              예외
            </label>
          </div>
        </div>
        <div class="border-box mt-3 mb-2 ms-4">
          <h6>사업장</h6>
          <table class="table">
            <tbody>
              <tr>
                <th>읍/면/동</th>
                <td>
                  <input
                    type="text"
                    class="form-control form-control-sm"
                    v-model="clientInfo.smallAddress"
                  />
                </td>
                <th>주소</th>
                <td>
                  <input
                    type="text"
                    class="form-control form-control-sm"
                    v-model="clientInfo.address"
                  />
                </td>
              </tr>
              <tr>
                <th>우편번호</th>
                <td>
                  <input
                    type="text"
                    class="form-control form-control-sm"
                    v-model="clientInfo.postalCode"
                  />
                </td>
                <th>주소번지</th>
                <td>
                  <input
                    type="text"
                    class="form-control form-control-sm"
                    v-model="clientInfo.streetNumber"
                  />
                </td>
              </tr>
            </tbody>
          </table>
        </div>
        <div
          class="d-flex align-items-center justify-content-between px-3 mt-4"
        >
          <span class="btn btn-primary me-2" style="width: auto"
            >단가 일괄적용</span
          >
          <div class="d-flex align-items-center">
            <span style="width: 330px">검색조건(거래처명, 세금계산서명)</span
            ><input type="text" class="form-control form-control-sm ms-2" />
          </div>
        </div>
      </div>
    </div>
    <table class="table table-2 my-1">
      <tr>
        <td>
          <div class="d-flex align-items-center justify-content-between px-3">
            <div class="d-flex align-items-center">
              <span
                class="btn btn-primary me-2 text-danger fw-bold me-5"
                style="width: auto"
                >전체 하단출력으로</span
              >
              <span class="btn btn-sm btn-primary me-2">미출력 조회</span>
              <span class="btn btn-sm btn-primary me-2">전체조회</span>
              <span class="btn btn-sm btn-primary me-2">매입처</span>
              <span class="btn btn-sm btn-primary me-2">매출처</span>
              <span class="btn btn-sm btn-primary me-2">기타처</span
              ><span class="btn btn-sm btn-primary me-2">세금계산서</span>
            </div>
            <div class="d-flex align-items-center">
              <label for="trade0">
                <input
                  type="radio"
                  id="trade0"
                  name="trade"
                  class="ms-2 me-2"
                  v-model="isTradingSuspended"
                  checked
                />
                거래중 </label
              ><label for="trade1">
                <input
                  type="radio"
                  id="trade1"
                  name="trade"
                  class="ms-3 me-2"
                  v-model="isTradingSuspended"
                />
                거래중지
              </label>
            </div>
          </div>
        </td>
      </tr>
    </table>
    <div class="d-flex align-items-start">
      <div class="w-100">
        <div style="height: 430px; overflow-y: scroll">
          <table class="table table-3 text-center">
            <thead>
              <tr>
                <th>No</th>
                <th>구분</th>
                <th>코드</th>
                <th>거래처명</th>
                <th>세금계산서명</th>
                <th>대표자명</th>
                <th>전화번호</th>
                <th>팩스번호</th>
                <th>담당자명</th>
                <th>담당자휴대폰</th>
                <th>자택전화</th>
                <th>거래시작일</th>
                <th>비고</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>1</td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
              </tr>
              <tr>
                <td>2</td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>

  <Loading v-if="isLoading" />
</template>
<script>
import Loading from "@/components/Loading.vue";
import commonMixins from "@/mixins/commonMixins";

export default {
  components: { Loading },
  mixins: [commonMixins],
  data() {
    return {
      isLoading: false,
      clientInfo: {
        processingClassification: "String", // 처리구분
        code: "Int", // 거래처 코드
        name: "String", // 거래처명
        taxInvoiceName: "String", // 세금계산서명
        representationName: "String", // 대표자 성명
        phoneNumber: "String", // 전화번호
        faxNumber: "String", // 팩스번호
        cellPhoneNumber: "String", // 휴대폰
        transactionStartDate: "LocalDate", // 거래시작일
        lastTransactionDate: "LocalDate", // 최종거래일자
        unitPriceApplication: "String", // 단가적용
        transactionPrintOption: "String", // 거래 영수증 출력 설정
        businessStyle: "String", // 업태
        event: "String", // 종목
        businessRegistrationNumber: "String", // 사업자등록번호
        sortation: "String", // 구분
        bankName: "String", // 은행명
        bankAccountNumber: "String", // 계좌번호
        bankAccountName: "String", // 예금주명
        note: "String", // 비고
        smallAddress: "String", // 읍,면,동
        address: "String", // 주소
        postalCode: "String", // 우편번호
        streetNumber: "String", // 주소번지
        isTradingSuspended: "Boolean", // 거래 중지 여부
        isTradingSuspendedException: "Boolean", // 거래 중지 예외
        clientAgent: {
          name: "String", // 성명
          position: "String", // 직책
          extension: "String", // 내선번호
          email: "String", // 이메일
          phoneNumber: "String", // 자택전화
          agent2Name: "String", // 담당자2
          agent2CellPhoneNumber: "String", // 휴대폰2
          agent2PhoneNumber: "String", // 연락처2
          agent2Email: "String", // 이메일2}
        },
      },
      clientList: [],
    };
  },
  created() {
    const vm = this;
    vm.loadCodeData();
  },
  methods: {
    async loadCodeData() {
      const vm = this;
      // await axios
      //   .get(`http://localhost:8080/deal/now-page-cnt?dealDate=${vm.date}`)
      //   .then((res) => {
      //     console.log(res);
      //     vm.number = res + 1;
      //     vm.currentCnt = data + 1;
      //   })
      //   .catch((err) => {
      //     console.log(err);
      //     alert("순서 조회 에러 발생");
      //   });
    },
  },
};
</script>
<style scoped>
.border-box {
  border: 1px solid #000;
  position: relative;
  padding: 12px;
}
.border-box h6 {
  position: absolute;
  top: -10px;
  left: 6;
  background-color: #ece9d8;
  padding: 0 6px;
  margin-bottom: 0;
}
.border-box b {
  width: 30px;
  margin-right: 8px;
  text-align: center;
}
label {
  display: block;
  cursor: pointer;
  align-items: center;
  display: flex;
}
.side-table {
  width: 150%;
}
.side-table td {
  vertical-align: top;
}

.table-2 td {
  background-color: #c0c0c0 !important;
}

.table-3 th {
  border: 1px solid #ccc;
}
.table-3 td {
  background-color: #fff !important;
  border: 1px solid #ccc;
}
</style>
