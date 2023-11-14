CREATE TABLE IF NOT EXISTS public.content_type
(
    content_type_id
    serial,
    content_type_name
    character
    varying
    COLLATE
    pg_catalog
    .
    "default",
    CONSTRAINT
    content_type_pkey
    PRIMARY
    KEY
(
    content_type_id
)
    );

INSERT INTO public.content_type(content_type_name)
VALUES ('bakery'),
       ('WC');

CREATE TABLE IF NOT EXISTS public.content
(
    content_id
    serial,
    password
    character
    varying
    COLLATE
    pg_catalog
    .
    "default",
    content_type_id
    integer,
    CONSTRAINT
    content_pkey
    PRIMARY
    KEY
(
    content_id
),
    CONSTRAINT fk_content_type_id FOREIGN KEY
(
    content_type_id
)
    REFERENCES public.content_type
(
    content_type_id
) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID
    )