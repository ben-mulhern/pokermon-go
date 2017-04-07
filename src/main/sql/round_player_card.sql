CREATE TABLE round_player_card (
    poker_table_id INT NOT NULL,
    round_id INT NOT NULL,
    player_id INT NOT NULL,
    card_sequence INT NOT NULL
      CHECK(card_sequence BETWEEN 1 AND 2),
    suit CHAR(8) NOT NULL
      CHECK(suit IN ('SPADES', 'HEARTS', 'SUITS', 'DIAMONDS')),
    rank INT NOT NULL
      CHECK(rank BETWEEN 2 AND 14),

    CONSTRAINT PK_round_player_card PRIMARY KEY (poker_table_id, round_id, player_id, card_sequence),
    CONSTRAINT FK_round_player_card_round_player FOREIGN KEY (poker_table_id, round_id, player_id)
      REFERENCES round_player(poker_table_id, round_id, player_id)
  );