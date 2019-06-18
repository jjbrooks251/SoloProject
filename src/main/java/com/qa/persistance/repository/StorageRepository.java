package com.qa.persistance.repository;

public interface StorageRepository {

	public String createStorage(String storage);

	public String findAllStorages();

	public String findAStorageId(int id);

	public String findAStorageName(String storagename);

	public String updateStorage(int id, String storage);

	public String deleteStorage(int id);

}
