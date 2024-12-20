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
public class RequesterInfo {

    private String Name;

    private String Organization;

    private String EmployeeNumber;

    private String PhoneNumber;

    private String MobileNumber;

    private Date RequestDate;
}
//>>> DDD / Value Object
