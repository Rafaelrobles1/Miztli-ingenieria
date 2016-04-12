--PROCEDIMIENTO ALAMACENADO
CREATE OR REPLACE FUNCTION insertar_usuario(
nombre_nw varchar(20), 
apellidoP_nw varchar(20), 
apellidoM_nw varchar(20),
correo_nw varchar(30),
telefono_nw varchar(10),
foto_nw bytea(),
contrasenya_nw varchar(),
facultad_nw varchar(50),
carrera_nw varchar(30),
)
RETURNS varchar(20)
AS
$$
DECLARE estatus_insercion varchar(35);
BEGIN
IF( facultad_nw = null )
 THEN 
   INSERT INTO "Prestador"
   (nombre, apellido_paterno, apellido_materno, correo, telefono, contrasenya, facultad, carrera)
   VALUES 
   (nombre_nw, apellidoP_nw, apellidoM_nw, correo_nw, telefono_nw, md5(contrasenya_nw))
    estatus_insercion ‘Insercion exitosa de prestador‘;
ELSE
  INSERT INTO "Estudiante"
   (nombre, apellido_paterno, apellido_materno, correo, telefono, contrasenya, facultad, carrera)
   VALUES 
   (nombre_nw, apellidoP_nw, apellidoM_nw, correo_nw, telefono_nw, md5(contrasenya_nw), facultad_nw, carrera_nw)
    estatus_insercion ‘Insercion exitosa de estudiante‘;    
END IF;
RETURN estatus_insercion;
END;
$$
LANGUAGE'plpgsql';