package com.br.infrastructure.domain;

import com.br.core.enums.Roles;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity(name = "user")
@Table(name = "tb_user")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "userId")
public class User implements UserDetails {

    public User(String login, String password, Roles roles){
        this.login = login;
        this.password = password;
        this.roles = roles;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private Long userId;

    private String login;

    private String password;

    @Enumerated(EnumType.STRING)
    private Roles roles;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.roles == Roles.DOCTOR){
            return List.of(new SimpleGrantedAuthority("ROLE_DOCTOR"), new SimpleGrantedAuthority("ROLE_TECHNICIAN"), new SimpleGrantedAuthority("ROLE_PATIENT"));
        } else if (this.roles == Roles.TECHNICIAN) {
            return List.of(new SimpleGrantedAuthority("ROLE_DOCTOR"), new SimpleGrantedAuthority("ROLE_TECHNICIAN"));
        }
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public String getPassword(){
        return this.password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
