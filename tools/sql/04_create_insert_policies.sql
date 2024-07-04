create policy "Authenticated users can create a user."
on users for insert
to authenticated
with check ( auth.uid() = id );

create policy "Authenticated users can create a book."
on books for insert
to authenticated
with check ( auth.uid() is not null );

create policy "Authenticated users can create a my_book."
on my_books for insert
to authenticated
with check ( auth.uid() = user_id );

create policy "Authenticated users can create a author."
on authors for insert
to authenticated
with check ( auth.uid() is not null );

create policy "Authenticated users can create a memo."
on memos for insert
to authenticated
with check (
  auth.uid() = (
    select user_id from my_books
    where my_books.id = memos.my_book_id
  )
);
