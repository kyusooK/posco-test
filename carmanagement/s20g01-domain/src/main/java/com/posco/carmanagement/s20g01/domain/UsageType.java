package com.posco.carmanagement.s20g01.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import org.springframework.beans.BeanUtils;

public enum UsageType {
    BUSINESS_SUPPORT,
    EXTERNAL_ACTIVITY,
}
