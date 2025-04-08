//package com.example.spring_boot_mini_project.config.ldap;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.ldap.authentication.BindAuthenticator;
//import org.springframework.security.ldap.authentication.LdapAuthenticationProvider;
//import org.springframework.security.ldap.core.LdapContextSource;
//import org.springframework.security.ldap.userdetails.LdapAuthoritiesPopulator;
//import org.springframework.security.ldap.userdetails.DefaultLdapAuthoritiesPopulator;
//import org.springframework.security.web.SecurityFilterChain;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
////@Configuration
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeHttpRequests(auth -> auth
//                        .anyRequest().authenticated()
//                )
//                .formLogin()
//                .and()
//                .httpBasic();
//
//        return http.build();
//    }
//
//    @Bean
//    public LdapAuthenticationProvider ldapAuthenticationProvider() {
//        return new LdapAuthenticationProvider(bindAuthenticator(), ldapAuthoritiesPopulator());
//    }
//
//    @Bean
//    public BindAuthenticator bindAuthenticator() {
//        BindAuthenticator bindAuthenticator = new BindAuthenticator();
//        bindAuthenticator.setUserDnPatterns(new String[]{"uid={0},ou=users"});
//        bindAuthenticator.setLdapContextSource(ldapContextSource());
//        return bindAuthenticator;
//    }
//
//    @Bean
//    public LdapAuthoritiesPopulator ldapAuthoritiesPopulator() {
//        return new DefaultLdapAuthoritiesPopulator(ldapContextSource(), "ou=groups");
//    }
//
//    @Bean
//    public org.springframework.ldap.core.LdapContextSource ldapContextSource() {
//        org.springframework.ldap.core.LdapContextSource contextSource = new org.springframework.ldap.core.LdapContextSource();
//        contextSource.setUrl("ldap://localhost:389");
//        contextSource.setBase("dc=example,dc=com");
//        contextSource.setUserDn("cn=admin,dc=example,dc=com");
//        contextSource.setPassword("admin");
//        return contextSource;
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}