package com.GroceryApplication.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.GroceryApplication.api.model.Grocery;

@Repository
public interface GroceryRepo extends JpaRepository<Grocery, Integer>{
	
	@Query("from Grocery g where g.name=:name")
	public Grocery findByName(@Param("name") String name);
	
	@Query("update Grocery g set g.unit=:unit where g.id=:id")
	public void updateTable(@Param("id") int id, @Param("unit") int unit);
}
