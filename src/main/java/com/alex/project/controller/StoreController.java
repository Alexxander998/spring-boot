package com.alex.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alex.project.MtO.StoreMTO;
import com.alex.project.entity.Store;
import com.alex.project.service.StoreService;

@RestController
public class StoreController {

	@Autowired
	private StoreService storeService;

	@PostMapping(path = "/store/{name}/{address}")
	public void createStore(@PathVariable String name, @PathVariable String address) {
		storeService.addStore(new Store(name, address));
	}

	@GetMapping(path = "/stores")
	public List<StoreMTO> getAllStores() {
		return storeService.getAllStores();
	}

	@GetMapping(path = "/stores/{id}")
	public StoreMTO getStoreById(@PathVariable Long id) {
		return storeService.findStoreMTOById(id);
	}

	@PutMapping(path = "/store/{id}/{name}/{address}")
	public void updateStore(@PathVariable Long id, @PathVariable String name, @PathVariable String address) {
		Store store = storeService.findStoreById(id);
		store.setName(name);
		store.setAddress(address);
		storeService.updateStore(store);
	}

	@DeleteMapping(path = "stores/d/{id}")
	public void deleteStore(@PathVariable Long id) {
		storeService.removeStoreById(id);
	}
}
