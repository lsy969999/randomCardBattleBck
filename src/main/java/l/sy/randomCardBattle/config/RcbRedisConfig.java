package l.sy.randomCardBattle.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

@Configuration
@Getter
@Setter
@ConfigurationProperties(prefix = "spring.redis")
public class RcbRedisConfig {
    private String host;
    private int port;
    private String password;

    @Bean
    public RedisConnectionFactory redisConnectionFactory(){
        RedisStandaloneConfiguration rsc = new RedisStandaloneConfiguration();
        rsc.setHostName(host);
        rsc.setPort(port);
        rsc.setPassword(password);
        return new LettuceConnectionFactory(rsc);
    }
}
