package com.goncharoff.sfgpetclinic.services.map;

import com.goncharoff.sfgpetclinic.model.Speciality;
import com.goncharoff.sfgpetclinic.model.Vet;
import com.goncharoff.sfgpetclinic.services.SpecialityService;
import org.springframework.stereotype.Service;
import com.goncharoff.sfgpetclinic.services.VetService;

import java.util.Set;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    public VetMapService(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    private final SpecialityService specialityService;

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet vet) {

        if (vet.getSpecialities().size() > 0) {
            vet.getSpecialities().forEach(speciality -> {
                if (speciality.getId() == null) {
                    Speciality savedSpeciality = specialityService.save(speciality);
                    speciality.setId(savedSpeciality.getId());
                }
            });
        }

        return super.save(vet);
    }

    @Override
    public void delete(Vet vet) {
        super.delete(vet);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
