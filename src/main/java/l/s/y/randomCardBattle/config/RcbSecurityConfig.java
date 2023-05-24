package l.s.y.randomCardBattle.config;

import l.s.y.randomCardBattle.config.auth.AccDeniedHandler;
import l.s.y.randomCardBattle.config.auth.AuthEntryPoint;
import l.s.y.randomCardBattle.config.auth.JwtAuthConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class RcbSecurityConfig {
    private static final String ADMIN = "admin";
    private static final String USER = "user";
    private final JwtAuthConverter jwtAuthConverter;
    private final AuthEntryPoint authEntryPoint;
    private final AccDeniedHandler accDeniedHandler;
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
                    r.requestMatchers("/api/v1/public/**").permitAll();
                    r.requestMatchers("/api/v1/admin/**").hasRole(ADMIN);
                    r.requestMatchers("/api/v1/user/**").hasAnyRole(ADMIN, USER);
                    r.anyRequest().authenticated();
                });
        httpSecurity.exceptionHandling(e->{
            e.authenticationEntryPoint(authEntryPoint);
            e.accessDeniedHandler(accDeniedHandler);

        });
        httpSecurity.sessionManagement(s -> {
            s.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        });
        httpSecurity.oauth2ResourceServer(o->{
            o.jwt(j->{
                j.jwtAuthenticationConverter(jwtAuthConverter);
            });
            o.authenticationEntryPoint(authEntryPoint);
            o.accessDeniedHandler(accDeniedHandler);
        });
        return httpSecurity.build();
    }
}
