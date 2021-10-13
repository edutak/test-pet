package org.springframework.samples.petclinic.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:spring/business-config.xml"})
public class MyClinicServiceImplTest {

    @Resource
    ClinicService clinicService;

    @Test
    public void findOwnerById() {

        Owner owner = clinicService.findOwnerById(1);
        assertEquals("George", owner.getFirstName());
        assertEquals("Franklin", owner.getLastName());
    }
}