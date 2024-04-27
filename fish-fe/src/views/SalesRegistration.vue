<template>
  <div class="container my-5">
    <div class="d-flex justify-content-between">
      <h2>매출 등록</h2>
      <div class="d-flex align-items-end">
        <span class="btn btn-sm btn-primary" v-if="isSaveBtnShow" @click="save"
          >저장</span
        ><span
          class="btn btn-sm btn-primary"
          v-if="!isSaveBtnShow"
          @click="modify"
          >수정</span
        ><span class="btn btn-sm btn-primary ms-1">조회</span>
      </div>
    </div>
    <hr />
    <div class="plate">
      <table class="table">
        <tbody>
          <tr>
            <th>처리구분</th>
            <td>
              <div class="d-flex align-items-center">
                <select name="" id="" class="form-select form-select-sm">
                  <option value="">매출</option>
                </select>
                <select name="" id="" class="form-select form-select-sm ms-1">
                  <option value="">일반</option>
                </select>
              </div>
            </td>
            <th>작성거래처</th>
            <td>
              <input type="text" class="form-control form-control-sm" />
            </td>
            <th>거래일자</th>
            <td colspan="5">
              <div class="d-flex align-items-center">
                <input
                  type="date"
                  class="form-control form-control-sm"
                  v-model="date"
                  id="date"
                /><span class="btn btn-sm btn-primary ms-1">변경</span>
              </div>
            </td>
          </tr>
          <tr>
            <th>거래처</th>
            <td>
              <div class="d-flex align-items-center">
                <input
                  type="text"
                  class="form-control form-control-sm"
                  v-model="componey"
                  id="company"
                /><input
                  type="text"
                  class="form-control form-control-sm ms-1"
                /><span class="btn btn-sm btn-primary ms-1">변경</span>
              </div>
            </td>
            <th>작성순번</th>
            <td>
              <div class="d-flex align-items-center">
                <input
                  type="number"
                  class="form-control form-control-sm"
                  id="number"
                  v-model="number"
                /><span
                  class="btn btn-sm btn-primary ms-1"
                  onclick="cntControl('down')"
                  ><i class="fa-solid fa-caret-left"></i></span
                ><span
                  class="btn btn-sm btn-primary ms-1"
                  onclick="cntControl('up')"
                  ><i class="fa-solid fa-caret-right"></i
                ></span>
              </div>
            </td>
            <th>작성시간</th>
            <td>
              <input type="text" class="form-control form-control-sm" />
            </td>
            <th>전표번호</th>
            <td colspan="5">
              <input type="text" class="form-control form-control-sm" />
            </td>
          </tr>
          <tr>
            <th>예금주</th>
            <td>
              <input type="text" class="form-control form-control-sm" />
            </td>
            <th>담당</th>
            <td>
              <input type="text" class="form-control form-control-sm" />
            </td>
            <th>전화</th>
            <td>
              <input type="text" class="form-control form-control-sm" />
            </td>
            <th>HP</th>
            <td>
              <input type="text" class="form-control form-control-sm" />
            </td>
            <th>팩스</th>
            <td>
              <input type="text" class="form-control form-control-sm" />
            </td>
          </tr>
          <tr>
            <td colspan="10"><hr class="my-0" /></td>
          </tr>
          <tr>
            <th>전일잔액</th>
            <td>
              <input type="text" class="form-control form-control-sm" />
            </td>
            <th>최종거래일</th>
            <td>
              <input type="text" class="form-control form-control-sm" />
            </td>
            <th>입금금액</th>
            <td>
              <input type="text" class="form-control form-control-sm" />
            </td>
            <th>금일합계</th>
            <td colspan="5">
              <div class="d-flex align-items-center">
                <input type="text" class="form-control form-control-sm" /><input
                  type="text"
                  class="form-control form-control-sm ms-1"
                />
              </div>
            </td>
          </tr>
          <tr>
            <th>판매담당</th>
            <td>
              <select name="" id="" class="form-select form-select-sm">
                <option value="">관리자</option>
              </select>
            </td>
            <th>총반품금액</th>
            <td>
              <div class="d-flex align-items-center">
                <input type="text" class="form-control form-control-sm" /><input
                  type="text"
                  class="form-control form-control-sm ms-1"
                />
              </div>
            </td>
            <th>할인금액</th>
            <td>
              <input type="text" class="form-control form-control-sm" />
            </td>
            <th>총잔액</th>
            <td colspan="5">
              <input type="text" class="form-control form-control-sm" />
            </td>
          </tr>
        </tbody>
      </table>
      <table class="table side-table ms-1 mt-3">
        <tbody>
          <tr>
            <td>
              <div class="border-box">
                <h6>과세 구분</h6>
                <label for="tax_bill">
                  <input type="radio" id="tax_bill" name="bill" class="me-2" />
                  세금 계산서
                </label>
                <label for="origin_bill">
                  <input
                    type="radio"
                    id="origin_bill"
                    name="bill"
                    class="me-2"
                    checked
                  />
                  계산서
                </label>
              </div>
              <label for="tax_bill_out" class="mt-2 mb-3">
                <input type="checkbox" id="tax_bill_out" class="me-2" />
                세금계산서 발행
              </label>
              <div class="border-box">
                <h6>결제 구분</h6>
                <div class="d-flex align-items-center">
                  <label for="receipt">
                    <input
                      type="radio"
                      id="receipt"
                      name="pay_type"
                      class="me-2"
                    />
                    영수 </label
                  ><label for="claim">
                    <input
                      type="radio"
                      id="claim"
                      name="pay_type"
                      class="ms-3 me-2"
                      checked
                    />
                    청구
                  </label>
                </div>
              </div>
            </td>
            <td>
              <div class="border-box" style="width: 210px">
                <h6>결제사항 등록</h6>
                <div class="d-flex align-items-center mb-2">
                  <b>현금</b>
                  <input type="text" class="form-control form-control-sm" />
                </div>
                <div class="d-flex align-items-center mb-2">
                  <b>할인</b>
                  <input type="text" class="form-control form-control-sm" />
                </div>
                <div class="d-flex align-items-center mb-2">
                  <b>통장</b>
                  <input type="text" class="form-control form-control-sm" />
                </div>
                <div class="d-flex align-items-center">
                  <b>카드</b>
                  <input type="text" class="form-control form-control-sm" />
                </div>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <table class="table table-2 my-1">
      <tr>
        <td>
          <div class="d-flex align-items-center justify-content-between">
            <div class="d-flex align-items-center">
              <span class="btn btn-sm btn-primary me-2">초기화</span
              ><label for="money_">
                <input
                  type="radio"
                  id="money_"
                  name="money"
                  class="ms-2 me-2"
                  checked
                />
                금액 </label
              ><label for="money_0">
                <input
                  type="radio"
                  id="money_0"
                  name="money"
                  class="ms-3 me-2"
                />
                0
              </label>
            </div>
            <div class="d-flex align-items-center">
              <span class="btn btn-sm btn-primary me-2">동시내역</span>
              <select
                name=""
                id=""
                class="form-select form-select-sm me-2"
                style="width: 100px"
              >
                <option value="">1개월</option>
              </select>
              <span class="btn btn-sm btn-primary me-4">조회</span>
              <span class="btn btn-sm btn-primary me-2">거래명세서</span>
              <span class="btn btn-sm btn-primary me-2">거래영수증</span>
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
                <th style="width: 20px">No</th>
                <th>제품코드</th>
                <th>제품명</th>
                <th>중량</th>
                <th>수량</th>
                <th>단위</th>
                <th>단가</th>
                <th>총금액</th>
                <th>비고</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="(el, i) in fishList" :key="i">
                <td>{{ i + 1 }}</td>
                <td>
                  <input
                    type="text"
                    class="form-control form-control-sm"
                    v-model="el.fishCode"
                  />
                </td>
                <td>
                  <input
                    type="text"
                    class="form-control form-control-sm"
                    v-model="el.fishName"
                  />
                </td>
                <td>
                  <input
                    type="number"
                    class="form-control form-control-sm"
                    v-model="el.weight"
                  />
                </td>
                <td>
                  <input
                    type="number"
                    class="form-control form-control-sm"
                    v-model="el.quantity"
                  />
                </td>
                <td>
                  <input
                    type="text"
                    class="form-control form-control-sm"
                    v-model="el.unit"
                  />
                </td>
                <td>
                  <input
                    type="number"
                    class="form-control form-control-sm"
                    v-model="el.unitPrice"
                  />
                </td>
                <td>
                  <input
                    type="number"
                    class="form-control form-control-sm"
                    v-model="el.totalPrice"
                  />
                </td>
                <td>
                  <input
                    type="text"
                    class="form-control form-control-sm"
                    v-model="el.note"
                  />
                </td>
              </tr>
            </tbody>
          </table>
        </div>
        <table class="table">
          <tbody>
            <tr>
              <th>메모</th>
              <td colspan="2">
                <textarea
                  name=""
                  id=""
                  cols="30"
                  rows="3"
                  class="form-control"
                  style="resize: none"
                ></textarea>
              </td>
              <th>납품금액</th>
              <td colspan="2">
                <div class="d-flex align-items-center">
                  <input
                    type="text"
                    class="form-control form-control-sm"
                  /><input
                    type="text"
                    class="form-control form-control-sm ms-1"
                  />
                </div>
              </td>
              <td class="ps-4" colspan="3">
                <div class="d-flex align-items-center mb-2">
                  <b style="width: 80px">공급가액</b>
                  <input type="text" class="form-control form-control-sm" />
                </div>
                <div class="d-flex align-items-center">
                  <b style="width: 80px">부가세액</b>
                  <input type="text" class="form-control form-control-sm" />
                </div>
              </td>
            </tr>
            <tr>
              <th>매출액</th>
              <th>현금매출</th>
              <th>외상매출</th>
              <th>현금입금</th>
              <th>은행입금</th>
              <th>외상입금</th>
              <th>카드입금</th>
              <th>할인금액</th>
              <th>임금액</th>
            </tr>
            <tr>
              <td>
                <input type="text" class="form-control form-control-sm" />
              </td>
              <td>
                <input type="text" class="form-control form-control-sm" />
              </td>
              <td>
                <input type="text" class="form-control form-control-sm" />
              </td>
              <td>
                <input type="text" class="form-control form-control-sm" />
              </td>
              <td>
                <input type="text" class="form-control form-control-sm" />
              </td>
              <td>
                <input type="text" class="form-control form-control-sm" />
              </td>
              <td>
                <input type="text" class="form-control form-control-sm" />
              </td>
              <td>
                <input type="text" class="form-control form-control-sm" />
              </td>
              <td>
                <input type="text" class="form-control form-control-sm" />
              </td>
            </tr>
          </tbody>
        </table>
      </div>
      <div class="ms-1" style="width: 430px; overflow-x: scroll">
        <table class="table table-3 text-center">
          <thead>
            <tr>
              <th>일자</th>
              <th>판매금</th>
              <th>입금액</th>
              <th>현잔액</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
            </tr>
          </tbody>
        </table>
        <table class="table table-3 text-center">
          <thead>
            <tr>
              <th>제품</th>
              <th>남은수량</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td></td>
              <td></td>
            </tr>
          </tbody>
        </table>
        <table class="table table-3 text-center">
          <thead>
            <tr>
              <th>품명</th>
              <th>판매수</th>
              <th>남은수량</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td></td>
              <td></td>
              <td></td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>
  <Loading v-if="isLoading" />
</template>
<script>
import Loading from "@/components/Loading.vue";
import commonMixinxs from "@/mixins/commonMixins";

import axios from "axios";
export default {
  components: { Loading },
  mixins: [commonMixinxs],
  data() {
    return {
      isLoading: false,
      xhrToken: "",
      currentCnt: 0,
      deal_id: "",
      componey: "",
      number: 1,
      date: this.getToday(),
      fishList: [
        // {
        //   fishCode: "",
        //   fishName: "",
        //   weight: 0,
        //   quantity: 0,
        //   unit: "",
        //   unitPrice: 0,
        //   totalPrice: 0,
        //   note: "",
        // },
      ],
      isSaveBtnShow: true,
    };
  },
  created() {
    const vm = this;
    //vm.loadCntData()
    vm.drawFishList(0, 15);
  },
  watch: {
    number() {
      //this.loadFishData();
      console.log("@@@@");
    },
  },
  methods: {
    async getToken() {
      const vm = this;
      await axios
        .get(`http://localhost:8080/csrf-token`)
        .then((res) => {
          console.log(res);
          vm.xhrToken = res;
        })
        .catch((err) => {
          console.log(err);
          alert("토큰 에러 발생");
        });
    },
    loadCntData() {
      const vm = this;
      axios
        .get(`http://localhost:8080/deal/now-page-cnt?dealDate=${vm.date}`)
        .then((res) => {
          console.log(res);
          vm.number = res + 1;
          vm.currentCnt = data + 1;
        })
        .catch((err) => {
          console.log(err);
          alert("순서 조회 에러 발생");
        });
    },
    loadFishData() {
      const vm = this;
      vm.isLoading = true;
      // axios
      //   .get(`http://localhost:8080/deal/${vm.number}?dealDate=${vm.date}`)
      //   .then((res) => {
      //     console.log(res);
      //     vm.number = res + 1;
      //     vm.currentCnt = data + 1;
      //   })
      //   .catch((err) => {
      //     console.log(err);
      //     alert("순서 조회 에러 발생");
      //   });

      deal_id = data.id;
      vm.company = data.client;

      if (data && data.dealItems.length > 0) {
        vm.isSaveBtnShow = false;
        const arr = [];
        for (let i = 0; i < data.dealItems.length; i++) {
          const v = data.dealItems[i];
          const obj = {
            id: v.id,
            fishCode: v.fish.code,
            fishName: v.fish.name,
            weight: v.weight,
            quantity: v.quantity,
            unit: v.unit,
            unitPrice: v.unitPrice,
            totalPrice: v.totalPrice,
            note: v.note,
          };
          arr.push(obj);
        }
        vm.fishList = arr;
        vm.drawFishList(data.dealItems.length, 15 - data.dealItems.length);
      } else {
        vm.isSaveBtnShow = true;
        vm.drawFishList(0, 15);
      }

      vm.isLoading = false;
    },
    async sendData(type) {
      const vm = this;

      if (!vm.date) {
        alert("거래일자를 입력해주세요.");
        return;
      }

      if (!vm.company) {
        alert("거래처를 입력해주세요.");
        return;
      }

      if (!vm.number) {
        alert("순번을 입력해주세요.");
        return;
      }

      vm.isLoading = true;
      await vm.getToken();

      const sendData = {
        dealDate: vm.date,
        clientName: vm.company,
        cnt: vm.number,
        dealItemCreateRequests: vm.fishList,
      };

      let url = "";
      if (type === "save") {
        url = "http://localhost:8080/deal";
      } else if (type === "modify") {
        url = `http://localhost:8080/deal/${deal_id}`;
      }

      await axios
        .post(
          url,
          { data: JSON.stringify(sendData) },
          {
            headers: {
              "Content-type": "application/json",
              "X-XSRF-TOKEN": vm.xhrToken,
            },
          }
        )
        .then((res) => {
          console.log(res);
          location.reload();
        })
        .catch((err) => {
          console.log(err);
          alert("저장 에러 발생");
        });
    },
    save() {
      this.sendData("svae");
    },
    modify() {
      this.sendData("modify");
    },
    drawFishList(start, end) {
      const vm = this;
      for (let i = start; i < end; i++) {
        const obj = {
          id: "",
          fishCode: "",
          fishName: "",
          weight: 0,
          quantity: 0,
          unit: "",
          unitPrice: 0,
          totalPrice: 0,
          note: "",
        };
        vm.fishList.push(obj);
      }
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
  width: 490px;
}
.side-table td {
  vertical-align: top;
}

.table-2 td {
  background-color: #c0c0c0 !important;
}

.table-3 thead {
  position: sticky;
  top: 0;
  left: 0;
}

.table-3 th {
  border: 1px solid #ccc;
}
.table-3 td {
  background-color: #fff !important;
  border: 1px solid #ccc;
}
</style>
