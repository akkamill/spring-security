//package com.example.spring_boot_mini_project.config.ldap;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.ProviderManager;
//
//
//import javax.naming.ldap.LdapContext;
//import java.util.Collections;
//import java.util.List;
//
//@Configuration
//public class LDAPAuthProviderConfig {
//
//    @Bean
//    public AuthenticationManager authenticationManager(LdapAuthenticationProvider ldapAuthenticationProvider) {
//        return new ProviderManager(List.of(ldapAuthenticationProvider));
//    }
//
//    @Bean
//    public LdapAuthenticationProvider ldapAuthenticationProvider() {
//        return new LdapAuthenticationProvider(bindAuthenticator(), ldapAuthoritiesPopulator());
//    }
//
//    @Bean
//    public BindAuthenticator bindAuthenticator() {
//        BindAuthenticator bindAuthenticator = new BindAuthenticator(ldapContext());
//        bindAuthenticator.setUserSearch(new FilterBasedLdapUserSearch("ou=users", "(uid={0})", ldapContext()));
//        return bindAuthenticator;
//    }
//
//    @Bean
//    public LdapAuthoritiesPopulator ldapAuthoritiesPopulator() {
//        return (userData, username) -> Collections.emptyList(); // No roles assigned
//    }
//
//    @Bean
//    public LdapContext ldapContext() {
//        return null; // Replace with actual LDAP context configuration
//    }
//}
