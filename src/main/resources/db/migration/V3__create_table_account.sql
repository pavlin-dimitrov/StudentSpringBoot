DROP TABLE IF EXISTS student;

CREATE TABLE IF NOT EXISTS student
(
    id bigint NOT NULL,
    dob character varying(255) COLLATE pg_catalog."default",
    exam character varying(55) COLLATE pg_catalog."default",
    email character varying(255) COLLATE pg_catalog."default",
    name character varying(255) COLLATE pg_catalog."default" NOT NULL,
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