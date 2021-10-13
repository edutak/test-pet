package org.springframework.samples.petclinic.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:spring/business-config.xml"
,"classpath:spring/mvc-core-config.xml"})
@WebAppConfiguration
@ActiveProfiles("jdbc")
public class MyOwnerControllerTest {

    @Resource
    OwnerController ownerController;


    @Test
    public void showOwner() {
        // URI를 바탕으로 컨트롤러가 동작하는지 테스트
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();
        //mockMvc.perform(get("/owners/{ownerId}", 1))
         //               .andExpect()
        ownerController.showOwner(1);
    }
}