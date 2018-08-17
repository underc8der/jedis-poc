package com.disney.poc.profile.jedispoc.service;

import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

@Service
public class CacheFiller {

	@Autowired
	CacheManager cacheManager;
	
	@PostConstruct
	private void init() {
		update();
	}
	
	public void update() {
		String info = "Test ";
		int value = new Random().nextInt(100);
		for (int i = 0; i < value; i++) {
			cacheManager.getCache("EPC").put(i, info + value);
		}
	}

}
