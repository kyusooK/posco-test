package com.posco.carmanagement.s20g01.domain.requestStatus;

import com.posco.carmanagement.s20g01.domain.RequestStage;
import com.posco.carmanagement.s20g01.domain.StatusDetails;
import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class UpdateRequestStageCommand {

    private Long requestStatusId;
    private RequestStage currentStage;
    private StatusDetails statusDetails;
}
