package com.gestion_de_note.gestion_de_note.secryte;

import com.gestion_de_note.models.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;

    // 🔹 1. المعلومات اللي غايكونوا فـ البادج د اليوزر
    private Long id;
    private String username;
    private String email;

    @JsonIgnore // ما يتصيفطش فـ JSON للسلامة
    private String password;

    // 🔹 2. الصلاحيات والـ Roles المترجمين لـ Spring Security
    private Collection<? extends GrantedAuthority> authorities;

    // 🔹 3. الـ Constructeur باش نكرييو البادج
    public UserDetailsImpl(Long id, String username, String email, String password,
                           Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    // 🔹 4. الميثود السحرية: كتاخد User من MySQL وتخرج لينا UserDetailsImpl واجد
    public static UserDetailsImpl build(User user) {
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toList());

        return new UserDetailsImpl(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                authorities);
    }

    // 🔹 5. الميثودات الإجبارية ديال Interface UserDetails (Getters & Status)
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    // 🔹 الشروط د الحساب (واش خدام، ما مسدودش، ما تسالاتش الصلاحية)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDetailsImpl user = (UserDetailsImpl) o;
        return Objects.equals(id, user.id);
    }
}