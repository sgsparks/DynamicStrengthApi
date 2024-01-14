package com.DynamicStrenghBackend.SpringAPI.controller;

import com.DynamicStrenghBackend.SpringAPI.model.Exercise;
import com.DynamicStrenghBackend.SpringAPI.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class ExerciseController {
	@Autowired
	private ExerciseRepository exerciseRepository;

	//Return all exercises
	@GetMapping("/exercises")
	public List<Exercise> getAllExercises(){
		return exerciseRepository.findAll();
	}

	//Create an exercise
	@PostMapping("/exercise")
	public Exercise createExercise(@RequestBody Exercise exercise) {
		return exerciseRepository.save(exercise);
	}

//	//Get exercise by name
//	@GetMapping("/exercise/{exerciseName}")
//	public ResponseEntity<Exercise> getExerciseByName(@PathVariable("exerciseName") String exerciseName) {
//		try {
//			Exercise exercise = exerciseRepository.findExerciseByName(exerciseName);
//			return ResponseEntity.ok(exercise);
//		} catch(Exception e) {
//			 new ResourceNotFoundException("Exercise not exist with name :" + exerciseName + " exception: ");  e.printStackTrace();
//		}
//		return null;
//	}

}
