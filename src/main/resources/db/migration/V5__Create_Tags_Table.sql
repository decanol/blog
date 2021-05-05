create table tags
(
    id bigint not null
        constraint tags_pkey
            primary key,
    name varchar(255)
);

alter table tags owner to postgres;

