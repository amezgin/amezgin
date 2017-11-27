INSERT INTO roles (role_name) VALUES ('admin');

INSERT INTO roles (role_name) VALUES ('user');

INSERT INTO roles_right (roles_right_name, role_id) VALUES ('full', '1');

INSERT INTO roles_right (roles_right_name, role_id) VALUES ('read', '2');

INSERT INTO users (login, password, role_id, create_date) VALUES ('root', 'root', '1', '2015-01-01 00:00:01');

INSERT INTO users (login, password, role_id) VALUES ('mezgin', 'root', '2');

INSERT INTO categories_item (categories_name) VALUES ('task');

INSERT INTO categories_item (categories_name) VALUES ('task1');

INSERT INTO status_item (status_name) VALUES ('open');

INSERT INTO status_item (status_name) VALUES ('close');

INSERT INTO items (user_id, categories_id, status_id, description, create_date)
VALUES ('1', '1', '1', 'This is new task!', '2015-01-01 00:00:01');

INSERT INTO items (user_id, categories_id, status_id, description)
VALUES ('2', '2', '2', 'The task is closed!');

INSERT INTO comments (comment, item_id) VALUES ('!!!!!!', '1');

INSERT INTO attached_files (file_path, item_id) VALUES ('d:\file.txt', '2');