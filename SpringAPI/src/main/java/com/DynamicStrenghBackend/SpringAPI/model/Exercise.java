package com.DynamicStrenghBackend.SpringAPI.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name ="excersise")
public class Exercise {

	@Column(name="exerciseName")
	private String exerciseName;
	@Column(name="instructions")
	private String instructions;
	@Column(name="bodyPart")
	private String bodyPart;
	@Column(name="target")
	private String target;
	@Column(name="secondary")
	private List<String> secondary;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int exerciseId;


	public Exercise(String exerciseName, String instructions, String bodyPart, String target, List<String> secondary, int exerciseId) {
		this.exerciseName = exerciseName;
		this.instructions = instructions;
		this.bodyPart = bodyPart;
		this.target = target;
		this.secondary = secondary;
		this.exerciseId = exerciseId;
	}

	public String getExerciseName() {
		return exerciseName;
	}

	public void setExerciseName(String exerciseName) {
		this.exerciseName = exerciseName;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public String getBodyPart() {
		return bodyPart;
	}

	public void setBodyPart(String bodyPart) {
		this.bodyPart = bodyPart;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public List<String> getSecondary() {
		return secondary;
	}

	public void setSecondary(List<String> secondary) {
		this.secondary = secondary;
	}

	public int getExerciseId() {
		return exerciseId;
	}

	public void setExerciseId(int exerciseId) {
		this.exerciseId = exerciseId;
	}

}
