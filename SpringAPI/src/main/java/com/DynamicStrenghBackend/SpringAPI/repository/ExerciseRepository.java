package com.DynamicStrenghBackend.SpringAPI.repository;

import com.DynamicStrenghBackend.SpringAPI.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

//	Exercise findExerciseByName(@Param(value="exerciseName") String exerciseName);

}
