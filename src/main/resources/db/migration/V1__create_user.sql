CREATE TABLE IF NOT EXISTS public.users
(
    user_id integer NOT NULL,
    user_name character varying COLLATE pg_catalog."default",
    user_surname character varying COLLATE pg_catalog."default",
    user_gender character varying COLLATE pg_catalog."default",
    city character varying COLLATE pg_catalog."default",
    registration_date time without time zone,
    CONSTRAINT users_pkey PRIMARY KEY (user_id)
)