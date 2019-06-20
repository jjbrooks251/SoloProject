package com.qa.business;

public interface StorageService {

	public String createStorage(int uId, int cId);
	
	public String findAllStorages();

	public String findUserStorage(int uId);
	
	public String findAStorageId(int uId, int cId);

	public String deleteStorage(int uId, int cID);	
	
}
