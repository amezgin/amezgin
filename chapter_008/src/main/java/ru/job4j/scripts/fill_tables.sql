INSERT INTO role (role_name) VALUES ('admin');

INSERT INTO role (role_name) VALUES ('user');

INSERT INTO rules (rule_name) VALUES ('write');

INSERT INTO rules (rule_name) VALUES ('read');

INSERT INTO role_to_rules (role_id, rule_id) VALUES ('1', '1');

INSERT INTO role_to_rules (role_id, rule_id) VALUES ('1', '2');

INSERT INTO users (login, password, role_id, create_date) VALUES ('root', 'root', '1', '2015-01-01 00:00:01');

INSERT INTO users (login, password, role_id) VALUES ('user', 'root', '2');

INSERT INTO categories (categories_name) VALUES ('task');

INSERT INTO categories (categories_name) VALUES ('task1');

INSERT INTO status (status_name) VALUES ('open');

INSERT INTO status (status_name) VALUES ('close');

INSERT INTO item (user_id, categories_id, status_id, description, create_date)
VALUES ('1', '1', '1', 'This is new task!', '2015-01-01 00:00:01');

INSERT INTO item (user_id, categories_id, status_id, description)
VALUES ('2', '2', '2', 'The task is closed!');

INSERT INTO comments (comment, item_id) VALUES ('!!!!!!', '1');

INSERT INTO attached_files (file_path, item_id) VALUES ('d:\file.txt', '2');