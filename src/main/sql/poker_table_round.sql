CREATE TABLE poker_table_round (
  poker_table_id INT NOT NULL,
  round_id INT NOT NULL,
  active_player_id INT NOT NULL,
  current_stage CHAR(10) NOT NULL,

  CONSTRAINT PK_poker_table_round PRIMARY KEY (poker_table_id, round_id),
  CONSTRAINT FK_poker_table_round_poker_table FOREIGN KEY (poker_table_id) REFERENCES poker_table(poker_table_id),
  CONSTRAINT FK_poker_table_round_player FOREIGN KEY (active_player_id) REFERENCES player(player_id),
  CONSTRAINT FK_poker_table_round_round_stage FOREIGN KEY (current_stage) 
    REFERENCES round_stage(stage_id)
);