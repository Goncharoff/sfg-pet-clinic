package services;

import com.gocnharoff.model.Owner;
import com.gocnharoff.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(Long id);

    Pet save(Pet owner);

    Set<Pet> findAll();
}
