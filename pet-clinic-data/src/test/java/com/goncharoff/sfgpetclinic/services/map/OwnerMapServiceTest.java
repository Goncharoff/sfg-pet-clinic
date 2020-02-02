package com.goncharoff.sfgpetclinic.services.map;

import com.goncharoff.sfgpetclinic.model.Owner;
import com.goncharoff.sfgpetclinic.services.PetTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;
    final Long id = 1L;
    final String lastName = "Smith";

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(
                new PetMapService(),
                new PetTypeMapService()
        );

        ownerMapService.save(Owner.builder().id(id)
                .lastName(lastName)
                .build());
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerMapService.findAll();
        assertEquals(1, owners.size());
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(id);
        assertEquals(id, owner.getId());
    }

    @Test
    void saveExistingId() {
        Long tmpId = 2L;
        Owner owner2 = Owner.builder().id(tmpId).build();
        Owner savedOwner = ownerMapService.save(owner2);
        assertEquals(tmpId, savedOwner.getId());
    }

    @Test
    void saveNoId() {
        Owner savedOwner = ownerMapService.save(Owner.builder().build());

        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(id));
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(id);
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner smith = ownerMapService.findByLastName(lastName);
        assertNotNull(smith);
        assertEquals(id, smith.getId());
    }

    @Test
    void findByLastNameNotFound() {
        Owner smith = ownerMapService.findByLastName("foo");
        assertNull(smith);
    }
}