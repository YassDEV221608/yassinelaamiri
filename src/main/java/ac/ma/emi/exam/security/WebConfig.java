package ac.ma.emi.exam.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebConfig {
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails user1 = User.withUsername("yassine")
                .password(passwordEncoder.encode("gtahyjump"))
                .roles("ADMIN","USER")
                .build();
        UserDetails user2 = User.withUsername("lammiri")
                .password(passwordEncoder.encode("gtahyjump"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user1,user2);
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain config(HttpSecurity http) throws Exception{
        return http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("api/v1/**").permitAll();
                    auth.requestMatchers("/user/**").hasAnyRole("ADMIN","USER");
                    auth.requestMatchers("/admin/**").hasRole("ADMIN");
                }).formLogin(Customizer.withDefaults()).build();
    }
}
