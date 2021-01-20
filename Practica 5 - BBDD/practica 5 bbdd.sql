--
-- PostgreSQL database dump
--

-- Dumped from database version 13.1
-- Dumped by pg_dump version 13.1

-- Started on 2021-01-13 22:38:05

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE "practica 5 programacion aplicada";
--
-- TOC entry 3017 (class 1262 OID 16405)
-- Name: practica 5 programacion aplicada; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE "practica 5 programacion aplicada" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Spanish_Ecuador.1252';


ALTER DATABASE "practica 5 programacion aplicada" OWNER TO postgres;

\connect -reuse-previous=on "dbname='practica 5 programacion aplicada'"

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_table_access_method = heap;

--
-- TOC entry 201 (class 1259 OID 16411)
-- Name: carrera; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.carrera (
    id integer NOT NULL,
    nombre character varying(40)
);


ALTER TABLE public.carrera OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 16416)
-- Name: equipo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.equipo (
    id integer NOT NULL,
    nombre character varying(30),
    id_jugador_fk integer,
    id_carrera_fk integer
);


ALTER TABLE public.equipo OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 16406)
-- Name: jugador; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.jugador (
    id integer NOT NULL,
    nombre character varying(40),
    apellido character varying(40),
    posicion character varying(20),
    numero_camiseta integer,
    fecha_nacimiento date,
    capitan boolean
);


ALTER TABLE public.jugador OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 16431)
-- Name: persona; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.persona (
    cedula character varying(10) NOT NULL,
    nombres character varying(60) NOT NULL,
    direccion character varying(120),
    fecha_nacimiento date NOT NULL,
    cargas_familiares integer,
    salario numeric(10,2),
    apellido character varying(60)
);


ALTER TABLE public.persona OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 16436)
-- Name: persona_telefono; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.persona_telefono (
    codigo integer NOT NULL,
    cedula_fk character varying(10),
    tipo_telefono character varying(12),
    numero_telefono character varying(24)
);


ALTER TABLE public.persona_telefono OWNER TO postgres;

--
-- TOC entry 3008 (class 0 OID 16411)
-- Dependencies: 201
-- Data for Name: carrera; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.carrera (id, nombre) VALUES (1, 'Ingenieria en Computacion');


--
-- TOC entry 3009 (class 0 OID 16416)
-- Dependencies: 202
-- Data for Name: equipo; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.equipo (id, nombre, id_jugador_fk, id_carrera_fk) VALUES (1, 'Juventus', 1, 1);


--
-- TOC entry 3007 (class 0 OID 16406)
-- Dependencies: 200
-- Data for Name: jugador; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.jugador (id, nombre, apellido, posicion, numero_camiseta, fecha_nacimiento, capitan) VALUES (1, 'Cristiano', 'Ronaldo', 'Extremo derecho', 7, '1985-02-05', true);


--
-- TOC entry 3010 (class 0 OID 16431)
-- Dependencies: 203
-- Data for Name: persona; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.persona (cedula, nombres, direccion, fecha_nacimiento, cargas_familiares, salario, apellido) VALUES ('0106836976', 'ADOLFO SEBASTIAN', 'Remigio Tamariz', '2000-07-08', 0, 1000.00, 'JARA');
INSERT INTO public.persona (cedula, nombres, direccion, fecha_nacimiento, cargas_familiares, salario, apellido) VALUES ('0106836987', 'JUAN SEBASTIAN', 'El valle', '1993-08-11', 1, 2000.00, 'RIVERA');
INSERT INTO public.persona (cedula, nombres, direccion, fecha_nacimiento, cargas_familiares, salario, apellido) VALUES ('0105536987', 'MARTIN', 'Yunguilla', '1977-12-11', 4, 1500.63, 'MARTINEZ');
INSERT INTO public.persona (cedula, nombres, direccion, fecha_nacimiento, cargas_familiares, salario, apellido) VALUES ('0106898520', 'MATEO', 'Av. Loja', '1996-09-26', 2, 1254.36, 'SALGADO');
INSERT INTO public.persona (cedula, nombres, direccion, fecha_nacimiento, cargas_familiares, salario, apellido) VALUES ('0106253422', 'JUAN JESUS', '10 de Agosto', '2003-05-31', 0, 1000.00, 'LOYA');
INSERT INTO public.persona (cedula, nombres, direccion, fecha_nacimiento, cargas_familiares, salario, apellido) VALUES ('0106801222', 'GABRIELA', 'Americas', '2003-03-21', 0, 1000.00, 'MALDONADO');
INSERT INTO public.persona (cedula, nombres, direccion, fecha_nacimiento, cargas_familiares, salario, apellido) VALUES ('0106803698', 'PAOLA', 'Solano', '1995-07-21', 0, 1000.00, 'HIDALGO');
INSERT INTO public.persona (cedula, nombres, direccion, fecha_nacimiento, cargas_familiares, salario, apellido) VALUES ('0106815488', 'AGUSTINA', 'Puertas del sol', '2005-01-16', 0, 1000.00, 'VAZQUEZ');
INSERT INTO public.persona (cedula, nombres, direccion, fecha_nacimiento, cargas_familiares, salario, apellido) VALUES ('0106897410', 'ALEJANDRA', 'Vista linda', '1998-06-20', 1, 1000.00, 'CORDERO');


--
-- TOC entry 3011 (class 0 OID 16436)
-- Dependencies: 204
-- Data for Name: persona_telefono; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.persona_telefono (codigo, cedula_fk, tipo_telefono, numero_telefono) VALUES (1, '0106836976', 'Celular', '0963204010');
INSERT INTO public.persona_telefono (codigo, cedula_fk, tipo_telefono, numero_telefono) VALUES (3, '0105536987', 'Convencional', '2863512');
INSERT INTO public.persona_telefono (codigo, cedula_fk, tipo_telefono, numero_telefono) VALUES (2, '0106836987', 'Convencional', '2455629');
INSERT INTO public.persona_telefono (codigo, cedula_fk, tipo_telefono, numero_telefono) VALUES (4, '0106898520', 'Celular', '0965413248');
INSERT INTO public.persona_telefono (codigo, cedula_fk, tipo_telefono, numero_telefono) VALUES (5, '0106253422', 'Celular', '09654135888');
INSERT INTO public.persona_telefono (codigo, cedula_fk, tipo_telefono, numero_telefono) VALUES (7, '0106803698', 'Convencional', '2520147');
INSERT INTO public.persona_telefono (codigo, cedula_fk, tipo_telefono, numero_telefono) VALUES (6, '0106801222', 'Convencional', '2896321');
INSERT INTO public.persona_telefono (codigo, cedula_fk, tipo_telefono, numero_telefono) VALUES (8, '0106815488', 'Celular', '0998841165');
INSERT INTO public.persona_telefono (codigo, cedula_fk, tipo_telefono, numero_telefono) VALUES (9, '0106897410', 'Celular', '09652548741');


--
-- TOC entry 2867 (class 2606 OID 16415)
-- Name: carrera carrera_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.carrera
    ADD CONSTRAINT carrera_pkey PRIMARY KEY (id);


--
-- TOC entry 2871 (class 2606 OID 16435)
-- Name: persona cedula_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.persona
    ADD CONSTRAINT cedula_pk PRIMARY KEY (cedula);


--
-- TOC entry 2873 (class 2606 OID 16440)
-- Name: persona_telefono codigo_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.persona_telefono
    ADD CONSTRAINT codigo_pk PRIMARY KEY (codigo);


--
-- TOC entry 2869 (class 2606 OID 16420)
-- Name: equipo equipo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.equipo
    ADD CONSTRAINT equipo_pkey PRIMARY KEY (id);


--
-- TOC entry 2865 (class 2606 OID 16410)
-- Name: jugador jugador_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.jugador
    ADD CONSTRAINT jugador_pkey PRIMARY KEY (id);


--
-- TOC entry 2876 (class 2606 OID 16441)
-- Name: persona_telefono fk_cedula; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.persona_telefono
    ADD CONSTRAINT fk_cedula FOREIGN KEY (cedula_fk) REFERENCES public.persona(cedula);


--
-- TOC entry 2875 (class 2606 OID 16426)
-- Name: equipo fk_id_carrera; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.equipo
    ADD CONSTRAINT fk_id_carrera FOREIGN KEY (id_carrera_fk) REFERENCES public.carrera(id);


--
-- TOC entry 2874 (class 2606 OID 16421)
-- Name: equipo fk_id_jugador; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.equipo
    ADD CONSTRAINT fk_id_jugador FOREIGN KEY (id_jugador_fk) REFERENCES public.jugador(id);


-- Completed on 2021-01-13 22:38:06

--
-- PostgreSQL database dump complete
--

