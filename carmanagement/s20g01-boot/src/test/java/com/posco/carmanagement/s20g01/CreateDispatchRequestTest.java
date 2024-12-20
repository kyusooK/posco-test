
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

import com.posco.carmanagement.s20g01.domain.dispatchRequest.DispatchRequest;
import com.posco.carmanagement.s20g01.domain.dispatchRequest.DispatchRequestRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CreateDispatchRequestTest {

   private static final Logger LOGGER = LoggerFactory.getLogger(CreateDispatchRequestTest.class);
   
   @Autowired
   private ApplicationContext applicationContext;

   @Autowired
   public DispatchRequestRepository repository;

   @Test
   @SuppressWarnings("unchecked")
   public void test0() {

      //given:  
      DispatchRequest existingEntity = new DispatchRequest();

      existingEntity.setDispatchRequestId(null);
      existingEntity.setRequesterInfo([object Object]);
      existingEntity.setApprovalInfo([object Object]);
      existingEntity.setRequestPeriod([object Object]);
      existingEntity.setPurpose("업무 지원");
      existingEntity.setUsageType("BUSINESS_SUPPORT");
      existingEntity.setDepartment("SEOUL");
      existingEntity.setNumberOfPassengers(4L);
      existingEntity.setVehicleType("SEDAN");
      existingEntity.setDriverIncluded("YES");
      existingEntity.setContactNumber("010-9876-5432");
      existingEntity.setAttachment("document.pdf");
      existingEntity.setRemarks("N/A");

      repository.save(existingEntity);

      //when:  

  
      
      try {

      DispatchRequest newEntity = new DispatchRequest();

         newEntity.setRequesterInfo([object Object]);
         newEntity.setApprovalInfo([object Object]);
         newEntity.setRequestPeriod([object Object]);
         newEntity.setPurpose("업무 지원");
         newEntity.setUsageType("BUSINESS_SUPPORT");
         newEntity.setDepartment("SEOUL");
         newEntity.setNumberOfPassengers(4L);
         newEntity.setVehicleType("SEDAN");
         newEntity.setDriverIncluded("YES");
         newEntity.setContactNumber("010-9876-5432");
         newEntity.setAttachment("document.pdf");
         newEntity.setRemarks("N/A");

      repository.save(newEntity);


   

         //then:
         DispatchRequest result = repository.findById(existingEntity.getDispatchRequestId()).get();

         LOGGER.info("Response received: {}", result);

         assertEquals(result.getDispatchRequestId(), 1001L);
         assertEquals(result.getRequesterInfo(), [object Object]);
         assertEquals(result.getApprovalInfo(), [object Object]);
         assertEquals(result.getRequestPeriod(), [object Object]);
         assertEquals(result.getPurpose(), "업무 지원");
         assertEquals(result.getUsageType(), "BUSINESS_SUPPORT");
         assertEquals(result.getDepartment(), "SEOUL");
         assertEquals(result.getNumberOfPassengers(), 4L);
         assertEquals(result.getVehicleType(), "SEDAN");
         assertEquals(result.getDriverIncluded(), "YES");
         assertEquals(result.getContactNumber(), "010-9876-5432");
         assertEquals(result.getAttachment(), "document.pdf");
         assertEquals(result.getRemarks(), "N/A");


      } catch (JsonProcessingException e) {
         e.printStackTrace();
         assertTrue(e.getMessage(), false);
      }

     
   }

}
