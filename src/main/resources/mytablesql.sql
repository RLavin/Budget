
CREATE SCHEMA  financing

CREATE TABLE financing.budget
(
    bud_id INTEGER PRIMARY KEY NOT NULL,
    bud_category VARCHAR(255),
    bud_description VARCHAR(255),
    bud_budamount INTEGER,
    bud_actamount INTEGER
);

CREATE SEQUENCE financing.budget_SEQ;
