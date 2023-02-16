package com.example.propertymanagement.repository;


import com.example.propertymanagement.entity.PropertyEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface PropertyRepository extends CrudRepository<PropertyEntity, Long> {
}
