package org.sid.micropi.web;

import lombok.*;

@Data
@AllArgsConstructor @NoArgsConstructor
public class RegistrationForm {
    private String name;
    private String categorie;
    private String username;
    private String password;
    private String repassword;
}
