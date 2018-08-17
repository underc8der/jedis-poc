package com.disney.poc.profile.jedispoc.cache;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager.RedisCacheManagerBuilder;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

@Configuration
@EnableCaching
//@ComponentScan("com.disney.poc.profile.jedispoc.cache")
@PropertySource("classpath:/redis.properties")
public class CacheConfig extends CachingConfigurerSupport {

	@Value("${redis.host}")
	private String redisHost;
	@Value("${redis.port}")
	private int redisPort;

//	@Value("${redis.pass}")
//	private String redisPass;
//	@Value("${redis.pool.maxIdle:1000}")
//	private int maxIdle;
//	@Value("${redis.pool.minIdle:100}")
//	private int minIdle;
//	@Value("${redis.pool.testOnBorrow:true}")
//	private boolean testOnBorrow;
//	@Value("${redis.pool.testOnReturn:true}")
//	private boolean testOnReturn;
//	@Value("${redis.pool.testWhileIdle:true}")
//	private boolean testWhileIdle;

	@Bean
	public JedisConnectionFactory redisConnectionFactory() {
//		JedisPoolConfig poolConfig = new JedisPoolConfig();
//		poolConfig.setMaxIdle(maxIdle);
//		poolConfig.setMinIdle(minIdle);
//		poolConfig.setTestOnBorrow(testOnBorrow);
//		poolConfig.setTestOnReturn(testOnReturn);
//		poolConfig.setTestWhileIdle(testWhileIdle);

		RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();
		config.setHostName(redisHost);
		config.setPort(redisPort);
		JedisConnectionFactory connectionFactory = new JedisConnectionFactory(config);
		return connectionFactory;
	}

//	@Bean
//	public RedisTemplate<?, ?> redisTemplate(RedisConnectionFactory cf) {
//		RedisTemplate<?, ?> template = new RedisTemplate<>();
//		template.setConnectionFactory(cf);
//		return template;
//	}
	
	@Bean
	public RedisCacheWriter cacheWriter(RedisConnectionFactory cf) {
		return RedisCacheWriter.nonLockingRedisCacheWriter(cf);
	}
	
	@Bean
	public RedisCacheConfiguration redisConfig() {
		return RedisCacheConfiguration.defaultCacheConfig();
	}

	@Bean(name="distManager")
	public CacheManager cacheManager(RedisCacheWriter cacheWriter, RedisCacheConfiguration redisConfig) {
		return RedisCacheManagerBuilder
				.fromCacheWriter(cacheWriter)
				.cacheDefaults(redisConfig)
				.build();
	}
}
