CREATE TABLE role (
  role_id   SERIAL PRIMARY KEY,
  role_name VARCHAR(20) NOT NULL
);

CREATE TABLE rules (
  rule_id   SERIAL PRIMARY KEY,
  rule_name VARCHAR(20) NOT NULL
);

CREATE TABLE role_to_rules (
  id      SERIAL PRIMARY KEY,
  role_id INTEGER REFERENCES role (role_id)  NOT NULL,
  rule_id INTEGER REFERENCES rules (rule_id) NOT NULL
);

CREATE UNIQUE INDEX "UI_role_to_rules_role_id_rule_id"
  ON role_to_rules
  USING BTREE
  (role_id, rule_id);

CREATE TABLE users (
  user_id     SERIAL PRIMARY KEY,
  login       VARCHAR(20)                       NOT NULL,
  password    VARCHAR(30)                       NOT NULL,
  role_id     INTEGER REFERENCES role (role_id) NOT NULL,
  create_date TIMESTAMP                         NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE categories (
  categories_id   SERIAL PRIMARY KEY,
  categories_name VARCHAR(20) NOT NULL
);

CREATE TABLE status (
  status_id   SERIAL PRIMARY KEY,
  status_name VARCHAR(20) NOT NULL
);

CREATE TABLE item (
  item_id       SERIAL PRIMARY KEY,
  user_id       INTEGER REFERENCES users (user_id)                 NOT NULL,
  categories_id INTEGER REFERENCES categories (categories_id)      NOT NULL,
  status_id     INTEGER REFERENCES status (status_id)              NOT NULL,
  description   VARCHAR(2000)                                      NOT NULL,
  create_date   TIMESTAMP                                          NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE comments (
  comment_id SERIAL PRIMARY KEY,
  comment    VARCHAR(2000)                     NOT NULL,
  item_id    INTEGER REFERENCES item (item_id) NOT NULL
);

CREATE TABLE attached_files (
  file_id   SERIAL PRIMARY KEY,
  file_path VARCHAR(200)                      NOT NULL,
  item_id   INTEGER REFERENCES item (item_id) NOT NULL
)