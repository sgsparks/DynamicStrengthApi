package com.DynamicStrenghBackend.SpringAPI.repository;

import com.DynamicStrenghBackend.SpringAPI.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

	Exercise findExerciseByExerciseName(@Param(value="exerciseName") String exerciseName);
	List<Exercise> findExercisesByTargetContaining(String target);

}
