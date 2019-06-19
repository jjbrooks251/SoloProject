package com.qa.persistance.repository;

public interface StorageRepository {

	public String createStorage(int uId, int cId);

	public String findAllStorages();

	public String findAStorageId(int uId, int cId);

	public String deleteStorage(int uId, int cID);

}
