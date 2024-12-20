package com.posco.carmanagement.s20g01.domain.requestStatus.mybatis;

import com.posco.carmanagement.s20g01.domain.requestStatus.mybatis.RequestStatusDetailsDTO;
import com.posco.carmanagement.s20g01.domain.requestStatus.mybatis.RequestStatusDetailsResponse;
import com.posco.carmanagement.s20g01.domain.requestStatus.mybatis.RequestStatusSummaryDTO;
import com.posco.carmanagement.s20g01.domain.requestStatus.mybatis.RequestStatusSummaryResponse;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RequestStatusMapper {
    RequestStatusSummaryResponse requestStatusSummary(
        RequestStatusSummaryDTO dto
    );
    RequestStatusDetailsResponse requestStatusDetails(
        RequestStatusDetailsDTO dto
    );
}
