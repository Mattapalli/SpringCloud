/**
 * 
 */
package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.main.dto.EmployeeDTO;
import com.example.dao.TutorialRepository;
import com.example.model.Tutorial;

/**
 * @author Rama Krishna M
 *
 */
@Service
public class TutorialService {
	@Autowired
	TutorialRepository tutorialRepository;

	public Tutorial createTutorial(Tutorial tutorial) {
		// TODO Auto-generated method stub

		return tutorialRepository.save(tutorial);
	}

	public Optional<Tutorial> getTutorialById(long id) {
		// TODO Auto-generated method stub
		Optional<Tutorial> tutorialData = tutorialRepository.findById(id);
		return tutorialData;
	}

	public Optional<Tutorial> updateTutorial(long id, Tutorial tutorial) {
		// TODO Auto-generated method stub
		Optional<Tutorial> tutorialData = tutorialRepository.findById(id);
		if (tutorialData.isPresent()) {
			Tutorial _tutorial = tutorialData.get();
			_tutorial.setTitle(tutorial.getTitle());
			_tutorial.setDescription(tutorial.getDescription());
			_tutorial.setPublished(tutorial.isPublished());
		} else {
			System.out.println("Data Not Found");
		}
		return tutorialData;

	}

	public List<Tutorial> getAllTutorials() {
		// TODO Auto-generated method stub
		return tutorialRepository.findAll();

	}

	public void deleteTutorialById(long id) {
		// TODO Auto-generated method stub
		tutorialRepository.deleteById(id);

	}

}
