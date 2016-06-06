--Crear base de datos 

CREATE TABLE "usuario"(
  id_usuario serial NOT NULL,
  nombre character varying(20) NOT NULL,
  apellido_paterno character varying(20) NOT NULL,
  apellido_materno character varying(20) NOT NULL,
  correo character varying(30) NOT NULL,
  telefono character varying(10) NOT NULL,
  foto_u bytea,
  contrasenya character varying NOT NULL,
  CONSTRAINT "usuario_pkey" PRIMARY KEY (id_usuario)
);

 CREATE TABLE "estudiante"(
-- Inherited from table "usuario":  id_usuario integer NOT NULL DEFAULT nextval('"Usuario_id_usuario_seq"'::regclass),
-- Inherited from table "usuario":  nombre character varying(20) NOT NULL,
-- Inherited from table "usuario":  apellido_paterno character varying(20) NOT NULL,
-- Inherited from table "usuario":  apellido_materno character varying(20) NOT NULL,
-- Inherited from table "usuario":  correo character varying(30) NOT NULL,
-- Inherited from table "usuario":  telefono character varying(10) NOT NULL,
-- Inherited from table "usuario":  foto_u bytea,
-- Inherited from table "usuario":  contrasenya character varying NOT NULL,
  facultad character varying(50) NOT NULL,
  carrera character varying(30) NOT NULL,
  CONSTRAINT "estudiante_pkey" PRIMARY KEY (id_usuario)
)INHERITS ("usuario");

CREATE TABLE "prestador"(
-- Inherited from table "usuario":  id_usuario integer NOT NULL DEFAULT nextval('"Usuario_id_usuario_seq"'::regclass),
-- Inherited from table "usuario":  nombre character varying(20) NOT NULL,
-- Inherited from table "usuario":  apellido_paterno character varying(20) NOT NULL,
-- Inherited from table "usuario":  apellido_materno character varying(20) NOT NULL,
-- Inherited from table "usuario":  correo character varying(30) NOT NULL,
-- Inherited from table "usuario":  telefono character varying(10) NOT NULL,
-- Inherited from table "usuario":  foto_u bytea,
-- Inherited from table "usuario":  contrasenya character varying NOT NULL,
  cuartos_disponibles integer NOT NULL,
  CONSTRAINT "prestador_pkey" PRIMARY KEY (id_usuario) 
)INHERITS ("usuario");

CREATE TABLE "direccion_usuario"(
  id_direccion_u serial NOT NULL,
  pais_u character varying(20) NOT NULL,
  estado_u character varying(20) NOT NULL,
  delegacion_u character varying(20) NOT NULL,
  codigo_postal_u integer NOT NULL,
  calle_u character varying(50) NOT NULL,
  colonia_u character varying(20) NOT NULL,
  CONSTRAINT "direccion_usuario_pkey" PRIMARY KEY (id_direccion_u)
);

CREATE TABLE "cuarto"(
  id_cuarto serial NOT NULL,
  precio integer NOT NULL,
  foto_c bytea,
  observaciones_c character varying(150) NOT NULL,
  CONSTRAINT "cuarto_pkey" PRIMARY KEY (id_cuarto)
);

CREATE TABLE "direccion_cuarto"(
  id_direccion_c serial NOT NULL,
  delegacion_c character varying(20) NOT NULL,
  codigo_postal_c integer NOT NULL,
  colonia_c character varying(20) NOT NULL,
  calle_c character varying(50) NOT NULL,
  link_ubicacion character varying,
  CONSTRAINT "direccion_cuarto_pkey" PRIMARY KEY (id_direccion_c)
); 
           
CREATE TABLE "contrato"(
  id_contrato serial NOT NULL,
  fecha_inicio date NOT NULL,
  fecha_fin date,
  id_cuarto integer NOT NULL,
  CONSTRAINT "contrato_pkey" PRIMARY KEY (id_contrato)
);

CREATE TABLE "evaluacion"(
  id_evaluacion serial NOT NULL,
  cumplimiento_contrato boolean NOT NULL,
  calificacion integer NOT NULL,
  observaciones_e character varying(150) NOT NULL,
  recomentar boolean NOT NULL,
  id_usuario integer NOT NULL,
  CONSTRAINT "evaluacion_pkey" PRIMARY KEY (id_evaluacion),
  CONSTRAINT rango_valido CHECK (calificacion >= 1 AND calificacion <= 5)
);

CREATE TABLE "tiene_contrato_u"(
  contrato integer NOT NULL,
  estudiante integer NOT NULL,
  prestador integer NOT NULL,
  CONSTRAINT tiene_contrato_u_pkey PRIMARY KEY (contrato)
);

CREATE TABLE "tiene_cuarto"(
  cuarto integer NOT NULL,
  prestador integer NOT NULL,
  CONSTRAINT tiene_cuarto_p_pkey PRIMARY KEY (cuarto)
);

CREATE TABLE "tiene_direccion_c"(
  cuarto integer NOT NULL,
  direccion_c integer NOT NULL,
  CONSTRAINT tiene_direccion_c_pkey PRIMARY KEY (cuarto)
);  

CREATE TABLE "tiene_evaluacion_c"(
  contrato integer NOT NULL,
  evaluacion integer NOT NULL,
  CONSTRAINT tiene_evaluacion_c_pkey PRIMARY KEY (evaluacion)
);

CREATE TABLE "tiene_direccion_u"(
  usuario integer NOT NULL,
  direccion integer NOT NULL,
  CONSTRAINT tiene_direccion_u_pkey PRIMARY KEY (usuario)
);
 





