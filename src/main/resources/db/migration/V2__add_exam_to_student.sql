DROP TABLE IF EXISTS student;

CREATE TABLE IF NOT EXISTS ${flyway:defaultSchema}.student
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