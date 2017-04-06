CREATE TABLE player (
  player_id INT NOT NULL GENERATED ALWAYS AS IDENTITY,
  player_name VARCHAR(50) NOT NULL
    CHECK(player_name <> ''),
  username VARCHAR(50) NOT NULL
    CHECK(username <> ''),
  email_address VARCHAR(256) NOT NULL UNIQUE
    CHECK(email_address <> ''),
  cash_on_account DECIMAL(15, 2) NOT NULL
    CHECK(cash_on_account >= 0),
  password_salt VARCHAR(100) NOT NULL,
  password_hash VARCHAR(100) NOT NULL,

  CONSTRAINT PK_player PRIMARY KEY (player_id)
);