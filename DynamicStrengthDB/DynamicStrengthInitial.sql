
CREATE DATABASE "potentStrengthDb"
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
 
CREATE TABLE "excersise" (
  "excersiseName" varchar,
  "instructions" text,
  "bodyPart" varchar,
  "target" varchar,
  "secondary" varchar,
  "exerciseId" SERIAL PRIMARY KEY UNIQUE
);

CREATE TABLE "history" (
  "userName" varchar,
  "excersiseName" varchar,
  "tempo" varchar,
  "prescribedReps" varchar,
  "acutalReps" varchar,
  "weight" int,
  "createdAt" date,
  "historyId" SERIAL PRIMARY KEY UNIQUE,
  "userId" int,
  "workoutId" int,
	"prescribedExerciseid" int
);

CREATE TABLE "prescribedExercise" (
  "exerciseName" varchar,
  "plannedTempo" varchar,
  "plannedReps" varchar,
  "notes" varchar,
  "prescribedExerciseid" SERIAL PRIMARY KEY UNIQUE
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

ALTER TABLE "history" ADD FOREIGN KEY ("prescribedExerciseid") REFERENCES "prescribedExercise" ("prescribedExerciseid");

ALTER TABLE "history" ADD FOREIGN KEY ("workoutId") REFERENCES "prescribedWorkout" ("workoutId");
