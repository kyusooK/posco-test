package com.posco.carmanagement.s20g01.domain.requestStatus.mybatis;

import com.posco.carmanagement.s20g01.domain.DispatchRequestReference;
import com.posco.carmanagement.s20g01.domain.RequestStage;
import com.posco.carmanagement.s20g01.domain.StatusDetails;
import java.util.Date;
import lombok.Data;

@Data
public class RequestStatusDetailsDTO {

    private Long requestStatusId;
    private DispatchRequestReference dispatchRequestReference;
    private StatusDetails statusDetails;
    private RequestStage currentStage;
    private Date lastUpdated;
}
