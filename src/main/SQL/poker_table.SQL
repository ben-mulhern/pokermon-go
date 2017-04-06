CREATE TABLE poker_table (
  poker_table_id  INT GENERATED ALWAYS AS IDENTITY,
  poker_table_name VARCHAR(100),
  unit_of_wager  CHAR(5),
  CONSTRAINT PK_poker_table PRIMARY KEY  (poker_table_id  )
)