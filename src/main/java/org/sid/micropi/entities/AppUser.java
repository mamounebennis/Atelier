package org.sid.micropi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String categorie;
    private String username;
    private String password;

    @ManyToMany(fetch= FetchType.EAGER)
    private Collection<AppRole> roles=new ArrayList<>();
}
