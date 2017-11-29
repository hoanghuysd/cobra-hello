package org.cobra.app.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

/**
 * Created by Hoang Huy on 11/12/2017.
 */
@Configuration
@EnableRedisHttpSession
public class RedisConfig extends AbstractHttpSessionApplicationInitializer {
    @Bean
    public JedisConnectionFactory connectionFactory() {
        JedisConnectionFactory jd=new JedisConnectionFactory();
        jd.setUsePool(false);
        jd.setHostName("127.0.0.1");
        jd.setPort(6379);
        return jd;
    }
    public RedisTemplate<String,String> stringRedisTemplate(){
        RedisTemplate<String, String> rt =new RedisTemplate<>();
        rt.setConnectionFactory(connectionFactory());
        rt.setDefaultSerializer(new StringRedisSerializer());
        return rt;
    }

    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }
}
