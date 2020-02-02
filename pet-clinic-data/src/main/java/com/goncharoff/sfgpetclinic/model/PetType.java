package com.goncharoff.sfgpetclinic.model;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "types")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PetType extends BaseEntity {

    @Column(name = "name")
    private String name;

}
