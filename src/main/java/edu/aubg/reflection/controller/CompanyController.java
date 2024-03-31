package edu.aubg.reflection.controller;

import edu.aubg.reflection.model.dto.CompanyDTO;
import edu.aubg.reflection.service.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

//    @GetMapping("/all")
//    public ResponseEntity<List<CompanyDTO>> getAllCompanies() {
//        return ResponseEntity.ok(companyService.getAllCompanies());
//    }

//    @GetMapping("/{taxId}")
//    public ResponseEntity<CompanyDTO> getCompanyByTaxId(@PathVariable String taxId) {
//        return ResponseEntity.ok(companyService.getCompanyByTaxId(taxId));
//    }

//    @PostMapping("/create")
//    public ResponseEntity<CompanyDTO> createCompany(@RequestBody CompanyDTO companyDTO) {
//        return ResponseEntity.ok(companyService.createCompany(companyDTO));
//    }

//    @PatchMapping("/update")
//    public ResponseEntity<CompanyDTO> updateCompany(@RequestBody CompanyDTO companyDTO) {
//        return ResponseEntity.ok(companyService.updateCompany(companyDTO));
//    }
}
