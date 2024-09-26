package com.rosan.service;

import java.util.List;

import com.rosan.entity.Tourist;
import com.rosan.exception.TouristNotFoundException;

public interface ITouristMgmtService {
	public String registerTourist(Tourist tourist);

	public List<Tourist> fetchAllTourists();

	public Tourist fetchTouristById(Integer id) throws TouristNotFoundException;

	public String updateTouristDetails(Tourist tourist) throws TouristNotFoundException;

	public String deleteTouristById(Integer tid) throws TouristNotFoundException;

	public String updateTouristBudgetById(Integer id, Double hikePercent) throws TouristNotFoundException;
}
