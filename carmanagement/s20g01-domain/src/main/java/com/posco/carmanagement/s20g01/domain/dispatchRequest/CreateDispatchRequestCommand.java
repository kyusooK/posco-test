package com.posco.carmanagement.s20g01.domain.dispatchRequest;

import com.posco.carmanagement.s20g01.domain.ApprovalInfo;
import com.posco.carmanagement.s20g01.domain.Department;
import com.posco.carmanagement.s20g01.domain.DriverIncluded;
import com.posco.carmanagement.s20g01.domain.RequestPeriod;
import com.posco.carmanagement.s20g01.domain.RequesterInfo;
import com.posco.carmanagement.s20g01.domain.UsageType;
import com.posco.carmanagement.s20g01.domain.VehicleType;
import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class CreateDispatchRequestCommand {

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
}
