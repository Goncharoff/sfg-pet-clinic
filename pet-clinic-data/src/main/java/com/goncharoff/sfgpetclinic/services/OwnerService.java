package com.goncharoff.sfgpetclinic.services;

import com.goncharoff.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);
}
