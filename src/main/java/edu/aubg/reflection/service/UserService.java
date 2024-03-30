package edu.aubg.reflection.service;

import edu.aubg.reflection.model.dto.CompanyDTO;
import edu.aubg.reflection.model.dto.UserRegisterBindingModel;
import edu.aubg.reflection.model.dto.UserDTO;

import java.util.List;
import java.util.Set;

public interface UserService {

    List<UserDTO> getAllUsers();

    UserDTO getUserByUsername(String username);

    Set<CompanyDTO> getUserCompanies(String username);

    UserDTO registerUser(UserRegisterBindingModel userRegisterBindingModel);

    UserDTO updateUser(UserDTO userDTO);

    void deleteUser(String username);

    void addCompanyToUser(String username, String taxId);

    void removeCompanyFromUser(String username, String taxId);
}
