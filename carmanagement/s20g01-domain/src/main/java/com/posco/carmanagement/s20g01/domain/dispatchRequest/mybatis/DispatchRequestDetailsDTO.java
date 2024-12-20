package com.posco.carmanagement.s20g01.domain.dispatchRequest.mybatis;

import com.posco.carmanagement.s20g01.domain.ApprovalInfo;
import com.posco.carmanagement.s20g01.domain.Department;
import com.posco.carmanagement.s20g01.domain.DriverIncluded;
import com.posco.carmanagement.s20g01.domain.RequestPeriod;
import com.posco.carmanagement.s20g01.domain.RequestStage;
import com.posco.carmanagement.s20g01.domain.RequesterInfo;
import com.posco.carmanagement.s20g01.domain.UsageType;
import com.posco.carmanagement.s20g01.domain.VehicleType;
import java.util.Date;
import lombok.Data;

@Data
public class DispatchRequestDetailsDTO {

    private Long dispatchRequestId;
    private RequesterInfo requesterInfo;
    private ApprovalInfo approvalInfo;
    private RequestPeriod requestPeriod;
    private String purpose;
    private UsageType usageType;
    private Department department;
    private Integer numberOfPassengers;
    private VehicleType vehicleType;
    private DriverIncluded driverIncluded;
    private String contactNumber;
    private String attachment;
    private String remarks;
    private RequestStage status;
    private Date lastUpdated;
}