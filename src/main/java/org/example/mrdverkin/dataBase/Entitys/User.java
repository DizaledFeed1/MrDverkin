package org.example.mrdverkin.dataBase.Entitys;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Data
@Table(name = "\"User\"")
@NoArgsConstructor(access= AccessLevel.PROTECTED, force=true)
@RequiredArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private final String username;
    private final String password;
    private final String nickname;
    private final String email;
    private final String phone;

    @ElementCollection(fetch = FetchType.EAGER) // Связь с таблицей ролей
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    private final Set<String> roles; // Может содержать "ROLE_SELLER", "ROLE_MainInstaller", "ROLE_ADMIN"


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role)) // Преобразуем роли в GrantedAuthority
                .collect(Collectors.toList());
    }
}
