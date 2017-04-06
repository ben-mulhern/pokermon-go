CREATE TABLE poker_table_player (
  poker_table_id  INT,
  player_id INT,
  CONSTRAINT PK_poker_table_player PRIMARY KEY  (poker_table_id,  player_id),
  CONSTRAINT FK_poker_table_player_player FOREIGN KEY (player_id) REFERENCES player(player_id),
  CONSTRAINT FK_poker_table_player_poker_table FOREIGN KEY (poker_table_id) REFERENCES poker_table(poker_table_id)

);