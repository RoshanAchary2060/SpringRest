package com.rosan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rosan.entity.Tourist;
import com.rosan.exception.TouristNotFoundException;
import com.rosan.repo.ITouristRepo;

@Service
public class TouristMgmtServiceImpl implements ITouristMgmtService {
	@Autowired
	private ITouristRepo touristRepo;

	@Override
	public String registerTourist(Tourist tourist) {
		return "Tourist registered with id :: " + touristRepo.save(tourist).getTid();
	}

	@Override
	public List<Tourist> fetchAllTourists() {
		List<Tourist> list = touristRepo.findAll();
		list.sort((t1, t2) -> t1.getTid().compareTo(t2.getTid()));
		return list;
	}

	@Override
	public Tourist fetchTouristById(Integer id) throws TouristNotFoundException {
		return touristRepo.findById(id)
				.orElseThrow(() -> new TouristNotFoundException("Tourist with the given id not found!"));
	}

	@Override
	public String updateTouristDetails(Tourist tourist) throws TouristNotFoundException {
		Optional<Tourist> optional = touristRepo.findById(tourist.getTid());
		if (optional.isPresent()) {
			touristRepo.save(tourist); // save() performs either save or update object operation
			return "Tourist updated with id :: " + tourist.getTid();
		} else {
			throw new TouristNotFoundException("Tourist not found with id :: " + tourist.getTid());
		}
	}

	@Override
	public String deleteTouristById(Integer tid) throws TouristNotFoundException {
		Optional<Tourist> optional = touristRepo.findById(tid);
		if (optional.isPresent()) {
			touristRepo.delete(optional.get());
			return "Tourist deleted with id :: " + tid;
		} else {
			throw new TouristNotFoundException("Tourist not found with id :: " + tid);

		}
	}

	@Override
	public String updateTouristBudgetById(Integer id, Double hikePercent) throws TouristNotFoundException {
		Optional<Tourist> optional = touristRepo.findById(id);
		if (optional.isPresent()) {
			Tourist tourist = optional.get();
			tourist.setBudget(tourist.getBudget() + (tourist.getBudget() * hikePercent / 100));
			touristRepo.save(tourist);
			return "Tourist budget updated with id :: " + id;
		} else {
			throw new TouristNotFoundException("Tourist not found with id :: " + id);

		}
	}

}
