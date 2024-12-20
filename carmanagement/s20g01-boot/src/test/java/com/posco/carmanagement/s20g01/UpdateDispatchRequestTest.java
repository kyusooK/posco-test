
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
public class UpdateDispatchRequestTest {

   private static final Logger LOGGER = LoggerFactory.getLogger(UpdateDispatchRequestTest.class);
   
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



   
      UpdateDispatchRequest command = new UpdateDispatchRequestCommand();

         command.setDispatchRequestId(1001L);
         command.setRequesterInfo([object Object]);
         command.setApprovalInfo([object Object]);
         command.setRequestPeriod([object Object]);
         command.setPurpose("대외 활동");
         command.setUsageType("EXTERNAL_ACTIVITY");
         command.setDepartment("POHANG");
         command.setNumberOfPassengers(3L);
         command.setVehicleType("VAN");
         command.setDriverIncluded("NO");
         command.setContactNumber("010-5678-1234");
         command.setAttachment("updated_document.pdf");
         command.setRemarks("변경된 요청");

      existingEntity.UpdateDispatchRequest(command);


         //then:
         DispatchRequest result = repository.findById(existingEntity.getDispatchRequestId()).get();

         LOGGER.info("Response received: {}", result);

         assertEquals(result.getDispatchRequestId(), 1001L);
         assertEquals(result.getRequesterInfo(), [object Object]);
         assertEquals(result.getApprovalInfo(), [object Object]);
         assertEquals(result.getRequestPeriod(), [object Object]);
         assertEquals(result.getPurpose(), "대외 활동");
         assertEquals(result.getUsageType(), "EXTERNAL_ACTIVITY");
         assertEquals(result.getDepartment(), "POHANG");
         assertEquals(result.getNumberOfPassengers(), 3L);
         assertEquals(result.getVehicleType(), "VAN");
         assertEquals(result.getDriverIncluded(), "NO");
         assertEquals(result.getContactNumber(), "010-5678-1234");
         assertEquals(result.getAttachment(), "updated_document.pdf");
         assertEquals(result.getRemarks(), "변경된 요청");


      } catch (JsonProcessingException e) {
         e.printStackTrace();
         assertTrue(e.getMessage(), false);
      }

     
   }

}
