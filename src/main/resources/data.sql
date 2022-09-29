insert into account (account_name, url_count, storage_duration_in_days)
values('joe', 5, 3);
insert into account (account_name, url_count, storage_duration_in_days)
values('jae', 5, 3);
insert into account (account_name, url_count, storage_duration_in_days)
values('jane', 5, 3);
insert into account (account_name, url_count, storage_duration_in_days)
values('john', 5, 3);
insert into account (account_name, url_count, storage_duration_in_days)
values('liz', 5, 3);

insert into URL  (CREATED_AT, EXPIRE_AT, URL_NAME, VISIT_COUNT, VISITED_AT, ACCOUNT_NAME, URL_GROUP_ID)
values(CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'HAHA', 0, CURRENT_TIMESTAMP, 'liz', null);

insert into url_group (url_group_name, account_name, parent_url_group_id) values ('first', 'liz', null);
insert into url_group (url_group_name, account_name, parent_url_group_id) values ('second', 'liz', 1);
insert into url_group (url_group_name, account_name, parent_url_group_id) values ('third', 'liz', 2);