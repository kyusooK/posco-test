package com.posco.carmanagement.s20g01.domain.requestStatus;

import com.posco.carmanagement.s20g01.domain.requestStatus.CreateRequestStatusCommand;
import com.posco.carmanagement.s20g01.domain.requestStatus.RequestStatus;
import com.posco.carmanagement.s20g01.domain.requestStatus.RequestStatusRepository;
import com.posco.carmanagement.s20g01.domain.requestStatus.UpdateRequestStageCommand;
import com.posco.carmanagement.s20g01.domain.requestStatus.mybatis.RequestStatusDetailsDTO;
import com.posco.carmanagement.s20g01.domain.requestStatus.mybatis.RequestStatusDetailsResponse;
import com.posco.carmanagement.s20g01.domain.requestStatus.mybatis.RequestStatusMapper;
import com.posco.carmanagement.s20g01.domain.requestStatus.mybatis.RequestStatusSummaryDTO;
import com.posco.carmanagement.s20g01.domain.requestStatus.mybatis.RequestStatusSummaryResponse;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@Transactional
public class RequestStatusService {

    private final RequestStatusRepository requestStatusRepository;
    private final RequestStatusMapper requestStatusMapper;

    @Autowired
    public RequestStatusService(
        RequestStatusRepository requestStatusRepository,
        RequestStatusMapper requestStatusMapper
    ) {
        this.requestStatusRepository = requestStatusRepository;
        this.requestStatusMapper = requestStatusMapper;
    }

    public RequestStatus create(CreateRequestStatusCommand command) {
        RequestStatus requestStatus = new RequestStatus();
        requestStatus.setDispatchRequestReference(
            command.getDispatchRequestReference()
        );
        requestStatus.setStatusDetails(command.getStatusDetails());
        requestStatus.setCurrentStage(command.getCurrentStage());
        requestStatus.setLastUpdated(command.getLastUpdated());
        return requestStatusRepository.save(requestStatus);
    }

    public RequestStatus update(Long id, UpdateRequestStageCommand command) {
        RequestStatus existing = findById(id);
        if (command.getRequestStatusId() != null) {
            existing.setRequestStatusId(command.getRequestStatusId());
        }
        if (command.getCurrentStage() != null) {
            existing.setCurrentStage(command.getCurrentStage());
        }
        if (command.getStatusDetails() != null) {
            existing.setStatusDetails(command.getStatusDetails());
        }
        return requestStatusRepository.save(existing);
    }

    public RequestStatus save(RequestStatus requestStatus) {
        return requestStatusRepository.save(requestStatus);
    }

    public List<RequestStatus> findAll() {
        return requestStatusRepository.findAll();
    }

    public RequestStatus findById(Long id) {
        return requestStatusRepository
            .findById(id)
            .orElseThrow(() ->
                new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "RequestStatus not found"
                )
            );
    }

    //// readModel mybatis
    public RequestStatusSummaryResponse requestStatusSummary(
        RequestStatusSummaryDTO dto
    ) {
        RequestStatusSummaryResponse response = requestStatusMapper.requestStatusSummary(
            dto
        );
        if (response == null) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "RequestStatusSummary not found"
            );
        }
        return response;
    }

    public RequestStatusDetailsResponse requestStatusDetails(
        RequestStatusDetailsDTO dto
    ) {
        RequestStatusDetailsResponse response = requestStatusMapper.requestStatusDetails(
            dto
        );
        if (response == null) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "RequestStatusDetails not found"
            );
        }
        return response;
    }
}
