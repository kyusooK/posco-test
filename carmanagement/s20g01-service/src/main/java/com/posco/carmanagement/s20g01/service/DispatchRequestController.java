package com.posco.carmanagement.s20g01.service;

import com.posco.carmanagement.s20g01.domain.dispatchRequest.CancelDispatchRequestCommand;
import com.posco.carmanagement.s20g01.domain.dispatchRequest.CreateDispatchRequestCommand;
import com.posco.carmanagement.s20g01.domain.dispatchRequest.DispatchRequest;
import com.posco.carmanagement.s20g01.domain.dispatchRequest.DispatchRequestService;
import com.posco.carmanagement.s20g01.domain.dispatchRequest.UpdateDispatchRequestCommand;
import com.posco.carmanagement.s20g01.domain.dispatchRequest.mybatis.DispatchRequestDetailsDTO;
import com.posco.carmanagement.s20g01.domain.dispatchRequest.mybatis.DispatchRequestDetailsResponse;
import com.posco.carmanagement.s20g01.domain.dispatchRequest.mybatis.DispatchRequestSummaryDTO;
import com.posco.carmanagement.s20g01.domain.dispatchRequest.mybatis.DispatchRequestSummaryResponse;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RepositoryRestController
public class DispatchRequestController {

    private final DispatchRequestService dispatchRequestService;

    @Autowired
    public DispatchRequestController(
        DispatchRequestService dispatchRequestService
    ) {
        this.dispatchRequestService = dispatchRequestService;
    }

    @GetMapping(path = "/dispatchRequests")
    public ResponseEntity<List<DispatchRequest>> findAll() {
        return ResponseEntity.ok(dispatchRequestService.findAll());
    }

    @PostMapping(path = "/dispatchRequests")
    public ResponseEntity<DispatchRequest> create(
        @Valid @RequestBody CreateDispatchRequestCommand command
    ) {
        return ResponseEntity.ok(dispatchRequestService.create(command));
    }

    @PatchMapping(path = "/dispatchRequests/{dispatchRequestId}")
    public ResponseEntity<DispatchRequest> update(
        @PathVariable Long dispatchRequestId,
        @Valid @RequestBody UpdateDispatchRequestCommand command
    ) {
        return ResponseEntity.ok(
            dispatchRequestService.update(dispatchRequestId, command)
        );
    }

    @DeleteMapping(path = "/dispatchRequests/{dispatchRequestId}")
    public ResponseEntity<Void> delete(@PathVariable Long dispatchRequestId) {
        dispatchRequestService.delete(dispatchRequestId);
        return ResponseEntity.noContent().build();
    }

    //readModel rest api
    @GetMapping(path = "/dispatchRequests/dispatchRequestSummary")
    public ResponseEntity<DispatchRequestSummaryResponse> dispatchRequestSummary(
        @Valid @RequestBody DispatchRequestSummaryDTO dto
    ) {
        return ResponseEntity.ok(
            dispatchRequestService.dispatchRequestSummary(dto)
        );
    }

    @GetMapping(path = "/dispatchRequests/dispatchRequestDetails")
    public ResponseEntity<DispatchRequestDetailsResponse> dispatchRequestDetails(
        @Valid @RequestBody DispatchRequestDetailsDTO dto
    ) {
        return ResponseEntity.ok(
            dispatchRequestService.dispatchRequestDetails(dto)
        );
    }
}
