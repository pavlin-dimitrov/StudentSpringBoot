DROP SEQUENCE IF EXISTS public.student_sequence;
CREATE SEQUENCE IF NOT EXISTS public.student_sequence
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.student_sequence
    OWNER TO postgres;

DROP SEQUENCE IF EXISTS public.account_sequence;
CREATE SEQUENCE IF NOT EXISTS public.account_sequence
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.account_sequence
    OWNER TO postgres;

DROP TABLE IF EXISTS student;

CREATE TABLE IF NOT EXISTS student
(
    id bigint NOT NULL,
    dob character varying(255) COLLATE pg_catalog."default",
    exam character varying(55) COLLATE pg_catalog."default",
    email character varying(255) COLLATE pg_catalog."default",
    name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    created_at timestamp,
    created_by character varying(255),
    last_modified_at timestamp,
    last_modified_by character varying(255),
    CONSTRAINT student_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.student
    OWNER to postgres;

DROP TABLE IF EXISTS account;

CREATE TABLE IF NOT EXISTS account
(
    id bigint NOT NULL,
    name character varying(255) COLLATE pg_catalog."default",
    email character varying(255) COLLATE pg_catalog."default",
    password character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT acccount_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.account
    OWNER to postgres;

INSERT INTO student(id, dob, exam, email, name) VALUES (nextval('student_sequence'), '1989-02-24', 'Math', 'pavlin@abv.bg' ,'Pavlin Dimitrov');
INSERT INTO student(id, dob, exam, email, name) VALUES (nextval('student_sequence'), '1992-06-27', 'Drama', 'martin@abv.bg' ,'Martin Dimitrov');
INSERT INTO account(id, name, email, password) VALUES (nextval('account_sequence'), 'Kalin Konov', 'konov@abv.bg', '12345678');
INSERT INTO account(id, name, email, password) VALUES (nextval('account_sequence'), 'J. Adams', 'adams@gmail.com', 'dramaQueen');