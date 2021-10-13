package org.springframework.samples.petclinic.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.repository.OwnerRepository;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:spring/business-config.xml"
, "classpath:spring/service-test-config.xml"})
@ActiveProfiles("jdbc")
public class MyClinicServiceImplTest {

    @Resource
    ClinicService clinicService;

    @Resource(name = "mockOwnerRepository")
    OwnerRepository ownerRepository;

    @Test
    public void findOwnerById() {

        Owner expectedOwner = new Owner();
        expectedOwner.setFirstName("john");
        expectedOwner.setLastName("kang");
        when(ownerRepository.findById(11)).thenReturn(expectedOwner);


        Owner owner = clinicService.findOwnerById(11);
        assertEquals(expectedOwner.getFirstName(), owner.getFirstName());
        assertEquals(expectedOwner.getLastName(), owner.getLastName());

        // 정확하게 검증
        verify(ownerRepository, times(1)).findById(11);
    }
}