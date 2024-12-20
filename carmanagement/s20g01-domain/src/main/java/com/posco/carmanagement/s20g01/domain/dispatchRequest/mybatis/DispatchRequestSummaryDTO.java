package com.posco.carmanagement.s20g01.domain.dispatchRequest.mybatis;

import com.posco.carmanagement.s20g01.domain.RequestStage;
import com.posco.carmanagement.s20g01.domain.VehicleType;
import java.util.Date;
import lombok.Data;

@Data
public class DispatchRequestSummaryDTO {

    private Long dispatchRequestId;
    private String requesterName;
    private String department;
    private String purpose;
    private VehicleType vehicleType;
    private RequestStage status;
    private Date lastUpdated;
}
