INSERT INTO CATEGORIES(ID, NAME) VALUES 
	(1, 'TERROR'), 
	(2, 'COMEDIA'), 
	(3, 'ACCIÓN');
    
INSERT INTO TV_SHOWS(ID, NAME, SHORT_DESC, LONG_DESC, YEAR, RECOMMENDED_AGE, CATEGORY_ID) VALUES 
	(1, 'Juego de tronos', 'Descripción corta', 'Descripción larga', '2012', 16, 3), 
	(2, 'American horror Story', NULL, NULL, '2010', 16, 1), 
	(3, 'Big Bang', NULL, NULL, '2008', 7, 2);
    
INSERT INTO SEASONS(ID, NUMBER, NAME, TV_SHOW_ID) VALUES 
	(1, 1, 'One', 1), 
	(2, 2, 'Two', 1), 
	(3, 1, 'One', 2), 
	(4, 2, 'Two', 2), 
	(5, 3, 'Three', 2), 
	(6, 1, 'One', 3);

INSERT INTO CHAPTERS(ID, NUMBER, NAME, DURATION, SEASON_ID) VALUES 
	(1, 1, 'Chapter 1', 43, 1), 
	(2, 2, 'Chapter 2', 45, 1), 
	(3, 3, 'Chapter 3', 44, 1),
	(4, 1, 'Chapter 0', 50, 2);

INSERT INTO CATEGORY_TVSHOWS(ID, TVSHOW_ID, CATEGORY_ID) VALUES
    (1,1,1),
    (2,1,2),
    (3,2,1),
    (4,2,3);
INSERT INTO ACTORS(ID, NAME,AGE,ACTOR_ID) VALUES
    (1,'Pepe',18,1),
    (2,'Carlos',25,2),
    (3,'Antonio',16,3);
INSERT INTO ACTORS_TVSHOWS(ID, TVSHOW_ID, ACTOR_ID) VALUES
    (1,1,1),
    (2,2,2),
    (3,3,3);