package com.posco.carmanagement.s20g01.domain.requestStatus;

import com.posco.carmanagement.s20g01.domain.DispatchRequestReference;
import com.posco.carmanagement.s20g01.domain.RequestStage;
import com.posco.carmanagement.s20g01.domain.StatusDetails;
import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class CreateRequestStatusCommand {

    private DispatchRequestReference dispatchRequestReference;
    private StatusDetails statusDetails;
    private RequestStage currentStage;
    private Date lastUpdated;
}
