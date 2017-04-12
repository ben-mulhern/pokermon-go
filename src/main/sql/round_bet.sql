CREATE TABLE round_bet (
  poker_table_id INT NOT NULL,
  round_id INT NOT NULL,
  bet_sequence INT NOT NULL
    CHECK (bet_sequence > 0),
  player_id INT NOT NULL,
  stage_id CHAR(10) NOT NULL,
  bet_amount DECIMAL(15, 2) NOT NULL
    CHECK(bet_amount > 0),

  CONSTRAINT PK_round_bet PRIMARY KEY (poker_table_id, round_id, bet_sequence),
  CONSTRAINT FK_round_bet_round_player FOREIGN KEY (poker_table_id, round_id, player_id)
    REFERENCES round_player(poker_table_id, round_id, player_id),
  CONSTRAINT FK_round_bet_round_stage FOREIGN KEY (stage_id) 
    REFERENCES round_stage(stage_id)
);