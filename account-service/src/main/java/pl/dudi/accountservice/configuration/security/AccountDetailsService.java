package pl.dudi.accountservice.configuration.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dudi.accountservice.infrastructure.database.entity.AccountEntity;
import pl.dudi.accountservice.infrastructure.database.repository.jpa.AccountJpaRepository;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class AccountDetailsService implements UserDetailsService {

    private final AccountJpaRepository accountJpaRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AccountEntity account = accountJpaRepository.findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException(
                String.format("Account with email: [%s] not found", email)
            ));
        Collection<? extends GrantedAuthority> authority = account.getAuthorities();
        return new User(
            account.getUsername(),
            account.getPassword(),
            account.isEnabled(),
            account.isAccountNonExpired(),
            account.isCredentialsNonExpired(),
            account.isAccountNonLocked(),
            authority);
    }


}
