package com.posco.carmanagement.s20g01.domain.requestStatus.mybatis;

import com.posco.carmanagement.s20g01.domain.DispatchRequestReference;
import com.posco.carmanagement.s20g01.domain.RequestStage;
import java.util.Date;
import lombok.Data;

@Data
public class RequestStatusSummaryResponse {

    private Long id;
    private DispatchRequestReference dispatchRequestReference;
    private RequestStage currentStage;
}
