
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
public class CancelDispatchRequestTest {

   private static final Logger LOGGER = LoggerFactory.getLogger(CancelDispatchRequestTest.class);
   
   @Autowired
   private ApplicationContext applicationContext;

   @Autowired
   public DispatchRequestRepository repository;

   @Test
   @SuppressWarnings("unchecked")
   public void test0() {

      //given:  
      DispatchRequest existingEntity = new DispatchRequest();

      existingEntity.setDispatchRequestId(1001L);
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



      DispatchRequest theEntity = new DispatchRequest();

         newEntity.setDispatchRequestId(1001L);
         newEntity.setCancellationReason("일정 변경으로 인한 취소");

      repository.delete(theEntity);
   

         //then:
         DispatchRequest result = repository.findById(existingEntity.getDispatchRequestId()).get();

         LOGGER.info("Response received: {}", result);

         assertEquals(result.getDispatchRequestId(), 1001L);
         assertEquals(result.getCancellationReason(), "일정 변경으로 인한 취소");
         assertEquals(result.getCancelledAt(), "2023-10-21T12:00:00Z");


      } catch (JsonProcessingException e) {
         e.printStackTrace();
         assertTrue(e.getMessage(), false);
      }

     
   }

}
