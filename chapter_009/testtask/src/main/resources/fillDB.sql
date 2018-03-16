INSERT INTO roles (id, name)
VALUES ('1', 'ADMIN'), ('2', 'MANDATOR'), ('3', 'USER');

INSERT INTO music_type (musictype)
VALUES ('ROCK'), ('POP'), ('JAZZ'), ('FOLK');

INSERT INTO users (login, password, role_id)
VALUES ('root', 'root', 1);

INSERT INTO address (postcode, city, street, home, user_id)
VALUES ('157000', 'Moscow', 'Mira', '31', '1');

INSERT INTO user_musictype (user_id, musictype_id)
VALUES ('1', '1')