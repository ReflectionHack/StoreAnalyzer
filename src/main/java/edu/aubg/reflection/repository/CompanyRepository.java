package edu.aubg.reflection.repository;

import edu.aubg.reflection.model.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity, UUID> {

    Optional<CompanyEntity> findByName(String name);

    Optional<CompanyEntity> findByTaxId(String taxId);
}
