CREATE TABLE roles (
  role_id   SERIAL PRIMARY KEY,
  role_name VARCHAR(20) NOT NULL
);

CREATE TABLE roles_right (
  roles_right_id   SERIAL PRIMARY KEY,
  roles_right_name VARCHAR(20)                        NOT NULL,
  role_id          INTEGER REFERENCES roles (role_id) NOT NULL
);

CREATE TABLE users (
  user_id     SERIAL PRIMARY KEY,
  login       VARCHAR(20)                        NOT NULL,
  password    VARCHAR(30)                        NOT NULL,
  role_id     INTEGER REFERENCES roles (role_id) NOT NULL,
  create_date TIMESTAMP                          NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE categories_item (
  categories_id   SERIAL PRIMARY KEY,
  categories_name VARCHAR(20) NOT NULL
);

CREATE TABLE status_item (
  status_id   SERIAL PRIMARY KEY,
  status_name VARCHAR(20) NOT NULL
);

CREATE TABLE items (
  item_id       SERIAL PRIMARY KEY,
  user_id       INTEGER REFERENCES users (user_id)                 NOT NULL,
  categories_id INTEGER REFERENCES categories_item (categories_id) NOT NULL,
  status_id     INTEGER REFERENCES status_item (status_id)         NOT NULL,
  description   VARCHAR(2000)                                      NOT NULL,
  create_date   TIMESTAMP                                          NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE comments (
  comment_id SERIAL PRIMARY KEY,
  comment    VARCHAR(2000)                      NOT NULL,
  item_id    INTEGER REFERENCES items (item_id) NOT NULL
);

CREATE TABLE attached_files (
  file_id   SERIAL PRIMARY KEY,
  file_path VARCHAR(200)                       NOT NULL,
  item_id   INTEGER REFERENCES items (item_id) NOT NULL
)