package com.posco.carmanagement.s20g01.domain.dispatchRequest.mybatis;

import java.util.Date;
import lombok.Data;

@Data
public class DispatchRequestDetailsResponse {

    private Long id;
    private String contactNumber;
    private String attachment;
    private String remarks;
}
