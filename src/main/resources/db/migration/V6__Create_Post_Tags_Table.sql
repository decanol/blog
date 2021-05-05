create table post_tags
(
    post_id bigint not null
        constraint post_id_posts
            references posts,
    tag_id bigint not null
        constraint tag_id_tags
            references tags,
    constraint post_tags_pkey
        primary key (post_id, tag_id)
);

alter table post_tags owner to postgres;

