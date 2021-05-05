create table comments
(
    id bigint not null
        constraint comments_pkey
            primary key,
    content varchar(255),
    author_id bigint
        constraint author_id_users
            references users,
    post_id bigint
        constraint post_id_posts
            references posts
);

alter table comments owner to postgres;

