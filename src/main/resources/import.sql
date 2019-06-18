INSERT INTO USER (uId, username, password, email) VALUES (1, 'jrob93', 'Hammer93', 'jrob93@qa.com')
INSERT INTO USER (uId, username, password, email) VALUES (2, 'kryan95', 'Gymsch24', 'kryan95@qa.com')
INSERT INTO USER (uId, username, password, email) VALUES (3, 'mmist96', 'Netflix96', 'mmist96@qa.com')
INSERT INTO USER (uId, username, password, email) VALUES (4, 'kpatel95', 'Password95', 'kpatel95@qa.com')
INSERT INTO USER (uId, username, password, email) VALUES (5, 'omiller92', 'Magics92', 'omiller92@qa.com')

INSERT INTO TEAM (tId, user_uId) VALUES (1, 1)
INSERT INTO TEAM (tId, user_uId) VALUES (2, 1)
INSERT INTO TEAM (tId, user_uId) VALUES (3, 1)
INSERT INTO TEAM (tId, user_uId) VALUES (4, 2)
INSERT INTO TEAM (tId, user_uId) VALUES (5, 2)
INSERT INTO TEAM (tId, user_uId) VALUES (6, 3)
INSERT INTO TEAM (tId, user_uId) VALUES (7, 4)

INSERT INTO Unit (cId, name, alignment, hp, atk, def) VALUES (1, 'SSJ3 Gotenks', 'Super', 9578, 10453, 5478)
INSERT INTO Unit (cId, name, alignment, hp, atk, def) VALUES (2, 'SSJ Goku and Vegeta', 'Super', 15348, 14573, 7854)
INSERT INTO Unit (cId, name, alignment, hp, atk, def) VALUES (3, 'SSJ Gotenks', 'Super', 8697, 9645, 4677)
INSERT INTO Unit (cId, name, alignment, hp, atk, def) VALUES (4, 'SSJ Vegeta', 'Super', 10425, 9864, 5786)
INSERT INTO Unit (cId, name, alignment, hp, atk, def) VALUES (5, 'Super Vegito', 'Super', 8657, 9687, 4567)
INSERT INTO Unit (cId, name, alignment, hp, atk, def) VALUES (6, 'Mui Goku', 'Super', 7587, 6543, 3454)
INSERT INTO Unit (cId, name, alignment, hp, atk, def) VALUES (7, 'SSJ4 Goku', 'Super', 14758, 15869, 8321)
INSERT INTO Unit (cId, name, alignment, hp, atk, def) VALUES (8, 'Evo Vegeta', 'Super', 10245, 9524, 5872)
INSERT INTO Unit (cId, name, alignment, hp, atk, def) VALUES (9, 'Gogeta Blue', 'Super', 9754, 10567, 4867)
INSERT INTO Unit (cId, name, alignment, hp, atk, def) VALUES (10, 'SSJ3 goku', 'Super', 13575, 15012, 6874)
INSERT INTO Unit (cId, name, alignment, hp, atk, def) VALUES (11, 'Super Vegito', 'Super', 8675, 7675, 4387)
INSERT INTO Unit (cId, name, alignment, hp, atk, def) VALUES (12, 'Tapion', 'Super', 7867, 8765, 5465)
INSERT INTO Unit (cId, name, alignment, hp, atk, def) VALUES (13, 'LSS Broly', 'Extreme', 15436, 14258, 5367)
INSERT INTO Unit (cId, name, alignment, hp, atk, def) VALUES (14, 'Beserk Broly', 'Extreme', 13546, 14578, 5786)
INSERT INTO Unit (cId, name, alignment, hp, atk, def) VALUES (15, 'Mui Goku', 'Super', 11457, 9654, 5756)
INSERT INTO Unit (cId, name, alignment, hp, atk, def) VALUES (16, 'SSJ4 Gogeta', 'Super', 10867, 11575, 8676)
INSERT INTO Unit (cId, name, alignment, hp, atk, def) VALUES (17, 'Super Gogeta', 'Super', 8765, 9546, 5467)
INSERT INTO Unit (cId, name, alignment, hp, atk, def) VALUES (18, 'Turles', 'Extreme', 9898, 11425, 5241)
INSERT INTO Unit (cId, name, alignment, hp, atk, def) VALUES (19, 'Super Janemba', 'Extreme', 15786, 14658, 7685)
INSERT INTO Unit (cId, name, alignment, hp, atk, def) VALUES (20, 'FF Frieza', 'Extreme', 11578, 10548, 5742)
INSERT INTO Unit (cId, name, alignment, hp, atk, def) VALUES (21, 'FF Cooler', 'Extreme', 10453, 8675, 4124)
INSERT INTO Unit (cId, name, alignment, hp, atk, def) VALUES (22, 'Super 17', 'Extreme', 10425, 9654, 5123)
INSERT INTO Unit (cId, name, alignment, hp, atk, def) VALUES (23, 'Android 17 & 18', 'Extreme', 14758, 15869, 8321)
INSERT INTO Unit (cId, name, alignment, hp, atk, def) VALUES (24, 'Golden Frieza', 'Extreme', 8675, 7568, 4231)
INSERT INTO Unit (cId, name, alignment, hp, atk, def) VALUES (25, 'FF Cooler', 'Extreme', 8965, 6897, 4130)
INSERT INTO Unit (cId, name, alignment, hp, atk, def) VALUES (26, 'Saibamen', 'Extreme', 500, 752, 678)
INSERT INTO Unit (cId, name, alignment, hp, atk, def) VALUES (27, 'SSJ4 Vegeta', 'Super', 7865, 6425, 3452)
INSERT INTO Unit (cId, name, alignment, hp, atk, def) VALUES (28, 'Kid Goku', 'Super', 2004, 4342, 1025)
INSERT INTO Unit (cId, name, alignment, hp, atk, def) VALUES (29, 'Gohan','Super', 5002, 4236, 2145)

INSERT INTO RARITY (rId, name, lvMax) VALUES (1, 'N', 20)
INSERT INTO RARITY (rId, name, lvMax) VALUES (2, 'R', 40)
INSERT INTO RARITY (rId, name, lvMax) VALUES (3, 'SR', 60)
INSERT INTO RARITY (rId, name, lvMax) VALUES (4, 'SSR', 80)
INSERT INTO RARITY (rId, name, lvMax) VALUES (5, 'UR', 100)
INSERT INTO RARITY (rId, name, lvMax) VALUES (6, 'TUR', 120)
INSERT INTO RARITY (rId, name, lvMax) VALUES (7, 'LR', 150)
INSERT INTO RARITY (rId, name, lvMax) VALUES (8, 'Eza', 140)

INSERT INTO TYPE (tId, name) VALUES (1, 'Str')
INSERT INTO TYPE (tId, name) VALUES (2, 'Phy')
INSERT INTO TYPE (tId, name) VALUES (3, 'Int')
INSERT INTO TYPE (tId, name) VALUES (4, 'Teq')
INSERT INTO TYPE (tId, name) VALUES (5, 'Agl')

INSERT INTO TEAM_Unit (team_tId, Unit_cId) VALUES (1, 1)
INSERT INTO TEAM_Unit (team_tId, Unit_cId) VALUES (1, 17)
INSERT INTO TEAM_Unit (team_tId, Unit_cId) VALUES (1, 5)
INSERT INTO TEAM_Unit (team_tId, Unit_cId) VALUES (2, 20)
INSERT INTO TEAM_Unit (team_tId, Unit_cId) VALUES (3, 5)

INSERT INTO USER_Unit (user_uId, Unit_cId) VALUES (1, 1)

