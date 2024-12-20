package com.posco.carmanagement.s20g01.domain.dispatchRequest;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class CancelDispatchRequestCommand {

    private Long dispatchRequestId;
    private String cancellationReason;
}
