-- Define trigger to automatically update the updated_at column

create or replace function update_updated_at_column()
returns trigger as $$
begin
  new.updated_at = current_timestamp;
  return new;
end;
$$ language plpgsql;

-- Create triggers

create trigger update_user_updated_at before update on public.profile
for each row execute function update_updated_at_column();

create trigger update_book_updated_at before update on public.book
for each row execute function update_updated_at_column();

create trigger update_my_book_updated_at before update on public.my_book
for each row execute function update_updated_at_column();

create trigger update_author_updated_at before update on public.author
for each row execute function update_updated_at_column();

create trigger update_memo_updated_at before update on public.memo
for each row execute function update_updated_at_column();
