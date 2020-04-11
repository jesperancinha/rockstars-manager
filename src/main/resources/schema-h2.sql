drop table if exists artists;

drop table if exists songs;

drop table if exists users;

create table artists
(
    id   bigint not null
        constraint artists_pkey
            primary key,
    name varchar(255)
);

create table songs
(
    id         bigint not null
        constraint songs_pkey
            primary key,
    album      varchar(255),
    artist     varchar(255),
    bpm        bigint,
    duration   bigint,
    genre      varchar(255),
    name       varchar(255),
    short_name varchar(255),
    spotify_id varchar(255),
    year       integer
);

create table users
(
    email varchar(255) not null
        constraint users_pkey
            primary key,
    date timestamp,
    name varchar(255),
    password varchar(255),
    role varchar(255)
);