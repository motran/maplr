
INSERT INTO team (coach, year) VALUES
  ('Dominique Ducharme', 2019),
  ('Dominique Ducharme', 2020);


INSERT INTO player (number, name, last_name, position, is_captain) VALUES
    (31, 'Carey', 'Price', 'goaltender', false),
    (14, 'Nick', 'Suzuki', 'forward', false),
    (15, 'Jesperi', 'Kotkaniemi', 'forward', false),
    (71, 'Jake', 'Evans', 'forward', false),
    (27, 'Alexander', 'Romanov', 'defenseman', false),
    (6, 'Shea', 'Weber', 'defenseman', true );

INSERT INTO composition (team_id, player_id) VALUES
    (1,1),
    (1,2),
    (1,3),
    (1,4),
    (1,5),
    (1,6),
    (2,1),
    (2,2),
    (2,3),
    (2,4),
    (2,5),
    (2,6);
