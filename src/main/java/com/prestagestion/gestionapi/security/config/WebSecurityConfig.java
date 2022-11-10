package com.prestagestion.gestionapi.security.config;


import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig  {

  /*
    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return null;
            }
        };
    }*/


    @Bean
    public InMemoryUserDetailsManager user(){

        UserDetails user = User.withDefaultPasswordEncoder().username("user").password("password")
                .roles("USER").build();

        UserDetails admin = User.withDefaultPasswordEncoder().username("admin").password("password")
                .roles("ADMIN").build();


        return new InMemoryUserDetailsManager(user,admin);
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http.csrf(csrf -> csrf.disable() )
                .authorizeRequests(auth ->
                {
                    auth.antMatchers("/").permitAll();
                    auth.antMatchers("user").hasRole("USER");
                    auth.antMatchers("/admin").hasRole("ADMIN");

                }).httpBasic(Customizer.withDefaults()).build();


                /*.csrf(csrf -> csrf.disable())
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/user").hasRole("USER")
                .antMatchers("/admin").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and().rememberMe().key("AbcdEfghIjklmNopQrsTuvXyz_0123456789")
                .and()
                .httpBasic(Customizer.withDefaults()).build();*/

    }

    /*

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
    return (web) -> web.ignoring().antMatchers("/images/**", "/js/**", "/webjars/**");

    }*/
}
