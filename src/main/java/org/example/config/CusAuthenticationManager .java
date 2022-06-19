package org.example.config;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * 自定义认证管理器
 */
@Component
class CusAuthenticationManager implements AuthenticationManager {
 private final AdminAuthenticationProvider adminAuthenticationProvider;

 public CusAuthenticationManager(AdminAuthenticationProvider authenticationProvider) {
  this.adminAuthenticationProvider = authenticationProvider;
 }

 @Override
 public Authentication authenticate(Authentication authentication) throws AuthenticationException {
  Authentication result = adminAuthenticationProvider.authenticate(authentication);
  if (Objects.nonNull(result)) {
   return result;
  }
  throw new ProviderNotFoundException("Authentication failed!");
 }
}
