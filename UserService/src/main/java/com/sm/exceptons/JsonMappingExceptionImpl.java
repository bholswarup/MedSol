package com.sm.exceptons;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonMappingExceptionImpl implements JsonMappingException {

	private ObjectMapper mapper;

	@Override
	public Object checkRequestData(Object obj, String data) {
		mapper = new ObjectMapper();
		try {
			obj = mapper.readValue(data, obj.getClass());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}

}
