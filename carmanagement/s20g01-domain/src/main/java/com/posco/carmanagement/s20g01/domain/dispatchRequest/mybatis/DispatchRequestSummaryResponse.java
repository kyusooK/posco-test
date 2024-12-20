package com.posco.carmanagement.s20g01.domain.dispatchRequest.mybatis;

import java.util.Date;
import lombok.Data;

@Data
public class DispatchRequestSummaryResponse {

    private Long id;
    private String requesterName;
    private String department;
    private String purpose;
}
