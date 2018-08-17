package com.disney.poc.profile.jedispoc.controller;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.disney.poc.profile.jedispoc.service.PreferenceService;

@Component
public class RestPreferenceServiceImpl implements RestPreferenceService {
	
	@Autowired
	private PreferenceService preference;

	@Override
	public Response getPreference(String id) {
		return Response
				.ok(preference.getPreferenceById(id))
				.build();
	}

}
