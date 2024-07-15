create table public.profile (
  user_id uuid not null primary key references auth.users on delete cascade,
  name varchar(255) not null,
  created_at timestamp not null default current_timestamp,
  updated_at timestamp not null default current_timestamp
);

create table public.book (
  id bigint generated always as identity primary key,
  external_id char(12) not null,
  title varchar(255) not null,
  image_url varchar(255),
  isbn10 char(10),
  isbn13 char(13),
  page_count int check (page_count > 0),
  publisher varchar(255),
  created_at timestamp not null default current_timestamp,
  updated_at timestamp not null default current_timestamp
);

create table public.my_book (
  id bigint generated always as identity primary key,
  user_id uuid not null references public.profile(user_id) on delete cascade,
  book_id bigint not null references public.book(id) on delete cascade,
  is_pinned boolean not null,
  is_favorite boolean not null,
  is_public boolean not null,
  is_archived boolean not null,
  created_at timestamp not null default current_timestamp,
  updated_at timestamp not null default current_timestamp
);

create table public.author (
  id bigint generated always as identity primary key,
  book_id bigint not null references public.book(id) on delete cascade,
  name varchar(255) not null,
  created_at timestamp not null default current_timestamp,
  updated_at timestamp not null default current_timestamp
);

create table public.memo (
  id bigint generated always as identity primary key,
  my_book_id bigint not null references public.my_book(id) on delete cascade,
  content text not null,
  start_page int check (start_page > 0),
  end_page int check (end_page > 0),
  edited_at timestamp,
  published_at timestamp,
  like_count int not null check (like_count >= 0),
  created_at timestamp not null default current_timestamp,
  updated_at timestamp not null default current_timestamp
);
