/**
 * 
 */
package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Tutorial;

/**
 * @author Rama Krishna M
 *
 */

@Repository
public interface TutorialRepository  extends JpaRepository<Tutorial, Long>{
	
	  List<Tutorial> findByPublished(boolean published);
	  List<Tutorial> findByTitleContaining(String title);

}
