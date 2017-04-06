CREATE TABLE poker_table_round_player (
  poker_table_id INT NOT NULL,
  round_id INT NOT NULL,
  player_id INT NOT NULL,
  sequence INT NOT NULL
    CHECK(sequence > 0),

  CONSTRAINT PK_poker_table_round_player PRIMARY KEY (poker_table_id, round_id, player_id),
  CONSTRAINT FK_poker_table_round_player_poker_table_round FOREIGN KEY (poker_table_id, round_id)
    REFERENCES poker_table_round(poker_table_id, round_id),
  CONSTRAINT FK_poker_table_round_player_player FOREIGN KEY (player_id) REFERENCES player(player_id)
);