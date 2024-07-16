// 공백체크
function isNull(str) {
    if (str == null || str == undefined || str == '' || str == 'null' || str =='undefined') {
        return true;
    } else {
        return false;
    }
}

// null를 공백으로 변환
function isNullVal(str) {
    if (str == null || str == undefined || str == '' || str == 'null' || str =='undefined') {
        return "";
    } else {
        return str;
    }
}

// null를 공백으로 변환
function isNullNvl(str, rep) {
    if (str == null || str == undefined || str == '' || str == 'null' || str =='undefined') {
        return rep;
    } else {
        return str;
    }
}


const dysonCom = {
    msg : {
        CONFIRM_SAVE        : "저장하시겠습니까?"
      , CONFIRM_DELETE      : "삭제하시겠습니까?"
      , CONFIRM_UPLOAD      : "업로드하시겠습니까?"
      , SELECT_DELETE_DATA  : "삭제할 데이터를 선택하세요."
    }

    , checkSuccess  : function(res, status, xhr) {
        // 에러 발생시
        if (!isNull(res.err)) {
            if (res.err == "AuthError") { // 권한 없을시
                location.href="/sec/ram/accessDenied.do";
                return false;
            }

            if (res.err == "error") {
                alert('에러가 발생했습니다.');
                return false;
            }
        }

        // 성공, 실패 체크
        if (!isNull(res.status)) {
            // 실패면
            if (res.status == "fail") {
                if(!isNull(res.result)) alert(res.result);
                return false;
            }
            // 성공이면
            return true;
        }
        return true;
    }
    // 폼 컨트롤러에 포맷 적용
    , setMask : function(form) {

    }

    // 폼 컨트롤 값에 포맷 적용
    , setFormatVal : function(form) {
        form.find(".fmtYm").each(function(index, item) {
            const obj = $(item);
            const tag = isNullVal();
        });
    }
}

//==== rMateGrid 공통 Script ====
const gridCom = {
    // 사용가능한 함수 리스트
    // - setInit : 그리드 초기 세팅
    // - addCommonEvent : 공통 이벤트 등록
    // - setData : 그리드에 데이터 셋팅
    // - removeAll : 그리드 데이터 삭제
    // - addItemAt : 그리드 행 추가
    // - checkSave : 체크된 행 저장 & url 호출
    // - checkDelete : 체크된 행 삭제 & url 호출
    // - findColumn : 컬럼 찾기
    // - exportExcel : 엑셀 다운로드
    // - getSelectorColumn : 셀렉터 컬럼 객체를 로드
    // - getSelector : 셀렉터 체크된 행 인덱스 로드
    // - setSelector : 셀렉터 체크박스 체크상태로 변경
    // - checkRealEdit : ItemEdit 이벤트에서 실제 수정 여부 체크시 사용
    // - getGridInfo : 그리드 정보 세팅한 변수를 찾아 변환
    // - _getLayoutStr : 그리드 레이아웃 생성
    // - _showNoDataMessage : 그리드 메시지박스 표시/숨김
    // - _com_itemEditCompleteHandler : 그리드에서 수정완료 시 체크 상태로 변경
    // - _com_headerLabelFunction : 그리드 헤더에 필수 아이콘 표시
    // - _com_exportProgresshandler, _com_exportUploadCompleteHandler, _com_exportUploadErrorHandler : 엑셀 다운로드 관련




    // Style 관련
    style : {
         defBgColor     : "#FFFFFF"   // 기본 배경색 : 하얀
       , editBgColor    : "#FFEEEE"   // 편집 배경색 : 핑크
       , errorBgColor   : "#FFEFD5"   // 에러 배경색 : 주황
       , linkBgColor    : "#FFFFFF"   // 클릭 배경색 : 하얀
       // CSS명(컬럼에 styleName 지정시 사용 가능)
       , linkStyle      : "gridCom__linkStyle" // 클릭 셀 스타일
    }

    // init 관련
    // rMateGridH5에서 그리드 생성 준비가 완료될 경우 호출할 함수를 지정합니다.
    , jsVars : "rMateOnLoadCallFunction=gridReadyHandler"

    // 그리드 초기 세팅
    // - (set)
    // - gridInfo.varId                     : [String] 선언된 변수명 (ex. let g1 = {varId : "g1"}; 변수명과 varId 같아야 함)
    // - gridInfo.id                        : [String] 그리드의 id
    // - gridInfo.divId                     : [String] 그리드가 위치할 div의 id
    // - gridInfo.selectorColId             : [String] selector 컬럼의 id (생략 가능, 생략 시 selector)
    // - gridInfo.reqDataFields             : [StringArray] 필수 컬럼 헤더 표시 (EDIT 모드만 사용, 생략 가능, 기준은 dataField)
    // - gridInfo.layoutOpt                 : [json] 그리드 레이아웃 옵션 (_getLayoutStr 함수 설명 참고)
    // - gridInfo.eventOpt.isExcelExport    : [String] 엑셀다운로드 여부 (생략 가능, 생략 시 "true")
    // - gridInfo.eventOpt.isAutoSelector   : [String] 편집그리드 체크박스 자동동작 여부 (쌩략 가능, 생략 시 "ture")
    // - (get)
    // - gridInfo.app                       : [Object] 그리드를 포함하는 div 객체
    // - gridInfo.root                      : [Object] 데이터와 그리드를 포함하는 객체
    // - (root 관련)
    // - gridInfo.root.gridVID == gridInfo.varId
    // - gridInfo.root.gridGIV == gridInfo.id

    , setInit : function(gridInfo) {
        gridInfo.app = document.getElementById(gridInfo.id); // 그리드를 포함하는 div 객체
        gridInfo.root = gridInfo.app.getRoot(); // 데이터와 그리드를 포함하는 객체

        // root 객체에 사용자 ID 세팅 : ID로 오브젝트 접근시 사용
        // ex. const app = this[gridID];
        gridInfo.root.gridVID = gridInfo.varId; // 화면에서 선언된 변수명
        gridInfo.root.gridGID = gridInfo.id;    // 그리드의 id

        // Layout
        let layoutStr = this._getLayoutStr(gridInfo.layoutOpt);
        gridInfo.app.setLayout(layoutStr);

        // data
        let gridData;
        gridInfo.app.setData(gridData);
    }

    // 공통 이벤트 등록
    // - event : [Event] layoutCompleteEvent의 event
    , addCommonEvent : function(event, gridInfo) {
        const gridRoot = gridInfo.root;
        const dataGrid = gridRoot.getDataGrid();

        // 메시지박스 표시
        this._showNoDataMessage(gridInfo);

        // 이벤트 등록
        if(isNull(gridInfo.eventOpt)) gridInfo.eventOpt = {};

        // - excelExport
        if ("true" === isNullNvl(gridInfo.eventOpt.isExcelExport, "true")) {
            dataGrid.addEventListener("progress", this._com_exportProgressHandler); // 엑셀 다운로드 진행바
            dataGrid.addEventListener("exportUploadComplete", this._com_exportUploadCompleteHandler); //엑셀 업로드 완료
            dataGrid.addEventListener("exportUpLoadError", this._com_exportUploadErrorHandler); // 엑셀 업로드 오류
        }

        // 셀렉터 컬럼ID 기본값 적용
        if(isNull(gridInfo.selectorColId)) {
            gridInfo.selectorColId = "selector";
        }

        // - 편집그리드일 경우
        if("EDIT" === gridInfo.layoutOpt.type) {
            // 체크박스 자동동작 여부
            if(!isNull(gridInfo.reqDataFields)) {
                dataGrid.addEventListener("itemEdirComplete", this._com_itemEditCompleteHandler);
            }

            // 헤더 필수 표시
            if (!isNull(gridInfo.reqDataFields)) {
                for (let i = 0; i < gridInfo.reqDataFields.length; i++) {
                    const reqDataField = gridInfo.reqDataFields[i];
                    const column = this.findColumn(gridInfo, reqDataField, {resultType:"COLUMN"});
                    column.setHeaderLabelFunction(this._com_headerLabelFunction);
                }
            }

            // 컬럼 기능 적용
            const colArr = dataGrid.getColumns();
            for (let i = 0; i < colArr.length; i++) {
                const column = colArr[i];

                // 편집가능한 경우
                if (column.editable) {
                    // 배경색 표시
                    column.setStyle("backgroundColor", this.style.editBgColor);

                    // DateEditor 속성 추가
                    const colFmt = column.getFormatter();
                    if (!isNull(colFmt) && colFmt.id == "fmtDateEdit") {
                        column.editorProperties = {editable : true, formatString : "YYYYMMDD"};
                    }
                    // MonthEditor 속성 추가
                    if (!isNull(colFmt) && colFmt.id == "fmtMonth") {
                        column.editorProperties = {editable : true, formatString : "YYYYMM"};
                    }
                }

                // 스타일 지정시
                // ERR.컬럼에 styleName 적용하면 적용안됨. > 컬럼별로 setStyle 직접 처리
                const colStyleName = isNull(column._styles) ? "" : column._styles.styleName;
                if (!isNull(colStyleName)) {
                    // 링크 스타일 적용
                    if (colStyleName == "linkStyle") { // gridCom__linkStyle 같음
                        column.setStyle("color", "blue");
                        column.setStyle("cursor", "pointer");
                        column.setStyle("textDecoration", "underline");
                    }
                }
            }
        }
    }

    // 호출 함수
    // 그리드에 데이터 세팅
    // - result : [json] 그리드에 바인딩할 데이터
    , setData : function(gridInfo, result) {
        // 데이터 세팅
        gridInfo.app.setData(result);

        // 필터 제거
        gridInfo.root.getDataGrid().clearColumnFilters();

        // 소트 제거
        const collection = gridInfo.root.getCollection();
        collection.setSort(null);
        collection.refresh();

        // 체크박스 초기화
        if(!isNull(gridInfo.selectorColId)) {
            const selCol = gridInfo.root.getObjectById(gridInfo.selectorColId);
            if (!isNull(selCol)) {
                selCol.setSelectedIndices([]);
            }
        }

        // 메시지박스 처리
        this._showNoDataMessage(gridInfo);
    }

    // 그리드 데이터 삭제
    , removeAll : function(gridInfo) {
        gridInfo.root.removeAll();
        this._showNoDataMessage(gridInfo);
    }

    // 그리드 행 추가
    // - item       : [Json] 추가할 데이터
    // - rowIndex   : [Number] 추가할 행 인덱스
    , addItemAt : function(gridInfo, item, rowIndex = 0) {
        const dataGrid = gridInfo.root.getDataGrid();

        // 작업중인 셀 수정 모드 해제
        dataGrid.setEditedItemPosition(null);

        // 행 추가
        const addRowIdx = gridInfo.root.addItemAt(item, rowIndex);
        if (addRowIdx == -1) {
            return;
        }

        // 체크상태로 변경
        const selCol = this.getSelectorColumn(gridInfo);
        this.setSelect(selCol, addRowIdx);

        // 후처리
        this._showNoDataMessage(gridInfo, "false");

        return addRowIdx;
    }

    // 그리드 체크된 행 저장
    // - url                : [String] ajax URL
    // - fnOnSuccess        : [Function] onSuccess(res, status, xhr)
    // - fnValidation       : [function[ 유효성 체크 함수(list) {return true/false } 생략 가능
    // - opt.confirmMsg     : [String] 별도의 컨폼 메세지 띄울 경우 메세지 (생략 가능, 생략 시 "저장하시겠습니까?")
    // - opt.isChangeData   : [String] dataList를 ChangeData 형태 적용 여부, 적용시 job 정보 존재함. true/false (생략 가능, 생략 시 false)
    , checkSave : function(gridInfo, url, fnOnSuccess, fnValidation, opt) {
        // 에디팅 상태면 에디팅을 닫히도록 한다.
        const dataGrid = gridInfo.root.getDataGrid();
        dataGrid.setEnabled(false);
        dataGrid.setEnabled(true);
        if (dataGrid.errorInEditing) {
            alert('오류를 수정하여 주십시오.');
            return false;
        }

        // 체크된 행 있는지 체크
        const selCol    = this.getSelectorColumn(gridInfo);
        const selIdxArr = this.getSelect(selCol);
        if (selIdxArr.length == 0) {
            alert('처리할 데이터를 선택하세요.');
            return;
        }

        // 오름차순 정렬
        selIdxArr.sort(function(a, b){
            return a - b;
        });

        // 저장할 그리드 데이터 담기
        if (isNull(opt)) opt = {};
        opt.isChangeData = isNullNvl(opt.isChangeData, "false");

        const collection = gridInfo.root.getCollection();
        const changeList = gridInfo.root.getChangedData();
        let dataList = [];
        for (let i = 0; i < selIdxArr.length; i++) {
            const rowIdx = selIdxArr[i];
            const rowData = collection.getitemAt(rowIdx);

            if ("false" === opt.isChangeData) {
                rowData.rowIndex = rowIdx; // 행번호 추가
                dataList.push(rowData);
            } else { // true : changeData 형태 적용
                for (let j = 0; j < changeList.length; j++) {
                    const cRowData = changeList[j];
                    if (rowData.rm_internal_uid == cRowData.data.rm_internal_uid) {
                        rowData.rowIndex = rowIdx; // 행 번호 추가
                        dataList.push(cRowData);
                    }
                }
            }
        }

        if (dataList.length == 0) {
            alert('처리할 데이터가 없습니다.');
            return;
        }

        // 유효성 체크
        if (typeof fnValidation === 'function' && fnValidation(dataList) == false) {
            return;
        }

        if (dataList.length != selIdxArr.length) {
            return;
        }

        // confirm
        opt.confirmMsg = isNullNvl(opt.confirmMsg, "저장하시겠습니까?");
        if (confirm(opt.confirmMsg) == false) {
            return;
        }

        $.ajax({
            url     : url
          , data    : JSON.stringify(dataList)
          , type    : 'POST'
          , success : fnOnSuccess
        });
    }

    // 엑셀 다운로드 : 암호화된 엑셀파일 생성 후 Handler에 의해 파일을 다운로드 한다.
    // - workName       : [String] 업무명, 한글X
    // - fileName       : [String] 다운로드받을 파일명 (ex.영업실적등록신청관리내역)
    // - opt.extension  : [Object] 파일 확장자 (생략가능, 생략시 xlsx)
    // - opt.exportType : [String] 다운로드할 컬럼 타입 (생략가능, 생략시 DEF)
    //                    DEF   : rowState, selector, 히든 제외한 모든 컬럼 다운로드
    //                    ALL   : 모든 컬럼 다운로드
    //                    COL   : 설정한 컬럼인덱스 다운로드 (exportCols 필수)
    // - opt.exportCols : [NumberArray] 다운로드 컬럼 Index (ex.[0,2,3,4,5,6])
    , exportExcel : function(gridInfo, workName, fileName, opt) {
        const gridRoot = gridInfo.root;
        const dataGrid = gridInfo.root.getDataGrid();

        // set option 기본값 세팅
        if(isNull(opt)) opt =  {};
        opt.extenstion = isNullNvl(opt.extension, "xlsx").toLowerCase();
        opt.exportType = isNullNvl(opt.exportType, "DEF").toUpperCase();

        // set download column
        switch(opt.exportType) {
            case "DEF" :
                let colArr = dataGrid.getColumns();
                let colExp = [];
                for (let i = 0; i < colArr.length; i++) {
                    let colCls = colArr[i].className;
                    let colVis = colArr[i].getVisible();
                    if ("DataGridRowStateColumn" != colCls
                     && "DataGridSelectorColumn" != colCls
                     && colVis) {
                        colExp.push(i);
                    }
                }
                dataGrid.exportColumns = colExp;
                break;
            case "ALL" :
                dataGrid.exportColumns = null;
                break;
            case "COL" :
                if (isNull(opt.exportCols)) {
                    alert('엑셀 다운로드할 컬럼 정보가 없습니다.');
                    return;
                }
                dataGrid.exportColumns = opt.exportCols;
                break;
        }

        // progressBar
        dataGrid.setEnabled(false);
        gridRoot.addProgressBar();
        progressBar = gridRoot.getProgressBar();
        progressBar.setProgress(0, 100);
        progressBar.setLabel("Processing");
        progressBar.setLabel("Processing 0%");

        // fileName
        dataGrid.exportFileName = workName;
        $('#frmRmate').find("input[name = 'fileName']").val(fileName + "." + opt.extension);

        // fileMake
        gridRoot.excelExportUpload("/commFile/excelDownMakeFile.do", true);

    }

    , getGridInfo : function(gridRoot) {
        const gridInfo = new Function("return" + gridRoot.gridVID)();
        return gridInfo;
    }

    , _getLayoutStr : function(opt) {
        let layout = '<rMateGrid>';

        // 기본 Formatter
        layout += '<NumberFormatter         id="fmtNum"         useThousandsSeparator="true"/>';
        layout += '<NumberMaskFormatter     id="fmtMonth"       formatString="####-##"/>';
        layout += '<DateFormatter           id="fmtDate"        formatString="YYYY-MM-DD"/>';
        layout += '<DateFormatter           id="fmtHour"        formatString="HH:NN:SS"/>';
        layout += '<DateFormatter           id="fmtDateHour"    formatString="YYYY-MM-DD HH:NN:SS"/>';
        layout += '<DateFormatter           id="fmtDateEdit"    formatString="YYYY-MM-DD"/>';

        // 추가할 헤더부
        layout += isNullNvl(opt.addHeader, "");

        // 그리드 ID
        layout += '<DataGrid id="' + isNullNvl(opt.id, "dg1") + '"';

        // 그리드 타입 기본 옵션 설정 : opt.addOption에 동일한 항목이 있으면 덮어씌우고 없으면 추가 함
        let defOption = {};
        if("EDIT" === opt.type) {
            defOption = {
                selectionMode           : "multipleCells"   // singleRow, multipleCells, multipleRows
              , dragSelectable          : "true"            // 마우스드래그로 셀선택 가능
              , horizontalScrollPolicy  : "auto"            // 가로 스크롤바 표시
              , rollOverColor           : "#fafafa"
              , textRollOverColor       : "#de4a54"
              , headerColors            : "[#f7f7f7, #f7f7f7]"
              , verticalAlign           : "middle"
              , textAlign               : "center"
              , sortableColumns         : "false"
              , sortExpertMode          : "true"
              , editable                : "true"
              , doubleClickEnabled      : "false"
            };
        } else {
            defOption = {
                selectionMode           : "multipleCells"
              , horizontalScrollPolicy  : "auto"
              , rollOverColor           : "#fafafa"
              , textRollOverColor       : "#de4a54"
              , headerColors            : "[#f7f7f7, #f7f7f7]"
              , verticalAlign           : "middle"
              , textAlign               : "center"
              , sortableColumns         : "false"
              , sortExpertMode          : "true"
            };
        }

        // 추가할 그리드 옵션
        if(isNull(opt.addOption)) { // opt.addOption이 없으면 defOption 적용
            opt.addOption = defOption;
        } else { // opt.addOptions에 defOption 내용이 없으면 추가
            const keys = Object.keys(defOption);
            for (idx in keys) {
                const key = keys[idx];
                if (!opt.addOption[key]) { // 값이 null, undefined, false 등이면 false 반환, 주의 필요
                    opt.addOption[key] = defOption[key];
                }
            }
        }

        for(const[key, val] of Object.entries(opt.addOption)) {
            layout += ' ' + key + "=" + '"' + val + '"';
        }
        layout += ">";

        // 추가할 content // ${opt.addContent}
        layout += isNullNvl(opt.addContent, ""); //ex.<columns> 내용 </columns>
        layout += '</DataGrid>';

        // 추가할 하단부
        layout += isNullNvl(opt.addBottom, "");

        // style
        if (!isNull(opt.addStyle)) {
            layout += isNullNvl(opt.addStyle, "");
        }

        // 메세지박스
        layout += '<Box id="messageBox" width="100%" height="96%" verticalAlign="middle" horizontalAlign="center" visible="false">';
        layout += '  <Box paddingTop="5px" paddingBottom="5px" paddingRight="5px" paddingLeft="5px">';
        layout += '     <Label id="messageLabel" text="검색된 데이터가 없습니다." fontSize="13px" fontWeight="bold" color="#ddddd" textAlign="center"/>';
        layout += '  </Box>';
        layout += '</Box>';

        layout += '</rMateGrid>';
        return layout;
    }

    // 그리드 메시지박스 표시/숨김
    // - isShow : [String] 메시지 박스 보일지 말지 여부. true/false (생략 가능, 생략 시 그리드 데이터 존재여부로 판단)
    , _showNoDataMessage : function(gridInfo, isShow) {
        const messageBox = gridInfo.root.getObjectById("messageBox");
        if(isNull(messageBox)) {
            return;
        }

        // showYn 값이 있으면 우선순위로 처리
        if(!isNull(isShow)) {
            if ("true" === isShow) {
                messageBox.setVisible(true);
            } else if ("false" === isShow) {
                messageBox.setVisible(false);
                return;
            }
        }

        // isShow 값이 없으면 그리드 데이터 있는지 여부로 처리
        const gridData = gridInfo.root.getGridData();
        if (isNull(gridData) || gridData.length == 0) {
            messageBox.setVisible(true);
        } else {
            messageBox.setVisible(false);
        }
    }


}