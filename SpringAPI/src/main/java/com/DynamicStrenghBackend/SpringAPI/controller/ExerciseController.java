package com.DynamicStrenghBackend.SpringAPI.controller;

import com.DynamicStrenghBackend.SpringAPI.exception.ResourceNotFoundException;
import com.DynamicStrenghBackend.SpringAPI.model.Exercise;
import com.DynamicStrenghBackend.SpringAPI.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	//Get exercise by name
	@GetMapping("/exercises/byName/{exerciseName}")
	public ResponseEntity<Exercise> getExerciseByName(@PathVariable("exerciseName") String exerciseName) {
		try {
			Exercise exercise = exerciseRepository.findExerciseByExerciseName(exerciseName);

			if (exercise != null) {
				return ResponseEntity.ok(exercise);
			} else {
				throw new ResourceNotFoundException("Exercise not found with name: " + exerciseName);
			}
		} catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@GetMapping("/exercises/target/{targetValue}")
	public ResponseEntity<List<Exercise>> getExercisesByTarget(@PathVariable("targetValue") String targetValue) {
		try {
			List<Exercise> exercises = exerciseRepository.findExercisesByTargetContaining(targetValue);

			if (!exercises.isEmpty()) {
				return ResponseEntity.ok(exercises);
			} else {
				throw new ResourceNotFoundException("No exercises found for target: " + targetValue);
			}
		} catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@GetMapping("/exercises/bodyPart/{bodyPartValue}")
	public ResponseEntity<List<Exercise>> getExercisesByBodyPart(@PathVariable("bodyPartValue") String bodyPartValue) {
		try {
			List<Exercise> exercises = exerciseRepository.findExercisesByBodyPartContaining(bodyPartValue);

			if (!exercises.isEmpty()) {
				return ResponseEntity.ok(exercises);
			} else {
				throw new ResourceNotFoundException("No exercises found for target: " + bodyPartValue);
			}
		} catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

}
