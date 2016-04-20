--Crear base de datos 

CREATE TABLE "Usuario"(
  id_usuario serial NOT NULL,
  nombre character varying(20) NOT NULL,
  apellido_paterno character varying(20) NOT NULL,
  apellido_materno character varying(20) NOT NULL,
  correo character varying(30) NOT NULL,
  telefono character varying(10) NOT NULL,
  foto_u bytea,
  contrasenya character varying NOT NULL,
  id_direccion integer,
  CONSTRAINT "Usuario_pkey" PRIMARY KEY (id_usuario),
  CONSTRAINT "Usuario_id_direccion_fkey" FOREIGN KEY (id_direccion)
      REFERENCES "Direccion_u" (id_direccion_u) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "Usuario_correo_key" UNIQUE (correo),
  CONSTRAINT "Usuario_id_usuario_key" UNIQUE (id_usuario)
  );
 CREATE TABLE "Estudiante"(
-- Inherited from table "Usuario":  id_usuario integer NOT NULL DEFAULT nextval('"Usuario_id_usuario_seq"'::regclass),
-- Inherited from table "Usuario":  nombre character varying(20) NOT NULL,
-- Inherited from table "Usuario":  apellido_paterno character varying(20) NOT NULL,
-- Inherited from table "Usuario":  apellido_materno character varying(20) NOT NULL,
-- Inherited from table "Usuario":  correo character varying(30) NOT NULL,
-- Inherited from table "Usuario":  telefono character varying(10) NOT NULL,
-- Inherited from table "Usuario":  foto_u bytea,
-- Inherited from table "Usuario":  contrasenya character varying NOT NULL,
  facultad character varying(50) NOT NULL,
  carrera character varying(30) NOT NULL,
-- Inherited from table :  id_direccion integer,
  CONSTRAINT "Estudiante_pkey" PRIMARY KEY (id_usuario)
)INHERITS ("Usuario");
CREATE TABLE "Prestador"(
-- Inherited from table "Usuario":  id_usuario integer NOT NULL DEFAULT nextval('"Usuario_id_usuario_seq"'::regclass),
-- Inherited from table "Usuario":  nombre character varying(20) NOT NULL,
-- Inherited from table "Usuario":  apellido_paterno character varying(20) NOT NULL,
-- Inherited from table "Usuario":  apellido_materno character varying(20) NOT NULL,
-- Inherited from table "Usuario":  correo character varying(30) NOT NULL,
-- Inherited from table "Usuario":  telefono character varying(10) NOT NULL,
-- Inherited from table "Usuario":  foto_u bytea,
-- Inherited from table "Usuario":  contrasenya character varying NOT NULL,
  cuartos_disponibles integer NOT NULL,
-- Inherited from table :  id_direccion integer,
  CONSTRAINT "Prestador_pkey" PRIMARY KEY (id_usuario) 
)INHERITS ("Usuario");
CREATE TABLE "Direccion_u"(
  id_direccion_u serial NOT NULL,
  pais_u character varying(20) NOT NULL,
  estado_u character varying(20) NOT NULL,
  delegacion_u character varying(20) NOT NULL,
  codigo_postal_u integer NOT NULL,
  calle_u character varying(50) NOT NULL,
  colonia_u character varying(20) NOT NULL,
  CONSTRAINT "Direccion_u_pkey" PRIMARY KEY (id_direccion_u),
  CONSTRAINT "Direccion_u_id_direccion_u_key" UNIQUE (id_direccion_u)
);
CREATE TABLE "Cuarto"(
  id_cuarto serial NOT NULL,
  precio integer NOT NULL,
  foto_c bytea,
  observaciones_c character varying(150) NOT NULL,
  CONSTRAINT "Cuarto_pkey" PRIMARY KEY (id_cuarto),
  CONSTRAINT "Cuarto_id_cuarto_key" UNIQUE (id_cuarto)
);
CREATE TABLE "Direccion_c"(
  id_direccion_c serial NOT NULL,
  delegacion_c character varying(20) NOT NULL,
  codigo_postal_c integer NOT NULL,
  colonia_c character varying(20) NOT NULL,
  calle_c character varying(50) NOT NULL,
  link_ubicacion character varying,
  CONSTRAINT "Direccion_c_pkey" PRIMARY KEY (id_direccion_c),
  CONSTRAINT "Direccion_c_id_direccion_c_key" UNIQUE (id_direccion_c)
);            
CREATE TABLE "Contrato"(
  id_contrato serial NOT NULL,
  fecha_inicio date NOT NULL,
  fecha_fin date,
  id_cuarto integer NOT NULL,
  CONSTRAINT "Contrato_pkey" PRIMARY KEY (id_contrato),
  CONSTRAINT "Contrato_id_contrato_key" UNIQUE (id_contrato)
);
CREATE TABLE "Evaluacion"(
  id_evaluacion serial NOT NULL,
  cumplimiento_contrato boolean NOT NULL,
  calificacion integer NOT NULL,
  observaciones_e character varying(150) NOT NULL,
  recomentar boolean NOT NULL,
  id_usuario integer NOT NULL,
  CONSTRAINT "Evaluacion_pkey" PRIMARY KEY (id_evaluacion),
  CONSTRAINT "Evaluacion_id_evaluacion_key" UNIQUE (id_evaluacion),
  CONSTRAINT rango_valido CHECK (calificacion >= 1 AND calificacion <= 5)
);
CREATE TABLE "tiene_contrato_u"(
  contrato integer NOT NULL,
  estudiante integer NOT NULL,
  prestador integer NOT NULL,
  CONSTRAINT tiene_contrato_u_pkey PRIMARY KEY (contrato),
  CONSTRAINT tiene_contrato_u_estudiante_fkey FOREIGN KEY (estudiante)
      REFERENCES "Estudiante" (id_usuario) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT tiene_contrato_u_prestador_fkey FOREIGN KEY (prestador)
      REFERENCES "Prestador" (id_usuario) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT tiene_contrato_u_contrato_key UNIQUE (contrato),
  CONSTRAINT usuarios_distintos CHECK (prestador <> estudiante)
);
CREATE TABLE "tiene_cuarto_p"(
  cuarto integer NOT NULL,
  prestador integer NOT NULL,
  CONSTRAINT tiene_cuarto_p_pkey PRIMARY KEY (cuarto),
  CONSTRAINT tiene_cuarto_p_prestador_fkey FOREIGN KEY (prestador)
      REFERENCES "Prestador" (id_usuario) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);
CREATE TABLE "tiene_direccion_c"(
  cuarto integer NOT NULL,
  direccion_c integer NOT NULL,
  CONSTRAINT tiene_direccion_c_pkey PRIMARY KEY (cuarto),
  CONSTRAINT tiene_direccion_c_direccion_u_fkey FOREIGN KEY (direccion_c)
      REFERENCES "Direccion_c" (id_direccion_c) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);  
CREATE TABLE "tiene_evaluacion_c"(
  contrato integer NOT NULL,
  evaluacion integer NOT NULL,
  CONSTRAINT tiene_evaluacion_c_pkey PRIMARY KEY (evaluacion),
  CONSTRAINT tiene_evaluacion_c_contrato_fkey FOREIGN KEY (contrato)
      REFERENCES "Contrato" (id_contrato) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);
  






