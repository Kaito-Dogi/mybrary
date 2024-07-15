create policy "Authenticated users can create a profile."
on profile for insert
to authenticated
with check ( auth.uid() = user_id );

create policy "Authenticated users can create a book."
on book for insert
to authenticated
with check ( auth.uid() is not null );

create policy "Authenticated users can create a my_book."
on my_book for insert
to authenticated
with check ( auth.uid() = user_id );

create policy "Authenticated users can create a author."
on author for insert
to authenticated
with check ( auth.uid() is not null );

create policy "Authenticated users can create a memo."
on memo for insert
to authenticated
with check (
  auth.uid() = (
    select user_id from my_book
    where my_book.id = memo.my_book_id
  )
);
