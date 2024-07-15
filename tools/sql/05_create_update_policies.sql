create policy "Authenticated users can update their own user."
on profile for update
to authenticated
using ( auth.uid() = user_id );
with check ( auth.uid() = user_id );

create policy "Authenticated users can update their own my_book."
on my_book for update
to authenticated
using ( auth.uid() = user_id );
with check ( auth.uid() = user_id );

create policy "Authenticated users can update their own memo."
on memo for update
to authenticated
using (
  auth.uid() = (
    select user_id from my_book
    where my_book.id = memo.my_book_id
  )
);
with check (
  auth.uid() = (
    select user_id from my_book
    where my_book.id = memo.my_book_id
  )
);
