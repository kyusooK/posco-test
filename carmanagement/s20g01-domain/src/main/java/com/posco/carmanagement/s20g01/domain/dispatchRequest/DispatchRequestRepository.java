package com.posco.carmanagement.s20g01.domain.dispatchRequest;

import com.posco.carmanagement.s20g01.domain.dispatchRequest.*;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "dispatchRequests",
    path = "dispatchRequests"
)
public interface DispatchRequestRepository
    extends JpaRepository<DispatchRequest, Long> {
    //List<DispatchRequest> dispatchRequestSummary
    //DispatchRequest dispatchRequestDetails
}
