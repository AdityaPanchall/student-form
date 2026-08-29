CREATE TABLE IF NOT EXISTS "formDetails" (
    id SERIAL PRIMARY KEY,
    "firstName" VARCHAR(100) NOT NULL,
    "lastName" VARCHAR(100) NOT NULL,
    dob DATE NOT NULL,
    gender VARCHAR(20) NOT NULL,
    highestqualification VARCHAR(100) NOT NULL,
    year_of_passing INTEGER NOT NULL,
    mobilenumber VARCHAR(15) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP

);