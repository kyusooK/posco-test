package com.posco.carmanagement.s20g01.domain.dispatchRequest.mybatis;

import com.posco.carmanagement.s20g01.domain.dispatchRequest.mybatis.DispatchRequestDetailsDTO;
import com.posco.carmanagement.s20g01.domain.dispatchRequest.mybatis.DispatchRequestDetailsResponse;
import com.posco.carmanagement.s20g01.domain.dispatchRequest.mybatis.DispatchRequestSummaryDTO;
import com.posco.carmanagement.s20g01.domain.dispatchRequest.mybatis.DispatchRequestSummaryResponse;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DispatchRequestMapper {
    DispatchRequestSummaryResponse dispatchRequestSummary(
        DispatchRequestSummaryDTO dto
    );
    DispatchRequestDetailsResponse dispatchRequestDetails(
        DispatchRequestDetailsDTO dto
    );
}
