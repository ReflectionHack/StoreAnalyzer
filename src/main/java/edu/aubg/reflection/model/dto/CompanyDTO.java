package edu.aubg.reflection.model.dto;

public record CompanyDTO(
        String name,
        String address,
        String city,
        String country,
        String email,
        String phone,
        String taxId
) {
    public CompanyDTO() {
        this("", "", "", "", "", "", "");
    }
}
