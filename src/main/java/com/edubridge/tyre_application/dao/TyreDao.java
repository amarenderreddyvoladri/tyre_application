package com.edubridge.tyre_application.dao;

import java.util.List;

import com.edubridge.tyre_application.model.Tyre;

public interface TyreDao {
	
	List<Tyre> getAllTyres();

	Tyre getTyre(int id);
	
	Tyre searchTyre(String brand);

	int addTyre(Tyre t);

	int updateTyre(Tyre t);

	int deleteTyre(Tyre t);

	int deleteAllTyres();

	int truncateTyre();

	List<Tyre> describeTyre();
}
