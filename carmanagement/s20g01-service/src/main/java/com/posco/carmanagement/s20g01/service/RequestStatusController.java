package com.posco.carmanagement.s20g01.service;

import com.posco.carmanagement.s20g01.domain.requestStatus.CreateRequestStatusCommand;
import com.posco.carmanagement.s20g01.domain.requestStatus.RequestStatus;
import com.posco.carmanagement.s20g01.domain.requestStatus.RequestStatusService;
import com.posco.carmanagement.s20g01.domain.requestStatus.UpdateRequestStageCommand;
import com.posco.carmanagement.s20g01.domain.requestStatus.mybatis.RequestStatusDetailsDTO;
import com.posco.carmanagement.s20g01.domain.requestStatus.mybatis.RequestStatusDetailsResponse;
import com.posco.carmanagement.s20g01.domain.requestStatus.mybatis.RequestStatusSummaryDTO;
import com.posco.carmanagement.s20g01.domain.requestStatus.mybatis.RequestStatusSummaryResponse;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RepositoryRestController
public class RequestStatusController {

    private final RequestStatusService requestStatusService;

    @Autowired
    public RequestStatusController(RequestStatusService requestStatusService) {
        this.requestStatusService = requestStatusService;
    }

    @GetMapping(path = "/requestStatuses")
    public ResponseEntity<List<RequestStatus>> findAll() {
        return ResponseEntity.ok(requestStatusService.findAll());
    }

    @PostMapping(path = "/requestStatuses")
    public ResponseEntity<RequestStatus> create(
        @Valid @RequestBody CreateRequestStatusCommand command
    ) {
        return ResponseEntity.ok(requestStatusService.create(command));
    }

    @PatchMapping(path = "/requestStatuses/{requestStatusId}")
    public ResponseEntity<RequestStatus> update(
        @PathVariable Long requestStatusId,
        @Valid @RequestBody UpdateRequestStageCommand command
    ) {
        return ResponseEntity.ok(
            requestStatusService.update(requestStatusId, command)
        );
    }

    //readModel rest api
    @GetMapping(path = "/requestStatuses/requestStatusSummary")
    public ResponseEntity<RequestStatusSummaryResponse> requestStatusSummary(
        @Valid @RequestBody RequestStatusSummaryDTO dto
    ) {
        return ResponseEntity.ok(
            requestStatusService.requestStatusSummary(dto)
        );
    }

    @GetMapping(path = "/requestStatuses/requestStatusDetails")
    public ResponseEntity<RequestStatusDetailsResponse> requestStatusDetails(
        @Valid @RequestBody RequestStatusDetailsDTO dto
    ) {
        return ResponseEntity.ok(
            requestStatusService.requestStatusDetails(dto)
        );
    }
}
