package com.posco.carmanagement.s20g01.domain.requestStatus;

import com.posco.carmanagement.s20g01.domain.DispatchRequestReference;
import com.posco.carmanagement.s20g01.domain.RequestStage;
import com.posco.carmanagement.s20g01.domain.StatusDetails;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "RequestStatus_table")
@Data
public class RequestStatus {

    @Id
    private Long requestStatusId;

    @Embedded
    private DispatchRequestReference dispatchRequestReference;

    @Embedded
    private StatusDetails statusDetails;

    @Enumerated(EnumType.STRING)
    private RequestStage currentStage;

    private Date lastUpdated;
}
