CREATE TABLE round_player_stake (
  poker_table_id INT NOT NULL,
  round_id INT NOT NULL,
  player_id INT NOT NULL,
  -- this either needs a check constraint or an FK to a config table
  stage CHAR(10) NOT NULL,
  stake DECIMAL(15, 2) NOT NULL
    CHECK(stake >= 0),

  CONSTRAINT PK_round_player_stake PRIMARY KEY (poker_table_id, round_id, player_id, stage),
  CONSTRAINT FK_round_player_stake_poker_table_round_player FOREIGN KEY (poker_table_id, round_id, player_id)
    REFERENCES poker_table_round_player(poker_table_id, round_id, player_id)
);