package pl.dudi.clientservice.configuration.security;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@RequiredArgsConstructor
public class CustomOAuth2User implements OAuth2User  {

    private final OAuth2User user;
    @Override
    public Map<String, Object> getAttributes() {
        Map<String, Object> customAttributes = new HashMap<>();
        customAttributes.put("login", user.getAttribute("login"));
        customAttributes.put("id", user.getAttribute("id"));
        customAttributes.put("name", user.getAttribute("name"));
        customAttributes.put("email", user.getAttribute("email"));
        return customAttributes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getAuthorities();
    }

    @Override
    public String getName() {
        return user.getAttribute("name");
    }

}
