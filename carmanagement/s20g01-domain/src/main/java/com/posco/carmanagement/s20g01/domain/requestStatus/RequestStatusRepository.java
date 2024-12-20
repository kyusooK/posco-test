package com.posco.carmanagement.s20g01.domain.requestStatus;

import com.posco.carmanagement.s20g01.domain.requestStatus.*;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "requestStatuses",
    path = "requestStatuses"
)
public interface RequestStatusRepository
    extends JpaRepository<RequestStatus, Long> {
    //List<RequestStatus> requestStatusSummary
    //RequestStatus requestStatusDetails
}
