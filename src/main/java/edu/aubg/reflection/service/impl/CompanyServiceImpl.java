package edu.aubg.reflection.service.impl;

import edu.aubg.reflection.model.dto.CompanyDTO;
import edu.aubg.reflection.model.entity.CompanyEntity;
import edu.aubg.reflection.repository.CompanyRepository;
import edu.aubg.reflection.service.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

//    @Override
//    public List<CompanyDTO> getAllCompanies() {
//        return companyRepository
//                .findAll()
//                .stream()
//                .map(this::toDTO)
//                .toList();
//    }

//    @Override
//    public CompanyDTO getCompanyByTaxId(String taxId) {
//        return companyRepository
//                .findByTaxId(taxId)
//                .map(this::toDTO)
//                .orElseThrow(() -> new RuntimeException("Company not found"));
//    }

//    @Override
//    public CompanyDTO createCompany(CompanyDTO companyDTO) {
//        CompanyEntity company = new CompanyEntity()
//                .setName(companyDTO.name())
//                .setAddress(companyDTO.address())
//                .setCity(companyDTO.city())
//                .setCountry(companyDTO.country())
//                .setEmail(companyDTO.email())
//                .setPhone(companyDTO.phone())
//                .setTaxId(companyDTO.taxId());
//
//        return toDTO(companyRepository.save(company));
//    }

//    @Override
//    public CompanyDTO updateCompany(CompanyDTO companyDTO) {
//        CompanyEntity company = companyRepository
//                .findByTaxId(companyDTO.taxId())
//                .orElseThrow(() -> new RuntimeException("Company not found"))
//                .setName(companyDTO.name())
//                .setAddress(companyDTO.address())
//                .setCity(companyDTO.city())
//                .setCountry(companyDTO.country())
//                .setEmail(companyDTO.email())
//                .setPhone(companyDTO.phone());
//
//        return toDTO(companyRepository.save(company));
//    }

//    @Override
//    public void deleteCompany(String taxId) {
//        companyRepository.findByTaxId(taxId)
//                .orElseThrow(() -> new RuntimeException("Company not found"));
//    }

//    private CompanyDTO toDTO(CompanyEntity company) {
//        return new CompanyDTO(
//                company.getName(),
//                company.getAddress(),
//                company.getCity(),
//                company.getCountry(),
//                company.getEmail(),
//                company.getPhone(),
//                company.getTaxId()
//        );
//    }
}
