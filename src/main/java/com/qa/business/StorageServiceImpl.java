package com.qa.business;

import javax.inject.Inject;

import com.qa.persistance.repository.StorageRepository;

public class StorageServiceImpl implements StorageService {

	@Inject
	StorageRepository repo;

	public String createStorage(int uId, int cId) {

		return repo.createStorage(uId, cId);
	}

	public String findAllStorages() {

		return repo.findAllStorages();
	}

	public String findAStorageId(int uId, int cId) {

		return repo.findAStorageId(uId, cId);

	}

	public String deleteStorage(int uId, int cID) {

		return repo.deleteStorage(uId, cID);
	}

	
	public String findUserStorage(int uId) {
		
		return repo.findUserStorage(uId);
	}

}
