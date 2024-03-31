package edu.aubg.reflection.model.dto;

public record CompanyDTO(
        String name,
        String address,
        String owner,
        String taxId
) {
    public CompanyDTO() {
        this("", "", "", "");
    }
}
