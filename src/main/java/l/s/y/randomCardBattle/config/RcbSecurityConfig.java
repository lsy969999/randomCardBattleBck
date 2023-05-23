package l.s.y.randomCardBattle.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class RcbSecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .csrf(c ->{
                    c.disable();
                })
                .cors(c -> {
                    c.disable();
                })
                .authorizeHttpRequests(r -> {
                    r.anyRequest().permitAll();
                });
        return httpSecurity.build();
    }
}
