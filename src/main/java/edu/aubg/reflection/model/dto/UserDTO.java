package edu.aubg.reflection.model.dto;

import java.util.Set;

public class UserDTO {

    private String username;
    private String email;
    private Set<CompanyDTO> companies;

    public UserDTO() {
        super();
    }

    public String getUsername() {
        return username;
    }

    public UserDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public Set<CompanyDTO> getCompanies() {
        return companies;
    }

    public UserDTO setCompanies(Set<CompanyDTO> companies) {
        this.companies = companies;
        return this;
    }
}
