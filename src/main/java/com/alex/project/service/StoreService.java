package com.alex.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alex.project.MtO.StoreMTO;
import com.alex.project.entity.Store;
import com.alex.project.repository.StoreRepository;

@Service
public class StoreService {

	@Autowired
	private StoreRepository storeRepository;

	public void addStore(Store store) {
		storeRepository.save(store);
	}

	public List<StoreMTO> getAllStores() {
		List<StoreMTO> stores = new ArrayList<StoreMTO>();
		storeRepository.findAll()
				.forEach(store -> stores.add(new StoreMTO(store.getId(), store.getName(), store.getAddress())));
		return stores;
	}

	public Store findStoreById(Long id) {
		Optional<Store> store = storeRepository.findById(id);

		if (store.isPresent()) {
			return store.get();
		} else {
			throw new RuntimeException("Cannot find store with ID :" + id);
		}
	}

	public StoreMTO findStoreMTOById(Long id) {
		Optional<Store> store = storeRepository.findById(id);

		if (store.isPresent()) {
			return new StoreMTO(store.get().getId(), store.get().getName(), store.get().getAddress());
		} else {
			throw new RuntimeException("Cannot find store with ID :" + id);
		}
	}

	public void updateStore(Store store) {
		storeRepository.save(store);
	}

	public void removeStoreById(Long id) {
		storeRepository.deleteById(id);
	}
}
