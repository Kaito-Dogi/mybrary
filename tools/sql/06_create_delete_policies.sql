create policy "Authenticated users can delete their own user."
on users for delete
to authenticated
using ( auth.uid() = id );

create policy "Authenticated users can delete their own my_book."
on my_books for delete
to authenticated
using ( auth.uid() = user_id );

create policy "Authenticated users can delete their own memo."
on memos for delete
to authenticated
using (
  auth.uid() = (
    select user_id from my_books
    where my_books.id = memos.my_book_id
  )
);
