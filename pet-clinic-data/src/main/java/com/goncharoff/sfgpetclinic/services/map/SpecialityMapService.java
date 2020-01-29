package com.goncharoff.sfgpetclinic.services.map;

import com.goncharoff.sfgpetclinic.model.Speciality;
import com.goncharoff.sfgpetclinic.services.SpecialitesService;

import java.util.Set;

public class SpecialityMapService extends AbstractMapService<Speciality, Long> implements SpecialitesService {

    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Speciality save(Speciality speciality) {
        return super.save(speciality);
    }

    @Override
    public void delete(Speciality speciality) {
        super.delete(speciality);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
