-- Define trigger to automatically update the updated_at column

create or replace function update_updated_at_column()
returns trigger as $$
begin
  new.updated_at = current_timestamp;
  return new;
end;
$$ language plpgsql;

-- Create triggers

create trigger update_users_updated_at before update on public.users
for each row execute function update_updated_at_column();

create trigger update_books_updated_at before update on public.books
for each row execute function update_updated_at_column();

create trigger update_my_books_updated_at before update on public.my_books
for each row execute function update_updated_at_column();

create trigger update_authors_updated_at before update on public.authors
for each row execute function update_updated_at_column();

create trigger update_memos_updated_at before update on public.memos
for each row execute function update_updated_at_column();
