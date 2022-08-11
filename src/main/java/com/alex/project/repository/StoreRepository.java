package com.alex.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alex.project.entity.Store;

@Repository
public interface StoreRepository extends CrudRepository<Store, Long>{

}
