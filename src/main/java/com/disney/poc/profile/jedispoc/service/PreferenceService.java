package com.disney.poc.profile.jedispoc.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

@Service
public class PreferenceService {
	
	private final static int MAX = 2; 

	@Cacheable(cacheManager="distManager", value="PREF", key="#id")
	public List<String> getPreferenceById(String id) {
		return randomPreference();
	}
	
	@CacheEvict(cacheManager="distManager", cacheNames="PREF", key="#id")
	public void deleteCharacters(String id) {
//		return randomPreference().stream()
//			.findFirst()
//			.get();
	}
	
	@Caching(evict = {
			@CacheEvict(cacheManager = "distManager", cacheNames="EPC", allEntries=true),
			@CacheEvict(cacheManager = "distManager", cacheNames="PREF", allEntries=true)
			})
	public void deleteCharacters() {

	}
	
	private List<String> randomPreference() {
		Random random = new Random();
		int size = CHARACTERS_PREFERENCE.size();
		return random.ints(size, 0, size - 1)
			.limit(MAX)
			.mapToObj(i -> CHARACTERS_PREFERENCE.get(i))
			.collect(Collectors.toList());
	}
	
	private final static List<String> CHARACTERS_PREFERENCE = Arrays.asList(
			"Mickey Mouse Universe ",
			"Snow White and the Seven Dwarfs ",
			"Pinocchio ",
			"Dumbo ",
			"Song of the South ",
			"Cinderella ",
			"Alice in Wonderland ",
			"Peter Pan ",
			"Lady and the Tramp ",
			"Sleeping Beauty ",
			"101 Dalmatians ",
			"The Sword in the Stone ",
			"Mary Poppins ",
			"Winnie the Pooh ",
			"The Jungle Book ",
			"Robin Hood ",
			"Who Framed Roger Rabbit ",
			"The Little Mermaid ",
			"Beauty and the Beast ",
			"Aladdin ",
			"Lion King ",
			"Pocahontas ",
			"Toy Story ",
			"The Hunchback of Notre Dame ",
			"Hercules ",
			"The Lion King 2 ",
			"Mulan ",
			"A Bug's Life ",
			"Tarzan ",
			"The Emperor's New Groove ",
			"Monsters, Inc. ",
			"Return to Never Land ",
			"Lilo & Stitch ",
			"Country Bears ",
			"Finding Nemo ",
			"Pirates of the Caribbean ",
			"Brother Bear ",
			"The Incredibles ",
			"Chicken Little ",
			"Cars ",
			"Meet the Robinsons ",
			"Ratatouille ",
			"WALL-E ",
			"Bolt ",
			"Up ",
			"The Princess and the Frog ",
			"Tangled ",
			"Brave ",
			"Wreck-It Ralph ",
			"Frozen ",
			"Big Hero 6 ",
			"Inside Out ",
			"Zootopia ",
			"Finding Dory ",
			"Moana "
			);

}

