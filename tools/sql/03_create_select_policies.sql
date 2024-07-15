create policy "Public profile are viewable by everyone"
on public.profile for select
to authenticated, anon
using ( true );

create policy "Public book are viewable by everyone"
on public.book for select
to authenticated, anon
using ( true );

create policy "Public my_book are viewable by everyone"
on public.my_book for select
to authenticated, anon
using ( true );

create policy "Public author are viewable by everyone"
on public.author for select
to authenticated, anon
using ( true );

create policy "Public memo are viewable by everyone"
on public.memo for select
to authenticated, anon
using ( true );
