let rowData = [];
$(document).ready(function(){
    var OPT = {
        "Cfg": {
            "SearchMode": 2,
            "HeaderMerge": 3,
            "MessageWidth": 300,
        },
        "Def": {
            "Row": {
            "CanFormula": true
            }
        },
        Cols:[
            {"Header": "No", "Name": "No", "Type": "Int", "Align": "Center", "Width":140, "CanEdit":0},
            {"Header": "lastUpdated", "Name": "lastUpdated", "Type": "Date","Format": "yyyy-MM-dd", "EmptyValue": "날짜를 입력해주세요", "Align": "Center", "Width":140, "CanEdit":1},  
            {"Header": ["dispatchRequestReference", "RequesterInfo"], "Name": "RequesterInfo",  "Width": 140, "CanEdit": 1},
            {"Header": ["dispatchRequestReference", "RequestPeriod"], "Name": "RequestPeriod",  "Width": 140, "CanEdit": 1},
            {"Header": ["dispatchRequestReference", "Purpose"], "Name": "Purpose", "Type": "Text", "Width": 140, "CanEdit": 1},
            {"Header": ["dispatchRequestReference", "VehicleType"], "Name": "VehicleType",  "Width": 140, "CanEdit": 1},
            {"Header": ["statusDetails", "StageDescription"], "Name": "StageDescription", "Type": "Text", "Width": 140, "CanEdit": 1},
            {"Header": ["statusDetails", "ApproverName"], "Name": "ApproverName", "Type": "Text", "Width": 140, "CanEdit": 1},
            {"Header": ["statusDetails", "ApprovalDate"], "Name": "ApprovalDate", "Type": "Date", "Width": 140, "CanEdit": 1},
            {"Header": ["statusDetails", "Remarks"], "Name": "Remarks", "Type": "Text", "Width": 140, "CanEdit": 1},
            {"Header": "requestStage", "Name": "requestStage", "Type": "Enum", "Enum": "|RECEIVED|APPROVED|REJECTED|COMPLETED", "EnumKeys": "|RECEIVED|APPROVED|REJECTED|COMPLETED", "Align": "Center", "Width":140, "CanEdit":0},
            {"Header": ["statusDetails", "StageDescription"], "Name": "StageDescription", "Type": "Text", "Width": 140, "CanEdit": 1},
            {"Header": ["statusDetails", "ApproverName"], "Name": "ApproverName", "Type": "Text", "Width": 140, "CanEdit": 1},
            {"Header": ["statusDetails", "ApprovalDate"], "Name": "ApprovalDate", "Type": "Date", "Width": 140, "CanEdit": 1},
            {"Header": ["statusDetails", "Remarks"], "Name": "Remarks", "Type": "Text", "Width": 140, "CanEdit": 1},
        ],
        Events: {
            onClick: function(evtParam) {
                var originalRowData = rowData.find(item => item.No === evtParam.row.No);
                var detailData = [];
        
                detailSheet.loadSearchData(detailData);
            }
        }
    };
    
    var detailSheetOptions = {
        "Cfg": {
            "SearchMode": 2,
            "HeaderMerge": 3,
            "MessageWidth": 300,
        },
        Cols:[
        ]
    };

    IBSheet.create({
       id:"sheet",
       el:"sheet_DIV",
       options: OPT
    });
    
    IBSheet.create({
        id:"detailSheet",
        el:"detailSheet_DIV",
        options: detailSheetOptions
    });
   
});

function retrieve(){
    fetch("/requestStatuses", {
        method: 'GET',
        headers: {
            "Cache-Control": "no-cache",
            "Pragma": "no-cache",
            "Content-Type": "application/json"
        }
    }).then(res => {
        return res.json();
    }).then(json => {
        for(var i = 0; i < json.length; i++){
            json[i].No = json[i].requestStatusId
            
                if (json[i].dispatchRequestReference) {
                    json[i].RequesterInfo = json[i].dispatchRequestReference.RequesterInfo;
json[i].RequestPeriod = json[i].dispatchRequestReference.RequestPeriod;
json[i].Purpose = json[i].dispatchRequestReference.Purpose;
json[i].VehicleType = json[i].dispatchRequestReference.VehicleType
                }
                
            
                if (json[i].statusDetails) {
                    json[i].StageDescription = json[i].statusDetails.StageDescription;
json[i].ApproverName = json[i].statusDetails.ApproverName;
json[i].ApprovalDate = json[i].statusDetails.ApprovalDate.split('T')[0];
json[i].Remarks = json[i].statusDetails.Remarks
                }
                
            
                if (json[i].statusDetails) {
                    json[i].StageDescription = json[i].statusDetails.StageDescription;
json[i].ApproverName = json[i].statusDetails.ApproverName;
json[i].ApprovalDate = json[i].statusDetails.ApprovalDate.split('T')[0];
json[i].Remarks = json[i].statusDetails.Remarks
                }
                

        }
        
        rowData = json;
        sheet.loadSearchData(json)
    }).catch(error => {
        console.error("에러", error);
    });
}

function addData(){
   sheet.addRow();
}

function deleteData(){
    sheet.deleteRow(sheet.getFocusedRow());
}

function save(data){
    var rows = data;

    $.ajax({
        url: "/requestStatuses",
        method: "POST",
        contentType: "application/json",
        data: JSON.stringify(rows),
        success: function() {
            retrieve();
        }
    });
    

}

function saveRow(){
    var rows = sheet.getSaveJson()?.data;
    for(var i = 0; i < rows.length; i++){
        rows[i].requestStatusId = rows[i].No
        delete rows[i].No

        
                if (rows[i].RequesterInfo && rows[i].RequestPeriod && rows[i].Purpose && rows[i].VehicleType) {
                    rows[i].dispatchRequestReference = {
                        RequesterInfo: rows[i].RequesterInfo,
RequestPeriod: rows[i].RequestPeriod,
Purpose: rows[i].Purpose,
VehicleType: rows[i].VehicleType
                    };
                    delete rows[i].RequesterInfo;
delete rows[i].RequestPeriod;
delete rows[i].Purpose;
delete rows[i].VehicleType
                }
                
        
                if (rows[i].StageDescription && rows[i].ApproverName && rows[i].ApprovalDate && rows[i].Remarks) {
                    rows[i].statusDetails = {
                        StageDescription: rows[i].StageDescription,
ApproverName: rows[i].ApproverName,
ApprovalDate: rows[i].ApprovalDate,
Remarks: rows[i].Remarks
                    };
                    delete rows[i].StageDescription;
delete rows[i].ApproverName;
delete rows[i].ApprovalDate;
delete rows[i].Remarks
                }
                
        
                if (rows[i].StageDescription && rows[i].ApproverName && rows[i].ApprovalDate && rows[i].Remarks) {
                    rows[i].statusDetails = {
                        StageDescription: rows[i].StageDescription,
ApproverName: rows[i].ApproverName,
ApprovalDate: rows[i].ApprovalDate,
Remarks: rows[i].Remarks
                    };
                    delete rows[i].StageDescription;
delete rows[i].ApproverName;
delete rows[i].ApprovalDate;
delete rows[i].Remarks
                }
                
    }
    
    rowData = rows;

    for(var i=0; i<rows.length;i++){
        switch(rows[i].STATUS){
            case "Changed":
                var rowObj = sheet.getRowById(rows[i].id);
                var changedData = JSON.parse(sheet.getChangedData(rowObj))["Changes"][0];
                changedData.id = rows[i].requestStatusId
                var id = changedData.id 
                $.ajax({
                    url: `/requestStatuses/${id}`,
                    method: "PATCH",
                    contentType: "application/json",
                    data: JSON.stringify(changedData)
                });
                break;
            case "Deleted":
                var id = rows[i].requestStatusId
                $.ajax({
                    url: `/requestStatuses/${id}`,
                    method: "DELETE",
                });
                break;
        }     
    }           
}
function searchMultiple(data, path) {
    // Convert data object to query parameters
    const queryParams = new URLSearchParams();
    
    function flattenObject(obj, prefix = '') {
        Object.keys(obj).forEach(key => {
            const value = obj[key];
            const newKey = prefix ? `${prefix}.${key}` : key;
            
            if (value && typeof value === 'object' && !Array.isArray(value)) {
                flattenObject(value, newKey);
            } else {
                queryParams.append(newKey, value);
            }
        });
    }
    
    flattenObject(data);
    
    fetch(`/requestStatuses/${path}?${queryParams.toString()}`, {
        method: 'GET',
        headers: {
            'Accept': 'application/json'
        }
    })
    .then(response => {
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        return response.json();
    })
    .then(data => {
        console.log('Success:', data);
        if (data) {
            sheet.loadSearchData([data]);
        }
    })
    .catch((error) => {
        console.error('Error:', error);
        alert('데이터 조회 중 오류가 발생했습니다: ' + error.message);
    });
}
