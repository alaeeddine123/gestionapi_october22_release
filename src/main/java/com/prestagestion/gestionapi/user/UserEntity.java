package com.prestagestion.gestionapi.user;

import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class UserEntity  implements UserDetails {


    @Id
    @SequenceGenerator(name = "employee_sequence",
    sequenceName = "employee_sequence",
    allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "employee_sequence")
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole userRole;
    private Boolean locked = false;
    private Boolean enabled = false;

    public UserEntity(String firstName, String lastName, String email, String password, UserRole userRole, Boolean locked, Boolean enabled) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.userRole = userRole;
        this.locked = locked;
        this.enabled = enabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        final SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority( userRole.name());
        return Collections.singletonList(simpleGrantedAuthority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return  !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserEntity userEntity = (UserEntity)  o;
        return id != null && Objects.equals(id, userEntity.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }


}

