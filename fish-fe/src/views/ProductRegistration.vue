<template>
  <div class="container my-5">
    <div class="d-flex justify-content-between">
      <h2>제품 등록</h2>
      <div class="d-flex align-items-end">
        <span class="btn btn-sm btn-primary" onclick="save()" id="save-btn"
          >저장</span
        ><span class="btn btn-sm btn-primary d-none" id="modify-btn">수정</span
        ><span class="btn btn-sm btn-primary ms-1">조회</span>
      </div>
    </div>
    <hr />
    <div class="plate">
      <table class="table">
        <tbody>
          <tr>
            <th>제품코드</th>
            <td>
              <input type="text" class="form-control form-control-sm" />
            </td>
          </tr>
          <tr>
            <th>제품명</th>
            <td>
              <input type="text" class="form-control form-control-sm" />
            </td>
          </tr>
          <tr>
            <th>매입단가</th>
            <td>
              <input type="text" class="form-control form-control-sm" />
            </td>
          </tr>
          <tr>
            <th>매출단가</th>
            <td>
              <input type="text" class="form-control form-control-sm" />
            </td>
          </tr>
          <tr>
            <th>A단가</th>
            <td>
              <input type="text" class="form-control form-control-sm" />
            </td>
          </tr>
          <tr>
            <th>B단가</th>
            <td>
              <input type="text" class="form-control form-control-sm" />
            </td>
          </tr>
          <tr>
            <th>C단가</th>
            <td>
              <input type="text" class="form-control form-control-sm" />
            </td>
          </tr>
          <tr>
            <th>D단가</th>
            <td>
              <input type="text" class="form-control form-control-sm" />
            </td>
          </tr>
          <tr>
            <th>E단가</th>
            <td>
              <input type="text" class="form-control form-control-sm" />
            </td>
          </tr>
        </tbody>
      </table>
      <table class="table">
        <tbody>
          <tr>
            <th>대분류</th>
            <td>
              <select name="" id="" class="form-select form-select-sm">
                <option value="">선택</option>
              </select>
            </td>
          </tr>
          <tr>
            <th>중분류</th>
            <td>
              <select name="" id="" class="form-select form-select-sm">
                <option value="">선택</option>
              </select>
            </td>
          </tr>
          <tr>
            <th>소분류</th>
            <td>
              <select name="" id="" class="form-select form-select-sm">
                <option value="">선택</option>
              </select>
            </td>
          </tr>
          <tr>
            <th></th>
            <td>
              <div class="d-flex align-items-center">
                <label for="dan">
                  <input
                    type="checkbox"
                    id="dan"
                    name="mar_type"
                    class="me-2"
                  />
                  단종품 </label
                ><label for="jae">
                  <input
                    type="checkbox"
                    id="jae"
                    name="mar_type"
                    class="ms-3 me-2"
                  />
                  재고여부
                </label>
              </div>
            </td>
          </tr>
          <tr>
            <th>중량</th>
            <td>
              <input type="text" class="form-control form-control-sm" />
            </td>
          </tr>
          <tr>
            <th>적정재고</th>
            <td>
              <input type="text" class="form-control form-control-sm" />
            </td>
          </tr>
          <tr>
            <th>등록일자</th>
            <td>
              <input type="date" class="form-control form-control-sm" />
            </td>
          </tr>
          <tr>
            <th>부가세</th>
            <td>
              <select name="" id="" class="form-select form-select-sm">
                <option value="">선택</option>
              </select>
            </td>
          </tr>
          <tr>
            <th>단위</th>
            <td>
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
                <div class="border-box mb-2">
                  <h6>
                    <label for="mae1">
                      <input
                        type="radio"
                        id="mae1"
                        name="mae_type"
                        class="me-2"
                      />
                      매입제품
                    </label>
                  </h6>
                  <div
                    class="d-flex align-items-center justify-content-between"
                  >
                    매입단위수량<input
                      type="text"
                      class="form-control form-control-sm"
                      style="width: 150px"
                    />
                  </div>
                  <div
                    class="d-flex align-items-center mt-2 justify-content-between"
                  >
                    매출연결제품코드<input
                      type="text"
                      class="form-control form-control-sm"
                      style="width: 150px"
                    />
                  </div>
                </div>
                <label for="mae2" class="mb-2">
                  <input type="radio" id="mae2" name="mae_type" class="me-2" />
                  매출제품
                </label>
                <label for="mae3">
                  <input type="radio" id="mae3" name="mae_type" class="me-2" />
                  매입매출 전체사용
                </label>
              </div>
              <div class="d-flex align-items-center mt-3">
                비고<textarea
                  name=""
                  id=""
                  cols="30"
                  rows="3"
                  class="form-control"
                  style="resize: none"
                ></textarea>
              </div>
            </td>
            <td>
              <div class="d-flex align-items-center mb-3">
                바코드<input
                  type="text"
                  class="form-control form-control-sm ms-2"
                  style="width: 150px"
                />
              </div>
              <span class="btn btn-sm btn-primary">이미지 변경</span>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <table class="table table-2 my-1">
      <tr>
        <td>
          <div class="d-flex align-items-center justify-content-between px-3">
            <span class="text-danger fw-bold">조회 및 출력</span>
          </div>
        </td>
      </tr>
    </table>
    <table class="table table-2 my-1">
      <tr>
        <td>
          <div class="d-flex align-items-center justify-content-between px-3">
            <div class="d-flex align-items-center">
              <div class="d-flex align-items-center me-3">
                제품명<input
                  type="text"
                  class="form-control form-control-sm ms-2"
                  style="width: 150px"
                />
              </div>
              <span class="btn btn-sm btn-primary me-2">전체조회</span>
              <span class="btn btn-sm btn-primary me-2">사용제품조회</span>
              <span class="btn btn-sm btn-primary me-2">단품종조회</span>
              <span class="btn btn-sm btn-primary me-2">출력</span>
              <span class="btn btn-sm btn-primary me-2">엑셀변환</span>
            </div>
            <div class="d-flex align-items-center">
              <label for="type3_1">
                <input
                  type="checkbox"
                  id="type3_1"
                  name="type3"
                  class="ms-2 me-2"
                />
                재고여부전체 </label
              ><label for="type3_3">
                <input
                  type="checkbox"
                  id="type3_3"
                  name="type3"
                  class="ms-3 me-2"
                />
                바코드출력
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
                <th>제품명</th>
                <th>제품코드</th>
                <th>평균단가</th>
                <th>매입단가</th>
                <th>매출단가</th>
                <th>등록일자</th>
                <th>단위</th>
                <th>재고여부</th>
                <th>바코드</th>
                <th>출력</th>
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
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
    <div class="loading-spinner"></div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      text: "test",
    };
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
