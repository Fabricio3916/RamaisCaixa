package caixa.ramaiscaixa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests(auth -> auth
                        // público (consulta)
                        .requestMatchers("/", "/ramais", "/login", "/css/**", "/js/**").permitAll()

                        // ações administrativas
                        .requestMatchers(HttpMethod.POST, "/ramais/salvar").hasRole("ADMIN")
                        .requestMatchers(
                                "/ramais/novo",
                                "/ramais/editar/**",
                                "/ramais/excluir/**"
                        ).hasRole("ADMIN")

                        // tudo que não caiu acima pode ser público
                        .anyRequest().permitAll()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/ramais")
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/ramais")
                )
                .csrf(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {

        UserDetails admin = User.builder()
                .username("cpd")
                .password(passwordEncoder().encode("123"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
