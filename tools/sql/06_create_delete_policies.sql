create policy "Authenticated users can delete their own profile."
on profile for delete
to authenticated
using ( auth.uid() = user_id );

create policy "Authenticated users can delete their own my_book."
on my_book for delete
to authenticated
using ( auth.uid() = user_id );

create policy "Authenticated users can delete their own memo."
on memo for delete
to authenticated
using (
  auth.uid() = (
    select user_id from my_book
    where my_book.id = memo.my_book_id
  )
);
