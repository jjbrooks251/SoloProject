package com.qa.business;

import javax.inject.Inject;

import com.qa.persistance.repository.TypeRepository;

public class TypeServiceImpl implements TypeService {

	@Inject
	TypeRepository repo;
	
	@Override
	public String getAllTypes() {
		
		return repo.getAllTypes();
	}

	@Override
	public String getTypeId(int tId) {
		
		return repo.getTypeId(tId);
	}

	@Override
	public String getTypeName(String name) {
		
		return repo.getTypeName(name);
	}

}
