-- Insert into users

insert into public.users (id, name, created_at, updated_at)
values
('11c86023-0a4f-49c2-b3a2-aede1ad05f63', 'Test User', current_timestamp, current_timestamp);

-- Insert into books

insert into public.books (external_id, title, image_url, page_count, publisher, isbn10, isbn13, created_at, updated_at)
values
('RuKoDwAAQBAJ', 'プリンシプル オブ プログラミング 3年目までに身につけたい 一生役立つ101の原理原則', 'https://books.google.com/books/content?id=RuKoDwAAQBAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api', 337, '秀和システム', null, null, current_timestamp, current_timestamp);

insert into public.books (external_id, title, image_url, page_count, publisher, isbn10, isbn13, created_at, updated_at)
values
('SinFRfuTH7IC', 'ハッカーと画家', 'https://books.google.com/books/content?id=SinFRfuTH7IC&printsec=frontcover&img=1&zoom=1&source=gbs_api', 284, '株式会社 オーム社', '4274065979', '9784274065972', current_timestamp, current_timestamp);

insert into public.books (external_id, title, image_url, page_count, publisher, isbn10, isbn13, created_at, updated_at)
values
('1FGpzQEACAAJ', 'オブジェクト指向UIデザイン使いやすいソフトウェアの原理', 'https://books.google.com/books/content?id=1FGpzQEACAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api', 360, null, '4297113511', '9784297113513', current_timestamp, current_timestamp);

insert into public.books (external_id, title, image_url, page_count, publisher, isbn10, isbn13, created_at, updated_at)
values
('IUp4CwAAQBAJ', 'ユースケース駆動開発実践ガイド', 'https://books.google.com/books/content?id=IUp4CwAAQBAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api', 563, '翔泳社', '4798146528', '9784798146522', current_timestamp, current_timestamp);

insert into public.books (external_id, title, image_url, page_count, publisher, isbn10, isbn13, created_at, updated_at)
values
('GRjUuQEACAAJ', 'Clean Architecture', 'https://books.google.com/books/content?id=GRjUuQEACAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api', 349, null, '4048930656', '9784048930659', current_timestamp, current_timestamp);

insert into public.books (external_id, title, image_url, page_count, publisher, isbn10, isbn13, created_at, updated_at)
values
('4TKQswEACAAJ', 'Kotlinイン・アクション', 'https://books.google.com/books/content?id=4TKQswEACAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api', 468, null, null, null, current_timestamp, current_timestamp);

-- Insert authors

insert into public.authors (book_id, name, created_at, updated_at)
values
((select id from public.books where title = 'プリンシプル オブ プログラミング 3年目までに身につけたい 一生役立つ101の原理原則'), '上田勲', current_timestamp, current_timestamp);

insert into public.authors (book_id, name, created_at, updated_at)
values
((select id from public.books where title = 'オブジェクト指向UIデザイン使いやすいソフトウェアの原理'), 'ソシオメディア', current_timestamp, current_timestamp),
((select id from public.books where title = 'オブジェクト指向UIデザイン使いやすいソフトウェアの原理'), '上野学', current_timestamp, current_timestamp),
((select id from public.books where title = 'オブジェクト指向UIデザイン使いやすいソフトウェアの原理'), '藤井幸多', current_timestamp, current_timestamp);

insert into public.authors (book_id, name, created_at, updated_at)
values
((select id from public.books where title = 'ユースケース駆動開発実践ガイド'), 'ダグ・ローゼンバーグ', current_timestamp, current_timestamp),
((select id from public.books where title = 'ユースケース駆動開発実践ガイド'), 'マット・ステファン', current_timestamp, current_timestamp);

insert into public.authors (book_id, name, created_at, updated_at)
values
((select id from public.books where title = 'Clean Architecture'), 'ロバート・C. マーチン', current_timestamp, current_timestamp);

insert into public.authors (book_id, name, created_at, updated_at)
values
((select id from public.books where title = 'Kotlinイン・アクション'), 'ＤｍｉｔｒｙＪｅｍｅｒｏｖ', current_timestamp, current_timestamp),
((select id from public.books where title = 'Kotlinイン・アクション'), 'ＳｖｅｔｌａｎａＩｓａｋｏｖａ', current_timestamp, current_timestamp),
((select id from public.books where title = 'Kotlinイン・アクション'), '長澤太郎', current_timestamp, current_timestamp),
((select id from public.books where title = 'Kotlinイン・アクション'), '藤原聖', current_timestamp, current_timestamp),
((select id from public.books where title = 'Kotlinイン・アクション'), '山本純平', current_timestamp, current_timestamp),
((select id from public.books where title = 'Kotlinイン・アクション'), 'ｙｙ＿ｙａｎｋ', current_timestamp, current_timestamp);

-- Insert my_books

insert into public.my_books (user_id, book_id, is_pinned, is_favorite, is_public, is_archived, created_at, updated_at)
values
('11c86023-0a4f-49c2-b3a2-aede1ad05f63', (select id from public.books where title = 'プリンシプル オブ プログラミング 3年目までに身につけたい 一生役立つ101の原理原則'), false, false, false, false, current_timestamp, current_timestamp);

insert into public.my_books (user_id, book_id, is_pinned, is_favorite, is_public, is_archived, created_at, updated_at)
values
('11c86023-0a4f-49c2-b3a2-aede1ad05f63', (select id from public.books where title = 'ハッカーと画家'), false, false, false, false, current_timestamp, current_timestamp);

insert into public.my_books (user_id, book_id, is_pinned, is_favorite, is_public, is_archived, created_at, updated_at)
values
('11c86023-0a4f-49c2-b3a2-aede1ad05f63', (select id from public.books where title = 'オブジェクト指向UIデザイン使いやすいソフトウェアの原理'), false, false, false, false, current_timestamp, current_timestamp);

insert into public.my_books (user_id, book_id, is_pinned, is_favorite, is_public, is_archived, created_at, updated_at)
values
('11c86023-0a4f-49c2-b3a2-aede1ad05f63', (select id from public.books where title = 'ユースケース駆動開発実践ガイド'), false, false, false, false, current_timestamp, current_timestamp);

insert into public.my_books (user_id, book_id, is_pinned, is_favorite, is_public, is_archived, created_at, updated_at)
values
('11c86023-0a4f-49c2-b3a2-aede1ad05f63', (select id from public.books where title = 'Clean Architecture'), false, false, false, false, current_timestamp, current_timestamp);

insert into public.my_books (user_id, book_id, is_pinned, is_favorite, is_public, is_archived, created_at, updated_at)
values
('11c86023-0a4f-49c2-b3a2-aede1ad05f63', (select id from public.books where title = 'Kotlinイン・アクション'), false, false, false, false, current_timestamp, current_timestamp);

-- Insert memos

insert into public.memos (my_book_id, start_page, end_page, content, created_at, updated_at)
values ((select id from public.my_books where book_id = (select id from public.books where title = 'ハッカーと画家') and user_id = '11c86023-0a4f-49c2-b3a2-aede1ad05f63'), 2, 3, '日本人はものをうまく作ることに取り憑かれている米国人はとにかく仕事を終えることを考える。', current_timestamp, current_timestamp);

insert into public.memos (my_book_id, start_page, content, created_at, updated_at)
values ((select id from public.my_books where book_id = (select id from public.books where title = 'ハッカーと画家') and user_id = '11c86023-0a4f-49c2-b3a2-aede1ad05f63'), 5, 'とにかくやる、という方法は速い。', current_timestamp, current_timestamp);

insert into public.memos (my_book_id, start_page, content, created_at, updated_at)
values ((select id from public.my_books where book_id = (select id from public.books where title = 'ハッカーと画家') and user_id = '11c86023-0a4f-49c2-b3a2-aede1ad05f63'), 5, 'きっと将来最も成功する国は、今日「お国柄」と思われているようなものを捨てて、それぞれの事柄についてそれが最も有効に働く方法を探っていく国。\nさあ、競争だ。', current_timestamp, current_timestamp);
