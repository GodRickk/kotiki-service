package ru.itmo.services.interfaces;

import org.springframework.security.core.GrantedAuthority;
import ru.itmo.entity.Owner;

import java.util.Collection;

public interface IUserDetails {

    public Collection<? extends GrantedAuthority> getAuthorities();

    public String getPassword();

    public String getUsername();

    public Owner getOwner();

    public boolean isAccountNonExpired();

    public boolean isAccountNonLocked();

    public boolean isCredentialsNonExpired();

    public boolean isEnabled();
}
