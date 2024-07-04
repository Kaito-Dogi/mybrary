create policy "Public users are viewable by everyone"
on public.users for select
to authenticated, anon
using ( true );

create policy "Public books are viewable by everyone"
on public.books for select
to authenticated, anon
using ( true );

create policy "Public my_books are viewable by everyone"
on public.my_books for select
to authenticated, anon
using ( true );

create policy "Public authors are viewable by everyone"
on public.authors for select
to authenticated, anon
using ( true );

create policy "Public memos are viewable by everyone"
on public.memos for select
to authenticated, anon
using ( true );
