let g1 = {varId : 'g1', id : 'grid1', divId : 'gridHolder1'};

const gridLayout1 =
'<columns>\
    <DataGridColumn dataField="EMPNO"   headerText="사번" width="80" />\
</columns>';

function gridReadyHandler(id) {
    if (id == g1.id) {
        g1.layoutOpt = {
                id          : 'dg1'
              , addContent  : gridLayout1
              , addOption   : {
              }
        };
        gridCom.setInit(g1);

        const layoutCompleteHandler = function(event) {
            gridCom.addCommonEvent(event, g1);
        }

        g1.root.addEventListener('layoutComplete', layoutCompleteHandler);
    }
}

rMateGridH5.create(g1.id, g1.divId, gridCom.jsVars, '100%', '100%');


function notExistedValue() {
    let inputIdsToCheck = ['EMPNO'];
    let inputIdsErrMsg = ['성명을 입력해주세요.'];

    for (let i = 0; i < inputIdsToCheck.length; i++) {
        let inputElement = document.getElementById(inputIdsToCheck[i]);
        if (inputElement.value.trim() === '') {
            alert(inputIdsErrMsg[i]);
            return true;
        }
    }
    return false;
}

// 폼 데이터 콤마 제거
function convertToObject() {
    let param = {};
    let menuArr = $(document.menuMove).serializeArray();
    let arr;
    arr = $('#frmSave').serializeArray();
    $.metge(arr, menuArr);

    if (arr) {
        arr.map(function(x){
            param[x.name] = x.value.replace(/[,-]/g, '');
        });
    }

    param = JSON.stringify(param);
}

function inputNumberFormat(input, maxLength) {
    if (input.value === '0') {
        return;
    }

    input.value = input.value.replace(/^0+/, '')
                             .replace(/[^\d]/g, '')
                             .substring(0, maxLength)
                             .replace(/\B(?=(\d{3})+(?!\d))/g, ',');
}

// 999.99 or 999 검증
function inputFloatFormat(input) {
    let floatReg = /^(\d{1,3})(\.\d{1,2})?$/;

    if (!floatReg.test(input.value)) {
        alert(`( ${input.value} ) 숫자는 최대3자리 소수점은 최대2자리 까지 입력 가능합니다.`);
        input.value = 0;
        return false;
    }
}


// Mybatis
/*
    <isNotEmpty property="SORT">
    </isNotEmpty>

    <isEqual property="SORT" compareValue="1">
    </isEqual>

<![CDATA[



if (!hrmsCom.checkSuccess(res, status, xhr)) {
    return false;
{

*/

// 엔터키
function enter(obj) {
    if(event.keyCode != 13) return;
    if (obj.id == "EMPNO") {
        get();
    }
    event.preventDefault ? event.preventDefault() : event.returnValue = false;
}

function checkTelPhone () {
    let phone = document.getElementById('TEL');
    let phoneValue = phone.value.trim();
    let regex = /^\D{2,3}-\d{3,4}-\d{4}$/;

    if (!regex.test(phoneValue)) {
        alert('올바른 전화 번호를 입력하세요.');
        phone.value = '';
        return false;``
    }
}

function checkEmail() {
    let emailValue = document.getElementById('MAIL').value.trim();
    let regex = /^[a-zA-Z0-9._-]+@gmail\.ds\.com$/;

    if (!regex.test(emailValue)) {
        alert('올바른 이메일 주소를 입력하세용.');
        return false;``
    }
}


