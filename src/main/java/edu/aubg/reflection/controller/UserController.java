package edu.aubg.reflection.controller;

import edu.aubg.reflection.model.dto.CompanyDTO;
import edu.aubg.reflection.model.dto.UserRegisterBindingModel;
import edu.aubg.reflection.model.dto.UserDTO;
import edu.aubg.reflection.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserDTO> getUserByUsername(@PathVariable String username) {
        return ResponseEntity.ok(userService.getUserByUsername(username));
    }

    @GetMapping("/{username}/companies")
    public ResponseEntity<Set<CompanyDTO>> getUserCompanies(@PathVariable String username) {
        return ResponseEntity.ok(userService.getUserCompanies(username));
    }

    @PostMapping("/register")
    public ModelAndView registerUser(@RequestBody UserRegisterBindingModel userRegisterBindingModel) {
        userService.registerUser(userRegisterBindingModel);
        return new ModelAndView("redirect:/login");
    }

    @PatchMapping("/update")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.updateUser(userDTO));
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<Void> deleteUser(@PathVariable String username) {
        userService.deleteUser(username);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/company/create")
    public ModelAndView createCompany(CompanyDTO companyDTO) {
        return new ModelAndView("redirect:/companies/create");
    }

//    @PostMapping("/company/create")
//    public ModelAndView addCompanyToUser(@PathVariable CompanyDTO companyDTO) {
//        userService.addCompanyToUser(username, taxId);
//        return ModelAndView("redirect:/users/{username}/companies");
//    }

    @PatchMapping("/{username}/remove-company/{taxId}")
    public ResponseEntity<Void> removeCompanyFromUser(@PathVariable String username, @PathVariable String taxId) {
        userService.removeCompanyFromUser(username, taxId);
        return ResponseEntity.noContent().build();
    }
}
