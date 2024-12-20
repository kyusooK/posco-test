package com.posco.carmanagement.s20g01.domain.dispatchRequest;

import com.posco.carmanagement.s20g01.domain.dispatchRequest.CancelDispatchRequestCommand;
import com.posco.carmanagement.s20g01.domain.dispatchRequest.CreateDispatchRequestCommand;
import com.posco.carmanagement.s20g01.domain.dispatchRequest.DispatchRequest;
import com.posco.carmanagement.s20g01.domain.dispatchRequest.DispatchRequestRepository;
import com.posco.carmanagement.s20g01.domain.dispatchRequest.UpdateDispatchRequestCommand;
import com.posco.carmanagement.s20g01.domain.dispatchRequest.mybatis.DispatchRequestDetailsDTO;
import com.posco.carmanagement.s20g01.domain.dispatchRequest.mybatis.DispatchRequestDetailsResponse;
import com.posco.carmanagement.s20g01.domain.dispatchRequest.mybatis.DispatchRequestMapper;
import com.posco.carmanagement.s20g01.domain.dispatchRequest.mybatis.DispatchRequestSummaryDTO;
import com.posco.carmanagement.s20g01.domain.dispatchRequest.mybatis.DispatchRequestSummaryResponse;
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
public class DispatchRequestService {

    private final DispatchRequestRepository dispatchRequestRepository;
    private final DispatchRequestMapper dispatchRequestMapper;

    @Autowired
    public DispatchRequestService(
        DispatchRequestRepository dispatchRequestRepository,
        DispatchRequestMapper dispatchRequestMapper
    ) {
        this.dispatchRequestRepository = dispatchRequestRepository;
        this.dispatchRequestMapper = dispatchRequestMapper;
    }

    public DispatchRequest create(CreateDispatchRequestCommand command) {
        DispatchRequest dispatchRequest = new DispatchRequest();
        dispatchRequest.setRequesterInfo(command.getRequesterInfo());
        dispatchRequest.setApprovalInfo(command.getApprovalInfo());
        dispatchRequest.setRequestPeriod(command.getRequestPeriod());
        dispatchRequest.setPurpose(command.getPurpose());
        dispatchRequest.setUsageType(command.getUsageType());
        dispatchRequest.setDepartment(command.getDepartment());
        dispatchRequest.setNumberOfPassengers(command.getNumberOfPassengers());
        dispatchRequest.setVehicleType(command.getVehicleType());
        dispatchRequest.setDriverIncluded(command.getDriverIncluded());
        dispatchRequest.setContactNumber(command.getContactNumber());
        dispatchRequest.setAttachment(command.getAttachment());
        dispatchRequest.setRemarks(command.getRemarks());
        return dispatchRequestRepository.save(dispatchRequest);
    }

    public DispatchRequest update(
        Long id,
        UpdateDispatchRequestCommand command
    ) {
        DispatchRequest existing = findById(id);
        if (command.getDispatchRequestId() != null) {
            existing.setDispatchRequestId(command.getDispatchRequestId());
        }
        if (command.getRequesterInfo() != null) {
            existing.setRequesterInfo(command.getRequesterInfo());
        }
        if (command.getApprovalInfo() != null) {
            existing.setApprovalInfo(command.getApprovalInfo());
        }
        if (command.getRequestPeriod() != null) {
            existing.setRequestPeriod(command.getRequestPeriod());
        }
        if (command.getPurpose() != null) {
            existing.setPurpose(command.getPurpose());
        }
        if (command.getUsageType() != null) {
            existing.setUsageType(command.getUsageType());
        }
        if (command.getDepartment() != null) {
            existing.setDepartment(command.getDepartment());
        }
        if (command.getNumberOfPassengers() != null) {
            existing.setNumberOfPassengers(command.getNumberOfPassengers());
        }
        if (command.getVehicleType() != null) {
            existing.setVehicleType(command.getVehicleType());
        }
        if (command.getDriverIncluded() != null) {
            existing.setDriverIncluded(command.getDriverIncluded());
        }
        if (command.getContactNumber() != null) {
            existing.setContactNumber(command.getContactNumber());
        }
        if (command.getAttachment() != null) {
            existing.setAttachment(command.getAttachment());
        }
        if (command.getRemarks() != null) {
            existing.setRemarks(command.getRemarks());
        }
        return dispatchRequestRepository.save(existing);
    }

    public void delete(Long id) {
        DispatchRequest dispatchRequest = findById(id);
        dispatchRequestRepository.delete(dispatchRequest);
    }

    public DispatchRequest save(DispatchRequest dispatchRequest) {
        return dispatchRequestRepository.save(dispatchRequest);
    }

    public List<DispatchRequest> findAll() {
        return dispatchRequestRepository.findAll();
    }

    public DispatchRequest findById(Long id) {
        return dispatchRequestRepository
            .findById(id)
            .orElseThrow(() ->
                new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "DispatchRequest not found"
                )
            );
    }

    //// readModel mybatis
    public DispatchRequestSummaryResponse dispatchRequestSummary(
        DispatchRequestSummaryDTO dto
    ) {
        DispatchRequestSummaryResponse response = dispatchRequestMapper.dispatchRequestSummary(
            dto
        );
        if (response == null) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "DispatchRequestSummary not found"
            );
        }
        return response;
    }

    public DispatchRequestDetailsResponse dispatchRequestDetails(
        DispatchRequestDetailsDTO dto
    ) {
        DispatchRequestDetailsResponse response = dispatchRequestMapper.dispatchRequestDetails(
            dto
        );
        if (response == null) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "DispatchRequestDetails not found"
            );
        }
        return response;
    }
}
