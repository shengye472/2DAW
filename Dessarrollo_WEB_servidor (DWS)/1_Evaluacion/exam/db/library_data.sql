use library;

DELETE FROM books;
ALTER TABLE books AUTO_INCREMENT = 1;
DELETE FROM users;
ALTER TABLE users AUTO_INCREMENT = 1;
DELETE FROM orders;
ALTER TABLE orders AUTO_INCREMENT = 1;
DELETE FROM orders_details;
ALTER TABLE orders_details AUTO_INCREMENT = 1;

-- Libros
INSERT INTO books (isbn, title_es, title_en, synopsis_es, synopsis_en, price, cover) VALUES
                                                                                         ('9788433920423', 'La conjura de los necios', 'A Confederacy of Dunces', 'El protagonista de esta novela es uno de los personajes más memorables de la literatura norteamericana: Ignatius Reilly --una mezcla de Oliver Hardy delirante, Don Quijote adiposo y santo Tomás de Aquino perverso, reunidos en una persona--, que a los treinta años aún vive con su estrafalaria madre, está ocupado en escribir una extensa y demoledora denuncia contra nuestro siglo, tan carente de "teología geometría" como de "decencia y buen gusto"; un alegato desquiciado contra una sociedad desquiciada. Por una inesperada necesidad de dinero, se ve "catapultado en la fiebre de la existencia contemporánea", fiebre a la que Ignatius añadirá unos cuantos grandes más.', 'The protagonist of this novel is one of the most memorable characters in American literature: Ignatius Reilly—a mix of delirious Oliver Hardy, adipose Don Quixote, and perverse Saint Thomas Aquinas, all rolled into one—who at thirty still lives with his eccentric mother, occupied in writing an extensive and devastating indictment against our century, as lacking in "theology geometry" as in "decency and good taste"; a deranged plea against a deranged society. Due to an unexpected need for money, he finds himself "catapulted into the fever of contemporary existence", a fever to which Ignatius will add a few more degrees.', 13.20, 'necios.jpeg'),

('9788426418197', 'El nombre de la rosa', 'The Name of the Rose', 'Valiéndose de las características de la novela gótica, la crónica medieval y la novela policíaca, El nombre de la rosa narra las investigaciones detectivescas que realiza el fraile franciscano Guillermo de Baskerville para esclarecer los crímenes cometidos en una abadía benedictina en el año 1327. Le ayudará en su labor el novicio Adso, un joven que se enfrenta por primera vez a las realidades de la vida situadas más allá de las puertas del convento.', 'Drawing on the characteristics of the gothic novel, the medieval chronicle, and the detective novel, The Name of the Rose narrates the detective investigations carried out by the Franciscan friar William of Baskerville to elucidate the crimes committed in a Benedictine abbey in the year 1327. He will be aided in his work by the novice Adso, a young man who is confronting for the first time the realities of life beyond the convent doors.', 12.30, 'nombreRosa.jpeg'),

('9786074213485', 'La insorportable levedad del ser', 'The Unbearable Lightness of Being', 'La insoportable levedad del ser es una novela del escritor checo Milan Kundera, publicada en 1984. Ambientada en Praga durante 1968, La insoportable levedad del ser trata de un hombre y sus dudas existenciales en torno a la vida en pareja, convertidas en conflictos sexuales y afectivos.', 'The Unbearable Lightness of Being is a novel by Czech writer Milan Kundera, published in 1984. Set in Prague during 1968, The Unbearable Lightness of Being revolves around a man and his existential doubts about life as a couple, which turn into sexual and emotional conflicts.', 18.05, 'levedad.jpeg'),

('9788466338141', 'La isla del día de antes', 'The Island of the Day Before', 'En el verano de 1963 un náufrago, Roberto de la Grive, llega a una nave abandonada en los Mares del Sur donde encuentra sólo animales desconocidos y máquinas extrañas. Frente a la nave hay una isla de ensueño, tan cercana como inalcanzable. Confinado en este exiguo espacio y perdido en el vasto mar, Roberto nos pone al corriente sobre su pasado a través de las cartas que escribe a una enigmática «Señora». Pero Roberto ha viajado hasta allí con una misión muy concreta: resolver el misterio por el cual pugnan las nuevas potencias de la época, el secreto del Punto Fijo.', 'In the summer of 1963, a castaway, Roberto de la Grive, arrives at an abandoned ship in the South Seas where he finds only unknown animals and strange machines. In front of the ship there is a dream island, as close as it is unreachable. Confined in this small space and lost in the vast sea, Roberto updates us on his past through the letters he writes to an enigmatic "Lady". But Roberto has traveled there with a very specific mission: to solve the mystery for which the new powers of the time are struggling, the secret of the Fixed Point.', 14.20, 'islaDiaAntes.jpeg'),

('9788448022440', 'Buenos presagios', 'Good Omens', 'Según Las Buenas y Acertadas profecías de Agnes la Chalada, Bruja (el único libro fiable de profecías, escrito en 1655, antes de que ella explotara), el fin del mundo tendrá lugar el próximo sábado. Los ejércitos del Bien y del Mal se están agrupando, la Atlántida está resurgiendo, llueven sapos y los ánimos están algo alterados así que... todo parece ajustarse al Plan Divino. De no ser por un ángel quisquilloso y un demonio buscavidas que han vivido a costa de los mortales desde el comienzo de los tiempos y que no están dispuestos a aceptar tan fácilmente eso del «Fin de la civilización tal y como la conocemos». Y... ¡vaya por Dios! ¡Parece que alguien ha hecho desaparecer al Anticristo!', 'According to The Nice and Accurate Prophecies of Agnes Nutter, Witch (the only reliable prophecy book, written in 1655, before she exploded), the end of the world will take place next Saturday. The armies of Good and Evil are gathering, Atlantis is rising, toads are raining down, and spirits are somewhat agitated, so... everything seems to fit the Divine Plan. Except for a fastidious angel and a scrounging demon who have lived at the expense of mortals since the beginning of time and who are not willing to accept so easily this "End of civilization as we know it". And... by God! It seems that someone has made the Antichrist disappear!', 9.45, 'buenosPresagios.jpeg'),

('9788499085944', 'El país del fin del mundo', 'The Last Continent', 'Este no es un libro sobre Australia, sino sobre un país totalmente distinto que,sin embargo y por pura casualidad, en ciertos aspectos resulta un poco... australiano. Se trata de un territorio seco y caluroso en el que todo lo que no es ponzoñoso es venenoso. Pero, aun así, es un bonito lugar, y está amenazado de muerte. ¿Conseguirá salvarlo el inepto mago Rincewind?', 'This is not a book about Australia, but about a completely different country that, nevertheless and by pure chance, in certain aspects turns out to be a bit... Australian. It is a dry and hot territory where everything that is not poisonous is venomous. But, even so, it is a beautiful place, and it is threatened with death. Will the inept wizard Rincewind be able to save it?', 9.45, 'paisFinMundo.jpeg'),

('9788499086460', 'Mort', 'Mort', 'Mort es una novela de fantasía escrita por Terry Pratchett y publicada en 1987. Es la cuarta entrega de la saga del Mundodisco. En ella, la Muerte, presente en todas las novelas de la saga, desempeña por primera vez un papel protagonista. Ha sido adaptada como obra de teatro.', 'Mort is a fantasy novel written by Terry Pratchett and published in 1987. It is the fourth installment of the Discworld series. In it, Death, present in all the novels of the series, plays a leading role for the first time. It has been adapted as a play.', 10.40, 'mort.jpeg'),

('9788433927996', 'Guía del autoestopista galáctico', 'The Hitchhiker\'s Guide to the Galaxy', 'Un jueves a la hora de comer, la Tierra es inesperadamente demolida para poder construir una nueva autopista hiperespacial. Arthur Dent, un tipo de lo más corriente que esa misma mañana ha visto cómo echaban abajo su propia casa, considera que eso supera lo que una persona puede soportar. Pero, desgraciadamente, el fin de semana no ha hecho más que empezar, y la galaxia es un lugar extraño y sorprendente. Arthur huirá de la Tierra junto con un amigo suyo, Ford Prefect, que resultará ser un extraterrestre emparentado con Zaphod Beeblebrox, un pirata esquizoide de dos cabezas que fue Presidente de la Galaxia, en cuya nave Arthur conocerá al resto de personajes que lo acompañarán a lo largo de su periplo espacial: un androide paranoide y una terrícola que, como él, ha logrado escapar. Gracias a esta ineludible aventura, Dent descubrirá muchas cosas acerca de la existencia, pero, tal como aconseja la Guía del autoestopista galáctico, que no cunda el pánico.', 'On a Thursday lunchtime, the Earth is unexpectedly demolished to make way for a new hyperspace bypass. Arthur Dent, a rather ordinary guy who that same morning saw his own house being demolished, considers that to be beyond what a person can endure. But unfortunately, the weekend has only just begun, and the galaxy is a strange and surprising place. Arthur will flee Earth along with his friend Ford Prefect, who turns out to be an extraterrestrial related to Zaphod Beeblebrox, a two-headed schizophrenic pirate who was President of the Galaxy, on whose ship Arthur will meet the rest of the characters who will accompany him throughout his space journey: a paranoid android and a Earthling who, like him, has managed to escape. Thanks to this unavoidable adventure, Dent will discover many things about existence, but, as The Hitchhiker\'s Guide to the Galaxy advises, don\'t panic.', 12.25, 'guiaAutoestopista.jpeg'),

('9788499189390', 'Neverwhere', 'Neverwhere', 'En el subsuelo de Londres, como debajo de cada gran ciudad, existe un mundo desconocido e invisible, plagado de extraños seres, en el que sobrevivir depende de abrir las puertas adecuadas... Hay mundos bajo tus pies, espías bajo las escaleras y formas que esperan al otro lado de los portales, que sólo has atisbado en tus sueños.', 'In the underground of London, as beneath every great city, there exists an unknown and invisible world, plagued by strange beings, where survival depends on opening the right doors... There are worlds under your feet, spies under the stairs, and shapes waiting on the other side of the portals, which you have only glimpsed in your dreams.', 10.40, 'neverwhere.jpeg'),

('9788415729204', 'American Gods', 'American Gods', 'Dioses antiguos, héroes mitológicos y figuras legendarias se dan cita en la obra narrativa más importante del extraordinario Neil Gaiman. Días antes de salir de prisión, la mujer de Sombra, Laura, muere en un misterioso accidente de coche. Aturdido por el dolor, emprende el regreso a casa. En el avión, se encontrará con el enigmático señor Miércoles, que dice ser un refugiado de una guerra antigua, un dios y también el rey de América. Juntos se embarcan en un viaje extraño a través de los Estados Unidos, mientras una tormenta de dimensiones épicas amenaza con desencadenarse.', 'Ancient gods, mythological heroes, and legendary figures converge in the most important narrative work of the extraordinary Neil Gaiman. Days before leaving prison, Shadow\'s wife, Laura, dies in a mysterious car accident. Stunned by grief, he begins his journey back home. On the plane, he meets the enigmatic Mr. Wednesday, who claims to be a refugee from an ancient war, a god, and also the king of America. Together they embark on a strange journey through the United States, while a storm of epic proportions threatens to unleash.', 20.80, 'americanGods.jpeg'),

('9788496173729', 'La espada del destino', 'The Sword of Destiny', 'La vida de un brujo cazador de monstruos no es fácil. Tan pronto puede uno tener que meterse hasta el cuello en un estercolero para eliminar a la bestia carroñera que amenaza la ciudad, intentando no atrapar una infección incurable, como puede encontrarse unido a la cacería de uno de los últimos dragones, en la que la cuestión no es si los cazadores conseguirán matar a la pobre bestia, sino qué pasará cuando tengan que repartirse el botín. Magos, príncipes, estarostas, voievodas, druidas, vexlings, dríadas, juglares y criaturas de todo pelaje pueblan esta tierra, enzarzados en conflictos de supervivencia, codicia y amor, y entre ellos avanza, solitario, el brujo Geralt de Rivia.', 'The life of a monster-hunting witcher is not easy. One moment, you may have to wade neck-deep into a dung heap to eliminate the scavenging beast threatening the city, trying not to catch an incurable infection, while the next you may find yourself involved in the hunt for one of the last dragons, where the question is not whether the hunters will manage to kill the poor beast, but what will happen when they have to divide the loot. Wizards, princes, chieftains, warlords, druids, vexlings, dryads, minstrels, and creatures of all kinds populate this land, embroiled in conflicts of survival, greed, and love, and among them advances, solitary, the witcher Geralt of Rivia.', 22.75, 'espadaDestino.jpeg');


-- Usuarios
-- username = admin, password = admin
-- username = user1, password = user1
-- username = user2, password = user2
INSERT INTO users(username, password, email, first_name, surname, address, admin)
VALUES
	(
		'admin', 
    		'$2a$10$zAJMtKY7UbnmeXH2kXMfp.xpq99PWjafw0ZwDOzYuAtp2hT2bNJVG',
    		'admin@bookstore.com', 
    		'Juan', 
    		'González López', 
    		'Calle Admin', 
    		true
	),
   	(
	 	'user1', 
	    	'$2a$10$cKSdPQGs/yPIlrXSFDkIDuMLx6ylOnGSxmzSOo6nEOq7waE/unv5W',
	    	'user1@bookstore.com',
	    	'María', 
	    	'García Pérez', 
	    	'Calle User1', 
	    	false
	),
	(    
	    	'user2',
    		'$2a$10$S/PIuHAFYLpoPx8v7gmj/.HAZFnew8KKXLCwFZNGwx3yMK.gBu5YO',
    		'user2@bookstore.com', 
    		'Ana', 
    		'Martínez Sánchez', 
    		'Calle User2', 
    		false
	);
    
-- Pedidos

INSERT INTO orders(user_id, order_date, delivery_date, total, status)
VALUES 
	(2, NULL, NULL, NULL, 0),
	(3, NULL, NULL, NULL, 0),
	(2, '2023-11-30', '2023-12-05', 85.50, 4),
	(2, '2023-02-12', '2023-02-15', 13.20, 4),
	(3, '2024-03-20', '2024-03-25', 61.40, 4),
	(3, '2024-03-25', NULL, 49.20, 3),
	(2, '2024-03-29', NULL, 138.80, 2),
	(3, '2024-04-01', NULL, 129.50, 1);
	
INSERT INTO orders_details(order_id, book_id, quantity, price)
VALUES
	(3, 2, 2, 12.30),
	(3, 4, 3, 20.30),
	(4, 1, 1, 13.20),
	(5, 3, 1, 11.50),
	(5, 4, 2, 20.30),
	(5, 5, 1, 9.30),
	(6, 2, 4, 12.30),
	(7, 1, 3, 11.20),
	(7, 3, 2, 52.60),
	(8, 1, 5, 13.20),
	(8, 3, 2, 11.50),
	(8, 4, 3, 10.40),
	(8, 5, 1, 9.30);

