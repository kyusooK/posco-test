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
            {"Header": "purpose", "Name": "purpose", "Type": "Text", "Align": "Center", "Width":140, "CanEdit":1},  
            {"Header": "numberOfPassengers", "Name": "numberOfPassengers", "Type": "Int", "Align": "Center", "Width":140, "CanEdit":1},  
            {"Header": "contactNumber", "Name": "contactNumber", "Type": "Text", "Align": "Center", "Width":140, "CanEdit":1},  
            {"Header": "attachment", "Name": "attachment", "Type": "Text", "Align": "Center", "Width":140, "CanEdit":1},  
            {"Header": "remarks", "Name": "remarks", "Type": "Text", "Align": "Center", "Width":140, "CanEdit":1},  
            {"Header": ["requesterInfo", "Name"], "Name": "Name", "Type": "Text", "Width": 140, "CanEdit": 1},
            {"Header": ["requesterInfo", "Organization"], "Name": "Organization", "Type": "Text", "Width": 140, "CanEdit": 1},
            {"Header": ["requesterInfo", "EmployeeNumber"], "Name": "EmployeeNumber", "Type": "Text", "Width": 140, "CanEdit": 1},
            {"Header": ["requesterInfo", "PhoneNumber"], "Name": "PhoneNumber", "Type": "Text", "Width": 140, "CanEdit": 1},
            {"Header": ["requesterInfo", "MobileNumber"], "Name": "MobileNumber", "Type": "Text", "Width": 140, "CanEdit": 1},
            {"Header": ["requesterInfo", "RequestDate"], "Name": "RequestDate", "Type": "Date", "Width": 140, "CanEdit": 1},
            {"Header": ["approvalInfo", "ApproverName"], "Name": "ApproverName", "Type": "Text", "Width": 140, "CanEdit": 1},
            {"Header": ["approvalInfo", "ApproverPosition"], "Name": "ApproverPosition", "Type": "Text", "Width": 140, "CanEdit": 1},
            {"Header": ["requestPeriod", "StartDate"], "Name": "StartDate", "Type": "Date", "Width": 140, "CanEdit": 1},
            {"Header": ["requestPeriod", "EndDate"], "Name": "EndDate", "Type": "Date", "Width": 140, "CanEdit": 1},
            {"Header": "usageType", "Name": "usageType", "Type": "Enum", "Enum": "|BUSINESS_SUPPORT|EXTERNAL_ACTIVITY", "EnumKeys": "|BUSINESS_SUPPORT|EXTERNAL_ACTIVITY", "Align": "Center", "Width":140, "CanEdit":0},
            {"Header": "department", "Name": "department", "Type": "Enum", "Enum": "|SEOUL|POHANG|GWANGYANG", "EnumKeys": "|SEOUL|POHANG|GWANGYANG", "Align": "Center", "Width":140, "CanEdit":0},
            {"Header": "vehicleType", "Name": "vehicleType", "Type": "Enum", "Enum": "|SEDAN|VAN|TRUCK", "EnumKeys": "|SEDAN|VAN|TRUCK", "Align": "Center", "Width":140, "CanEdit":0},
            {"Header": "driverIncluded", "Name": "driverIncluded", "Type": "Enum", "Enum": "|YES|NO", "EnumKeys": "|YES|NO", "Align": "Center", "Width":140, "CanEdit":0},
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
    fetch("/dispatchRequests", {
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
            json[i].No = json[i].dispatchRequestId
            
                if (json[i].requesterInfo) {
                    json[i].Name = json[i].requesterInfo.Name;
json[i].Organization = json[i].requesterInfo.Organization;
json[i].EmployeeNumber = json[i].requesterInfo.EmployeeNumber;
json[i].PhoneNumber = json[i].requesterInfo.PhoneNumber;
json[i].MobileNumber = json[i].requesterInfo.MobileNumber;
json[i].RequestDate = json[i].requesterInfo.RequestDate.split('T')[0]
                }
                
            
                if (json[i].approvalInfo) {
                    json[i].ApproverName = json[i].approvalInfo.ApproverName;
json[i].ApproverPosition = json[i].approvalInfo.ApproverPosition
                }
                
            
                if (json[i].requestPeriod) {
                    json[i].StartDate = json[i].requestPeriod.StartDate.split('T')[0];
json[i].EndDate = json[i].requestPeriod.EndDate.split('T')[0]
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
        url: "/dispatchRequests",
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
        rows[i].dispatchRequestId = rows[i].No
        delete rows[i].No

        
                if (rows[i].Name && rows[i].Organization && rows[i].EmployeeNumber && rows[i].PhoneNumber && rows[i].MobileNumber && rows[i].RequestDate) {
                    rows[i].requesterInfo = {
                        Name: rows[i].Name,
Organization: rows[i].Organization,
EmployeeNumber: rows[i].EmployeeNumber,
PhoneNumber: rows[i].PhoneNumber,
MobileNumber: rows[i].MobileNumber,
RequestDate: rows[i].RequestDate
                    };
                    delete rows[i].Name;
delete rows[i].Organization;
delete rows[i].EmployeeNumber;
delete rows[i].PhoneNumber;
delete rows[i].MobileNumber;
delete rows[i].RequestDate
                }
                
        
                if (rows[i].ApproverName && rows[i].ApproverPosition) {
                    rows[i].approvalInfo = {
                        ApproverName: rows[i].ApproverName,
ApproverPosition: rows[i].ApproverPosition
                    };
                    delete rows[i].ApproverName;
delete rows[i].ApproverPosition
                }
                
        
                if (rows[i].StartDate && rows[i].EndDate) {
                    rows[i].requestPeriod = {
                        StartDate: rows[i].StartDate,
EndDate: rows[i].EndDate
                    };
                    delete rows[i].StartDate;
delete rows[i].EndDate
                }
                
    }
    
    rowData = rows;

    for(var i=0; i<rows.length;i++){
        switch(rows[i].STATUS){
            case "Changed":
                var rowObj = sheet.getRowById(rows[i].id);
                var changedData = JSON.parse(sheet.getChangedData(rowObj))["Changes"][0];
                changedData.id = rows[i].dispatchRequestId
                var id = changedData.id 
                $.ajax({
                    url: `/dispatchRequests/${id}`,
                    method: "PATCH",
                    contentType: "application/json",
                    data: JSON.stringify(changedData)
                });
                break;
            case "Deleted":
                var id = rows[i].dispatchRequestId
                $.ajax({
                    url: `/dispatchRequests/${id}`,
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
    
    fetch(`/dispatchRequests/${path}?${queryParams.toString()}`, {
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
