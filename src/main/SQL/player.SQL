CREATE TABLE player (
  player_id INT GENERATED ALWAYS AS IDENTITY,
  player_name VARCHAR(50),
  username VARCHAR(50),
  email_address VARCHAR(50),
  CONSTRAINT PK_player PRIMARY KEY  (player_id)

)