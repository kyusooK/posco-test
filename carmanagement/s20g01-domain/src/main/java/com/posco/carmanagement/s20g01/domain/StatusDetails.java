package com.posco.carmanagement.s20g01.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

//<<< DDD / Value Object
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatusDetails {

    private String StageDescription;

    private String ApproverName;

    private Date ApprovalDate;

    private String Remarks;
}
//>>> DDD / Value Object
