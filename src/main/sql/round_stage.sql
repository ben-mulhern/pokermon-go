CREATE TABLE round_stage (
  stage_id CHAR(10) NOT NULL
    CHECK (stage_id <> ''),
  stage_description VARCHAR(100) NOT NULL 
    CHECK (stage_description <> ''),

  CONSTRAINT PK_round_stage PRIMARY KEY (stage_id)
);