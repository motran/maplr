DROP TABLE IF EXISTS composition CASCADE;
DROP TABLE IF EXISTS player CASCADE;
DROP TABLE IF EXISTS team CASCADE;

CREATE TABLE team (
  id INT AUTO_INCREMENT PRIMARY KEY,
  coach VARCHAR(250) NOT NULL,
  year BIGINT NOT NULL
);


CREATE TABLE player (
    id INT AUTO_INCREMENT PRIMARY KEY,
    number TINYINT NOT NULL,
    name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    position VARCHAR(50) NOT NULL,
    is_captain BOOLEAN NOT NULL
);

CREATE TABLE composition (
    id INT AUTO_INCREMENT PRIMARY KEY,
    team_id BIGINT NOT NULL,
    player_id BIGINT NOT NULL,
    FOREIGN KEY (team_id) REFERENCES team(id),
    FOREIGN KEY (player_id) REFERENCES player(id),
    UNIQUE KEY unique_composition (team_id, player_id)
);