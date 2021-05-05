create table posts
(
    id bigint not null
        constraint posts_pkey
            primary key,
    content varchar(255),
    title varchar(255),
    author_id bigint
        constraint author_id_users
            references users,
    category_id bigint
        constraint category_id_categories
            references categories
);

alter table posts owner to postgres;

