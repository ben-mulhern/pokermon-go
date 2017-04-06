CREATE TABLE poker_table_round_card (
  poker_table_id INT NOT NULL,
  round_id INT NOT NULL,
  card_type CHAR(5) NOT NULL
    CHECK(card_type IN ('FLOP', 'TURN', 'RIVER')),
  sequence INT NOT NULL DEFAULT 1,
  suit CHAR(8) NOT NULL
    CHECK(suit IN ('SPADES', 'HEARTS', 'SUITS', 'DIAMONDS')),
  rank INT NOT NULL
    CHECK(rank BETWEEN 2 AND 14),

  CONSTRAINT PK_poker_table_round_card PRIMARY KEY (poker_table_id, round_id, card_type, sequence),
  CONSTRAINT FK_poker_table_round_card_poker_table_round FOREIGN KEY (poker_table_id, round_id)
    REFERENCES poker_table_round(poker_table_id, round_id),
  CONSTRAINT poker_table_round_card_sequence
    CHECK(card_type = 'FLOP' AND sequence BETWEEN 1 AND 3 OR sequence = 1)
);