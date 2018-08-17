package com.disney.poc.profile.jedispoc.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.stereotype.Component;

@Component
public class RestCacheImpl implements RestCacheService {
	
	private static final String ALL = "ALL";
	
	private CacheManager cacheManager;
	private RedisCacheConfiguration redisConfig;
	private RedisCacheWriter cacheWriter;
	
	@Autowired
	public RestCacheImpl(CacheManager cacheManager,
			RedisCacheConfiguration redisConfig,
			RedisCacheWriter cacheWriter) {
		this.cacheManager = cacheManager;
		this.redisConfig = redisConfig;
		this.cacheWriter = cacheWriter;
	}

	public Response listCache() {
		Map<String, Integer> summary = new HashMap<>();
		Collection<String> caches = cacheManager.getCacheNames();
		for (String name : caches) {
//			redisConfig.;
//			Object redis = cacheManager.getCache(name).getNativeCache();
//            if (redis instanceof RedisCacheWriter) {
//            	RedisCacheWriter nativeCache = (RedisCacheWriter) redis;
//            	nativeCache.
////                summary.put(name, nativeCache.get(name, "*".getBytes()));
//            }
		}
		return Response.ok(new ArrayList<>(caches)).build();
	}
	
	public Response deleteCache(String cacheName) {
		if(ALL.equalsIgnoreCase(cacheName)) {
			Collection<String> caches = cacheManager.getCacheNames();
			for (String name : caches) {
				cacheWriter.clean(name, "*".getBytes());
			}
		} else {
			Cache cache = cacheManager.getCache(cacheName);
            cache.clear();
		}
		return Response.noContent().build();
	}

}
