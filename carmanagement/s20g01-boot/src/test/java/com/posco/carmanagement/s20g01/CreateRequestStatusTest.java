
package com.posco.carmanagement.s20g01;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.posco.carmanagement.s20g01.domain.requestStatus.RequestStatus;
import com.posco.carmanagement.s20g01.domain.requestStatus.RequestStatusRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CreateRequestStatusTest {

   private static final Logger LOGGER = LoggerFactory.getLogger(CreateRequestStatusTest.class);
   
   @Autowired
   private ApplicationContext applicationContext;

   @Autowired
   public RequestStatusRepository repository;

   @Test
   @SuppressWarnings("unchecked")
   public void test0() {

      //given:  
      RequestStatus existingEntity = new RequestStatus();

      existingEntity.setDispatchRequestId(12345L);
      existingEntity.setRequesterInfo([object Object]);
      existingEntity.setApprovalInfo([object Object]);
      existingEntity.setRequestPeriod([object Object]);
      existingEntity.setPurpose("업무 출장");
      existingEntity.setUsageType("BUSINESS_SUPPORT");
      existingEntity.setDepartment("SEOUL");
      existingEntity.setNumberOfPassengers(3L);
      existingEntity.setVehicleType("SEDAN");
      existingEntity.setDriverIncluded("YES");
      existingEntity.setContactNumber("010-9876-5432");
      existingEntity.setAttachment("file.pdf");
      existingEntity.setRemarks("N/A");

      repository.save(existingEntity);

      //when:  

  
      
      try {

      RequestStatus newEntity = new RequestStatus();

         newEntity.setDispatchRequestReference([object Object]);
         newEntity.setStatusDetails([object Object]);
         newEntity.setCurrentStage("RECEIVED");
         newEntity.setLastUpdated("2023-10-15");

      repository.save(newEntity);


   

         //then:
         RequestStatus result = repository.findById(existingEntity.getRequestStatusId()).get();

         LOGGER.info("Response received: {}", result);

         assertEquals(result.getRequestStatusId(), 56789L);
         assertEquals(result.getDispatchRequestReference(), [object Object]);
         assertEquals(result.getStatusDetails(), [object Object]);
         assertEquals(result.getCurrentStage(), "RECEIVED");
         assertEquals(result.getLastUpdated(), "2023-10-15");


      } catch (JsonProcessingException e) {
         e.printStackTrace();
         assertTrue(e.getMessage(), false);
      }

     
   }

}
