package edu.aubg.reflection.service.impl;

import edu.aubg.reflection.model.dto.CompanyDTO;
import edu.aubg.reflection.model.dto.UserAddBindingModel;
import edu.aubg.reflection.model.dto.UserDTO;
import edu.aubg.reflection.model.entity.CompanyEntity;
import edu.aubg.reflection.model.entity.UserEntity;
import edu.aubg.reflection.repository.CompanyRepository;
import edu.aubg.reflection.repository.UserRepository;
import edu.aubg.reflection.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, CompanyRepository companyRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository
                .findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    @Override
    public UserDTO getUserByUsername(String username) {
        return null;
    }

    @Override
    public Set<CompanyDTO> getUserCompanies(String username) {
        return null;
    }

    @Override
    public UserDTO registerUser(UserAddBindingModel userAddBindingModel) {
        return toDTO(
                userRepository
                        .save(
                                new UserEntity()
                                        .setUsername(userAddBindingModel.getUsername())
                                        .setEmail(userAddBindingModel.getEmail())
                                        .setPassword(passwordEncoder.encode(userAddBindingModel.getPassword()))
                                        .setCompanies(Set.of())
                        )
        );
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        return toDTO(userRepository.save(
                userRepository
                        .findByUsername(userDTO.getUsername())
                        .orElseThrow(() -> new RuntimeException("User not found"))
                        .setEmail(userDTO.getEmail())
        ));
    }

    @Override
    public void deleteUser(String username) {
        userRepository.deleteByUsername(username);
    }

    @Override
    public void addCompanyToUser(String username, String taxId) {
        companyRepository.findByTaxId(taxId)
                .ifPresent(company -> userRepository
                        .findByUsername(username)
                        .ifPresent(user -> {
                            user.getCompanies().add(company);
                            userRepository.save(user);
                        }));
    }

    @Override
    public void removeCompanyFromUser(String username, String taxId) {
        companyRepository.findByTaxId(taxId)
                .ifPresent(company -> userRepository
                        .findByUsername(username)
                        .ifPresent(user -> {
                            user.getCompanies().remove(company);
                            userRepository.save(user);
                        }));
    }

    private UserDTO toDTO(UserEntity user) {
        return new UserDTO()
                .setUsername(user.getUsername())
                .setEmail(user.getEmail())
                .setCompanies(
                        user
                        .getCompanies()
                        .stream()
                                .map(this::toDTO)
                                .collect(Collectors.toSet()));
    }

    private CompanyDTO toDTO(CompanyEntity company) {
        return new CompanyDTO(
                company.getName(),
                company.getAddress(),
                company.getCity(),
                company.getCountry(),
                company.getEmail(),
                company.getPhone(),
                company.getTaxId()
        );
    }
}
