package com.goncharoff.sfgpetclinic.bootstrap;

import com.goncharoff.sfgpetclinic.model.Owner;
import com.goncharoff.sfgpetclinic.model.Pet;
import com.goncharoff.sfgpetclinic.model.PetType;
import com.goncharoff.sfgpetclinic.model.Vet;
import com.goncharoff.sfgpetclinic.services.PetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.goncharoff.sfgpetclinic.services.OwnerService;
import com.goncharoff.sfgpetclinic.services.VetService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dobbo");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Kitty");
        PetType savedCatType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setCity("Tokyo");
        owner1.setAddress("Shibuya street");
        owner1.setTelephone("88005553535");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogType);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("DobboName");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setCity("Tokyo");
        owner2.setAddress("Shibuya street");
        owner2.setTelephone("88005553535");

        Pet fionaCat = new Pet();
        mikesPet.setPetType(savedCatType);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("KittyName");

        ownerService.save(owner2);

        System.out.println("Owners loaded... ");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet2);

        System.out.println("Loaded Vets....");
    }

}
