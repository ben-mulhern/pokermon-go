CREATE TABLE poker_table (
  poker_table_id  INT NOT NULL GENERATED ALWAYS AS IDENTITY,
  poker_table_name VARCHAR(100) NOT NULL
    CHECK(poker_table_name <> ''),
  chip_currency_exchange_rate DECIMAL(19, 9)
    CHECK(chip_currency_exchange_rate > 0),

  CONSTRAINT PK_poker_table PRIMARY KEY  (poker_table_id)
);