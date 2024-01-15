-- Database: dynamicStrengthDB

-- DROP DATABASE IF EXISTS "dynamicStrengthDB";

CREATE DATABASE "dynamicStrengthDB"
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'C'
    LC_CTYPE = 'C'
    LOCALE_PROVIDER = 'libc'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;





CREATE TABLE "users" (
  userId SERIAL PRIMARY KEY UNIQUE,
  "userName" varchar,
  "email" varchar,
  "createdAt" timestamp
);
 
CREATE TABLE "exercise" (
  "exerciseName" varchar,
  "instructions" text,
  "bodyPart" varchar,
  "target" varchar,
  "secondary" varchar[],
  "exerciseId" SERIAL PRIMARY KEY UNIQUE
);

CREATE TABLE "history" (
  "userName" varchar,
  "exerciseName" varchar,
  "tempo" varchar,
  "prescribedReps" varchar,
  "actualReps" varchar,
  "weight" int,
  "createdAt" date,
  "historyId" SERIAL PRIMARY KEY UNIQUE,
  "userId" int,
  "workoutId" int,
	"prescribedExerciseId" int
);

CREATE TABLE "prescribedExercise" (
  "exerciseName" varchar,
  "plannedTempo" varchar,
  "plannedReps" varchar,
  "notes" varchar,
  "prescribedExerciseId" SERIAL PRIMARY KEY UNIQUE
);

CREATE TABLE "prescribedWorkout" (
  "prescribedExercises" varchar,
  "userName" varchar,
  "userId" int,
  "workoutName" varchar,
  "workoutId" SERIAL PRIMARY KEY UNIQUE
);

ALTER TABLE "history" ADD FOREIGN KEY ("userId") REFERENCES "users" (userId);

ALTER TABLE "prescribedWorkout" ADD FOREIGN KEY ("userId") REFERENCES "users" (userId);

ALTER TABLE "history" ADD FOREIGN KEY ("prescribedExerciseId") REFERENCES "prescribedExercise" ("prescribedExerciseId");

ALTER TABLE "history" ADD FOREIGN KEY ("workoutId") REFERENCES "prescribedWorkout" ("workoutId");
