create table categories
(
    id bigint not null
        constraint categories_pkey
            primary key,
    description varchar(255),
    name varchar(255),
    parent_id bigint
        constraint parent_id_categories
            references categories
);

alter table categories owner to postgres;

