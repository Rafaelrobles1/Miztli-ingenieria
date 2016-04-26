

INSERT INTO "estudiante"
(nombre, apellido_paterno, apellido_materno, correo, telefono, contrasenya, facultad, carrera)
VALUES
('Aaron', 'Guerrero', 'Hernandez', 'aaron@email.com', '5511111111', md5('aaron'), 'Ciencias', 'ciencias de la computacion'),
('Miguel', 'Piña', 'Algo', 'miguel@email.com', '5522222222', md5('miguel'), 'Ciencias', 'ciencias de la computacion'),
('Edson', 'Servin', 'Mote', 'edson@email.com', '5533333333', md5('edson'), 'Ciencias', 'ciencias de la computacion'),
('Rafael', 'Robles', 'Rios', 'rafael@email.com', '5544444444', md5('rafa'), 'Ciencias', 'ciencias de la computacion'),
('juan', 'Barrera', 'Barrera', 'juan@email.com', '5555555555', md5('juan'), 'Contaduaria', 'Informatica');


INSERT INTO "prestador"
(nombre, apellido_paterno, apellido_materno, correo, telefono, contrasenya, cuartos_disponibles)
VALUES
('Maurico', 'Garcia', 'Perez', 'mauricio@email.com', '5566666666', md5('mauricio'), 2),
('Oscar', 'Roldan', 'Ares', 'oscar@email.com', '5577777777', md5('oscar'), 1),
('Maria', 'Arcos', 'Davila', 'maria@email.com', '5588888888', md5('maria'), 1),
('Edgar Moises', 'Acevedo', 'Morales', 'edgar@email.com', '5599999999', md5('edgar'), 1),
('Fernanda', 'Hernandez', 'Sanchez', 'fernanda@email.com', '5500000000', md5('fernanda'), 1);


INSERT INTO "direccion_usuario"
(pais_u, estado_u, delegacion_u, codigo_postal_u, calle_u, colonia_u)
VALUES 
('México', 'Ciudad de México', 'Gustavo A. Madero', 07452, 'Av Siempre viva', 'Coyol'),
('México', 'Morelos', 'Cuautla', 07982, 'Av Lazaro Cardenas', 'Tamales'),
('Brasil', 'Rio de Janeiro', 'Cocoas', 12486, 'Calzada de la arena', 'Pambolera'),
('España', 'Ciudad de México', 'Gustavo A. Madero', 07452, 'Av Siempre viva', 'contry'),
('México', 'Ciudad de México', 'Benito Juarez', 07954, 'Cuautemoc', 'uxmal'),
('México', 'Veracruz', 'Tecolutla', 16874, 'Canal', 'Palapa'),
('Mexico', 'Ciudad de México', 'Coyoacan', 08275, 'Av Aztecas', 'Popocatepetl'),
('México', 'Ciudad de México', 'Coyoacan', 08275, 'Cuautemoc', 'Cerrada One'),
('Mexico', 'Ciudad de México', 'Coyoacan', 08275, 'Eje 10', 'Copal'),
('Mexico', 'Ciudad de México', 'Coyoacan', 08275, 'Av iman', 'Fraccionamiento 01');


INSERT INTO "cuarto"
(precio, observaciones_c)
VALUES
(1500, 'Cuarto con luz, agua y gas'),
(1600, 'Cuarto Amplico con luz, agua, gas e internet'),
(1800, 'Cuarto individual Amplico con luz, agua y gas'),
(2500, 'Cuarto Amplico con todos los servicios '),
(1200, 'Cuarto Amplico con luz, agua y gas'),
(2000, 'Cuarto compartido con luz, agua y gas');


INSERT INTO "direccion_cuarto"
(delegacion_c, codigo_postal_c, colonia_c, calle_c)
VALUES
('Coyoacan', 08275, 'Popocatepetl', 'Av Aztecas'),
('Tlalpan', 08289, 'La joya', 'Av Insurgentes'),
('Coyoacan', 08275, 'Santa Ursula', 'Av Aztecas'),
('Coyoacan', 08275, 'Copilco', 'Cerro del agua'),
('Coyoacan', 08275, 'Santo Domingo', 'Ecuinapa');


INSERT INTO "contrato"
(fecha_inicio, fecha_fin, id_cuarto)
VALUES 
('2016/01/15', '2016/03/15', 1),
('2015/12/01', '2015/01/01', 2),
('2015/12/25', '2016/03/25', 3);


INSERT INTO "evaluacion"
(cumplimiento_contrato, calificacion, observaciones_e, recomentar, id_usuario)
VALUES
('T', 1,'El propietario es un ogro', 'F', 1),
('F', 5,'Sin comentarios negativos', 'T', 2),
('T', 4,'Excelentes servicios', 'T', 6),
('T', 5,'Lo volveria a rentar', 'T', 7);


---SEGUNDA PARTE

INSERT INTO "tiene_contrato_u"
(contrato, estudiante, prestador)
VALUES (1,1,6),(2,2,7),(3,3,8);


INSERT INTO "tiene_cuarto"
(cuarto, prestador)
VALUES (1,6),(2,6),(3,7),(4,8),(5,9),(6,10);


INSERT INTO "tiene_direccion_c"
(cuarto, direccion_c)
VALUES
(1,1),(2,1),(3,2),(4,3),(5,4),(6,5);


INSERT INTO "tiene_evaluacion_c"
(evaluacion, contrato)
VALUES (1,1),(2,1),(3,2),(4,2);


INSERT INTO "tiene_direccion_u"
(usuario, direccion)
VALUES (1,1),(2,2),(3,3),(4,4),(5,5),(6,6),(7,7),(8,8),(9,9),(10,10);
