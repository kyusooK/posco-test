
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
public class UpdateRequestStageTest {

   private static final Logger LOGGER = LoggerFactory.getLogger(UpdateRequestStageTest.class);
   
   @Autowired
   private ApplicationContext applicationContext;

   @Autowired
   public RequestStatusRepository repository;

   @Test
   @SuppressWarnings("unchecked")
   public void test0() {

      //given:  
      RequestStatus existingEntity = new RequestStatus();

      existingEntity.setRequestStatusId(56789L);
      existingEntity.setDispatchRequestReference([object Object]);
      existingEntity.setStatusDetails([object Object]);
      existingEntity.setCurrentStage("RECEIVED");
      existingEntity.setLastUpdated("2023-10-15");

      repository.save(existingEntity);

      //when:  

  
      
      try {



   
      UpdateRequestStage command = new UpdateRequestStageCommand();

         command.setRequestStatusId(56789L);
         command.setCurrentStage("APPROVED");
         command.setStatusDetails([object Object]);

      existingEntity.UpdateRequestStage(command);


         //then:
         RequestStatus result = repository.findById(existingEntity.getRequestStatusId()).get();

         LOGGER.info("Response received: {}", result);

         assertEquals(result.getRequestStatusId(), 56789L);
         assertEquals(result.getCurrentStage(), "APPROVED");
         assertEquals(result.getStatusDetails(), [object Object]);
         assertEquals(result.getLastUpdated(), "2023-10-16");


      } catch (JsonProcessingException e) {
         e.printStackTrace();
         assertTrue(e.getMessage(), false);
      }

     
   }

}
