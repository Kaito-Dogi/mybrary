create policy "Authenticated users can update their own user."
on users for update
to authenticated
using ( auth.uid() = id );
with check ( auth.uid() = id );

create policy "Authenticated users can update their own my_book."
on my_books for update
to authenticated
using ( auth.uid() = user_id );
with check ( auth.uid() = user_id );

create policy "Authenticated users can update their own memo."
on memos for update
to authenticated
using (
  auth.uid() = (
    select user_id from my_books
    where my_books.id = memos.my_book_id
  )
);
with check (
  auth.uid() = (
    select user_id from my_books
    where my_books.id = memos.my_book_id
  )
);
