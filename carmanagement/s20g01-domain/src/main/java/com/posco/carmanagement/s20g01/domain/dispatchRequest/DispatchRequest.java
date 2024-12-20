package com.posco.carmanagement.s20g01.domain.dispatchRequest;

import com.posco.carmanagement.s20g01.domain.ApprovalInfo;
import com.posco.carmanagement.s20g01.domain.Department;
import com.posco.carmanagement.s20g01.domain.DriverIncluded;
import com.posco.carmanagement.s20g01.domain.RequestPeriod;
import com.posco.carmanagement.s20g01.domain.RequesterInfo;
import com.posco.carmanagement.s20g01.domain.UsageType;
import com.posco.carmanagement.s20g01.domain.VehicleType;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "DispatchRequest_table")
@Data
public class DispatchRequest {

    @Id
    private Long dispatchRequestId;

    @Embedded
    private RequesterInfo requesterInfo;

    @Embedded
    private ApprovalInfo approvalInfo;

    @Embedded
    private RequestPeriod requestPeriod;

    private String purpose;

    @Enumerated(EnumType.STRING)
    private UsageType usageType;

    @Enumerated(EnumType.STRING)
    private Department department;

    private Integer numberOfPassengers;

    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;

    @Enumerated(EnumType.STRING)
    private DriverIncluded driverIncluded;

    private String contactNumber;

    private String attachment;

    private String remarks;
}
