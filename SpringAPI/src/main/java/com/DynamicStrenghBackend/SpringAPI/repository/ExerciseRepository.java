package com.DynamicStrenghBackend.SpringAPI.repository;

import com.DynamicStrenghBackend.SpringAPI.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

	Exercise findExerciseByExerciseName(String exerciseName);
	List<Exercise> findExercisesByTargetContaining(String targetValue);

	List<Exercise> findExercisesByBodyPartContaining(String bodyPartValue);

}

