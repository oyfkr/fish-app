document.addEventListener("DOMContentLoaded", function () {
  document.getElementById("addRowButton").addEventListener("click",
      function () {
        var newRow = document.createElement("tr");
        newRow.innerHTML = `
            <td contenteditable="true"></td>
            <td contenteditable="true"></td>
            <td contenteditable="true"></td>
            <td contenteditable="true"></td>
            <td contenteditable="true"></td>
            <td contenteditable="true"></td>
            <td contenteditable="true"></td>
            <td contenteditable="true"></td>
        `;
        document.querySelector("#dataTable tbody").appendChild(newRow);
      });

  document.getElementById("deleteRowButton").addEventListener("click",
      function () {
        var table = document.getElementById("dataTable");
        var lastRow = table.rows.length - 1; // 마지막 행 제외
        if (lastRow > 0) { // 테이블에 행이 있는지 확인
          table.deleteRow(lastRow);
        }
      });

  document.getElementById("saveButton").addEventListener("click", function () {
    var data = [];
    var tableRows = document.querySelectorAll("#dataTable tbody tr");
    tableRows.forEach(function (row) {
      var cells = row.querySelectorAll("td");
      var name = cells[0].innerText.trim();
      var age = cells[1].innerText.trim();
      var price = cells[2].innerText.trim();
      data.push({name: name, age: age, price: price});
    });

    // 로컬 스토리지에 정보 저장
    localStorage.setItem("savedInfo", JSON.stringify(data));

    alert("저장되었습니다.");
  });

  document.getElementById("fetchButton").addEventListener("click", function () {
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "http://localhost:8080/test/deal", true);
    xhr.onreadystatechange = function () {
      if (xhr.readyState == XMLHttpRequest.DONE) {
        if (xhr.status == 200) {
          alert("서버 응답: " + xhr.responseText);
        } else {
          alert("서버 응답 실패");
        }
      }
    };
    xhr.send();
  });

  document.getElementById("saveButton").addEventListener("click", function () {

    let xhrToken = new XMLHttpRequest();
    xhrToken.open("GET", "http://localhost:8080/csrf-token", true);

    xhrToken.onload = function () {
      if (xhrToken.status >= 200 && xhrToken.status < 300) {
        let csrfToken = xhrToken.responseText;

        let xhr = new XMLHttpRequest();
        xhr.open("POST", "http://localhost:8080/deal", true);
        xhr.setRequestHeader("Content-Type", "application/json");
        xhr.setRequestHeader("X-XSRF-TOKEN", csrfToken);

        xhr.onload = function () {
          if (xhr.status >= 200 && xhr.status < 300) {
            // 요청이 성공적으로 완료되었을 때 응답을 처리합니다.
            let response = JSON.parse(xhr.responseText);
            alert(response)
            console.log("응답 받은 데이터:", response);
            // 여기서 응답을 처리할 수 있습니다.

            document.querySelector("#dataTable tbody").innerHTML = "<tr>\n"
                + "    <td contenteditable=\"true\"></td>\n"
                + "    <td contenteditable=\"true\"></td>\n"
                + "    <td contenteditable=\"true\"></td>\n"
                + "    <td contenteditable=\"true\"></td>\n"
                + "    <td contenteditable=\"true\"></td>\n"
                + "    <td contenteditable=\"true\"></td>\n"
                + "    <td contenteditable=\"true\"></td>\n"
                + "    <td contenteditable=\"true\"></td>\n"
                + "  </tr>";

            // inputField에 cnt+1 값으로 채우기
            let inputField = document.getElementById("inputField");
            let currentCnt = parseInt(inputField.value);
            inputField.value = currentCnt + 1;
          } else {
            // 요청이 실패했을 때의 처리
            console.error("요청 실패:", xhr.statusText);
          }
        };

        xhr.onerror = function () {
          // 네트워크 오류 등으로 요청이 실패했을 때의 처리
          console.error("요청 중 네트워크 오류가 발생했습니다.");
        };

        let dealItemCreateRequests = [];
        let tableRows = document.querySelectorAll("#dataTable tbody tr");

        tableRows.forEach(function (row) {
          var dealItemCreateRequest = {
            fishCode: row.cells[0].innerText.trim(),
            fishName: row.cells[1].innerText.trim(),
            weight: parseInt(row.cells[2].innerText.trim()),
            quantity: parseInt(row.cells[3].innerText.trim()),
            unit: row.cells[4].innerText.trim(),
            unitPrice: parseFloat(row.cells[5].innerText.trim()),
            totalPrice: parseFloat(row.cells[6].innerText.trim()),
            note: row.cells[7].innerText.trim()
          };
          dealItemCreateRequests.push(dealItemCreateRequest);
        });

        let clientName = document.getElementById("clientInput").value; // 클라이언트 이름을 직접 설정하거나, 필요에 따라 변경할 수 있습니다.
        let cnt = document.getElementById("inputField").value;
        let dealDate = new Date($("#datepicker").val()).toISOString();

        let requestData = {
          dealItemCreateRequests: dealItemCreateRequests,
          clientName: clientName,
          cnt: cnt,
          dealDate: dealDate
        };

        let jsonData = JSON.stringify(requestData);

        xhr.send(jsonData);
      } else {
        console.error("CSRF 토큰을 받는 중에 오류가 발생했습니다.");
      }
    };

    xhrToken.onerror = function () {
      console.error("CSRF 토큰 요청 중 네트워크 오류가 발생했습니다.");
    };

    xhrToken.send();
  });

  $(function () {
    //input을 datepicker로 선언
    $("#datepicker").datepicker({
      dateFormat: 'yy-mm-dd' //달력 날짜 형태
      ,
      showOtherMonths: true //빈 공간에 현재월의 앞뒤월의 날짜를 표시
      ,
      showMonthAfterYear: true // 월- 년 순서가아닌 년도 - 월 순서
      ,
      changeYear: true //option값 년 선택 가능
      ,
      changeMonth: true //option값  월 선택 가능
      ,
      showOn: "both" //button:버튼을 표시하고,버튼을 눌러야만 달력 표시 ^ both:버튼을 표시하고,버튼을 누르거나 input을 클릭하면 달력 표시
      ,
      buttonImage: "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif" //버튼 이미지 경로
      ,
      buttonImageOnly: true //버튼 이미지만 깔끔하게 보이게함
      ,
      buttonText: "선택" //버튼 호버 텍스트
      ,
      yearSuffix: "년" //달력의 년도 부분 뒤 텍스트
      ,
      monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월',
        '10월', '11월', '12월'] //달력의 월 부분 텍스트
      ,
      monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월',
        '11월', '12월'] //달력의 월 부분 Tooltip
      ,
      dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'] //달력의 요일 텍스트
      ,
      dayNames: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'] //달력의 요일 Tooltip
      ,
      minDate: "-5Y" //최소 선택일자(-1D:하루전, -1M:한달전, -1Y:일년전)
      ,
      maxDate: "+5y" //최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후)
    });

    //초기값을 오늘 날짜로 설정해줘야 합니다.
    $('#datepicker').datepicker('setDate', 'today'); //(-1D:하루전, -1M:한달전, -1Y:일년전), (+1D:하루후, -1M:한달후, -1Y:일년후)

    let datePickerValue = $("#datepicker").val();
    var formattedDate = new Date(datePickerValue).toISOString().split('T')[0];

    // 페이지 로드 시 서버로 현재 페이지 요청
    $.ajax({
      url: 'http://localhost:8080/deal/now-page-cnt' + '?dealDate=' + formattedDate, // 서버의 해당 엔드포인트 주소
      method: 'GET',
      success: function(response) {
        // let tmp = response
        // let tmp =
        // 서버로부터 받은 현재 페이지 값을 텍스트 입력 필드에 설정
        $('#inputField').val(response+1);
      },
      error: function(xhr, status, error) {
        console.error('Failed to fetch current page:', error);
      }
    });

    // 감소 버튼 클릭 시 페이지를 1 감소시키는 이벤트 핸들러
    $('#decreaseButton').click(function() {
      decreasePage();
    });



    // 증가 버튼 클릭 시 페이지를 1 증가시키는 이벤트 핸들러
    $('#increaseButton').click(function() {
      increasePage();
    });

    function decreasePage() {
      let currentCnt = parseInt(inputField.value);

      if(currentCnt -1 <= 0) {
        return
      }

      let decreaseCnt = currentCnt - 1;
      let dealDate = datepicker.value;

      let url = `http://localhost:8080/deal/${decreaseCnt}?dealDate=${encodeURIComponent(dealDate)}`;

      var xhr = new XMLHttpRequest();
      xhr.open("GET", url, true);
      xhr.onreadystatechange = function () {
        if (xhr.readyState === XMLHttpRequest.DONE) {
          if (xhr.status === 200) {
            var table = document.getElementById("dataTable").getElementsByTagName('tbody')[0];
            table.innerText = "";

            var response = JSON.parse(xhr.responseText)

            let dealItems = response.dealItems;

            for(var i = 0; i < dealItems.length; i++) {

              var dealItem = dealItems[i];
              var newRow = table.insertRow(table.rows.length)

              newRow.insertCell(0).appendChild(document.createTextNode(dealItem.fish.name));
              newRow.insertCell(1).appendChild(document.createTextNode(dealItem.fish.code));
              newRow.insertCell(2).appendChild(document.createTextNode(dealItem.weight));
              newRow.insertCell(3).appendChild(document.createTextNode(dealItem.quantity));
              newRow.insertCell(4).appendChild(document.createTextNode(dealItem.unit));
              newRow.insertCell(5).appendChild(document.createTextNode(dealItem.unitPrice));
              newRow.insertCell(6).appendChild(document.createTextNode(dealItem.totalPrice));
              newRow.insertCell(7).appendChild(document.createTextNode(dealItem.note));

            }

            $('#inputField').val(currentCnt-1);
            // alert("서버 응답: " + xhr.responseText);
          } else {
            alert("서버 응답 실패");
          }
        }
      };
      xhr.send();

    }

    function increasePage() {

      alert(datepicker.value)
      var dealDate = datepicker.value;
      // var dealDate = new Date(datePickerValue).toISOString().split('T')[0];
      var nowPageCntGetUrl = 'http://localhost:8080/deal/now-page-cnt' + '?dealDate=' + dealDate
      var xhr1 = new XMLHttpRequest();
      xhr1.open("GET", nowPageCntGetUrl, true);

      let currentCnt = parseInt(inputField.value);

      xhr1.onload = function () {
        if(xhr1.status === 200) {
          var nowServerCnt = xhr1.responseText;

          if(currentCnt === parseInt(nowServerCnt)+1) {
            return
          }

          var table = document.getElementById("dataTable").getElementsByTagName('tbody')[0];
          if(currentCnt+1 === parseInt(nowServerCnt)+1) {
            table.innerHTML = "<tr>\n"
                + "    <td contenteditable=\"true\"></td>\n"
                + "    <td contenteditable=\"true\"></td>\n"
                + "    <td contenteditable=\"true\"></td>\n"
                + "    <td contenteditable=\"true\"></td>\n"
                + "    <td contenteditable=\"true\"></td>\n"
                + "    <td contenteditable=\"true\"></td>\n"
                + "    <td contenteditable=\"true\"></td>\n"
                + "    <td contenteditable=\"true\"></td>\n"
                + "  </tr>";
            $('#inputField').val(currentCnt+1);
            return
          }

          let increaseCnt = currentCnt + 1;
          let url = `http://localhost:8080/deal/${increaseCnt}?dealDate=${encodeURIComponent(dealDate)}`;

          var xhr = new XMLHttpRequest();
          xhr.open("GET", url, true);
          xhr.onreadystatechange = function () {
            if (xhr.readyState === XMLHttpRequest.DONE) {
              if (xhr.status === 200) {
                // var table = document.getElementById("dataTable").getElementsByTagName('tbody')[0];
                table.innerText = "";

                var response = JSON.parse(xhr.responseText)

                let dealItems = response.dealItems;

                for(var i = 0; i < dealItems.length; i++) {

                  var dealItem = dealItems[i];
                  var newRow = table.insertRow(table.rows.length)

                  newRow.insertCell(0).appendChild(document.createTextNode(dealItem.fish.name));
                  newRow.insertCell(1).appendChild(document.createTextNode(dealItem.fish.code));
                  newRow.insertCell(2).appendChild(document.createTextNode(dealItem.weight));
                  newRow.insertCell(3).appendChild(document.createTextNode(dealItem.quantity));
                  newRow.insertCell(4).appendChild(document.createTextNode(dealItem.unit));
                  newRow.insertCell(5).appendChild(document.createTextNode(dealItem.unitPrice));
                  newRow.insertCell(6).appendChild(document.createTextNode(dealItem.totalPrice));
                  newRow.insertCell(7).appendChild(document.createTextNode(dealItem.note));

                }

                $('#inputField').val(currentCnt+1);
                // alert("서버 응답: " + xhr.responseText);
              } else {
                alert("서버 응답 실패");
              }
            }
          };
          xhr.send();

        }
      };
      xhr1.send();
    }
  });
});