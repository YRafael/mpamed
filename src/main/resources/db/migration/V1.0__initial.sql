CREATE TABLE IF NOT EXISTS public.contraindications
(
    id bigint NOT NULL DEFAULT nextval('contraindications_id_seq'::regclass),
    full_name character varying(256) COLLATE pg_catalog."default",
    CONSTRAINT contraindications_pkey PRIMARY KEY (id)
)

CREATE TABLE IF NOT EXISTS public.med_ref_contraindications
(
    id bigint NOT NULL DEFAULT nextval('med_ref_contraindications_id_seq'::regclass),
    id_med bigint NOT NULL DEFAULT nextval('"med_ref_contraindications_idMed_seq"'::regclass),
    id_contraindications bigint NOT NULL DEFAULT nextval('"med_ref_contraindications_idContraindications_seq"'::regclass),
    CONSTRAINT med_ref_contraindications_pkey PRIMARY KEY (id_med)
)

CREATE TABLE IF NOT EXISTS public.med_refmnn
(
    id bigint NOT NULL DEFAULT nextval('med_ref_mnn_id_seq'::regclass),
    idmnn integer,
    id_med integer,
    CONSTRAINT med_ref_mnn_pkey PRIMARY KEY (id)
)

CREATE TABLE IF NOT EXISTS public.medicine
(
    id bigint NOT NULL DEFAULT nextval('medicine_id_seq'::regclass),
    name character varying(256) COLLATE pg_catalog."default",
    for_receipt boolean,
    "idMedRefContraindications" bigint NOT NULL DEFAULT nextval('"medicine_idMedRefContraindications_seq"'::regclass),
    "idMedRefMNN" bigint NOT NULL DEFAULT nextval('"medicine_idMedRefMNN_seq"'::regclass),
    CONSTRAINT medicine_pkey PRIMARY KEY (id)
)

CREATE TABLE IF NOT EXISTS public.mnn
(
    id bigint NOT NULL DEFAULT nextval('mnn_id_seq'::regclass),
    full_name character varying(256) COLLATE pg_catalog."default",
    CONSTRAINT mnn_pkey PRIMARY KEY (id)
)