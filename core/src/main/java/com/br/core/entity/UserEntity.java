package com.br.core.entity;

import com.br.core.enums.Roles;

import java.util.Objects;

public class UserEntity {

    public UserEntity(Long userId, String login, String password, Roles roles) {
        this.userId = userId;
        this.login = login;
        this.password = password;
        this.roles = roles;
    }

    private Long userId;
    private String login;
    private String password;
    private Roles roles;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(userId);
    }

    public static class UserEntityBuilder{
        private Long userId;
        private String login;
        private String password;
        private Roles roles;

        public UserEntityBuilder builder(){
            return new UserEntityBuilder();
        }

        public UserEntityBuilder userId(Long userId) {
            this.userId = userId;
            return this;
        }

        public UserEntityBuilder roles(Roles roles) {
            this.roles = roles;
            return this;
        }

        public UserEntityBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UserEntityBuilder login(String login) {
            this.login = login;
            return this;
        }

        public UserEntity build(){
            return new UserEntity(this.userId, this.login, this.password, this.roles);
        }
    }
}
