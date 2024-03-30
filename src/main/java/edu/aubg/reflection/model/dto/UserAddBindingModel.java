package edu.aubg.reflection.model.dto;

public class UserAddBindingModel {

    private String username;
    private String email;
    private String password;
    private String confirmPassword;

    public UserAddBindingModel() {
        super();
    }

    public String getUsername() {
        return username;
    }

    public UserAddBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserAddBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserAddBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserAddBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
