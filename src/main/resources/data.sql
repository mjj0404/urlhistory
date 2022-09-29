insert into account (account_name, storage_duration_in_days, url_count, url_max_count)
values('joe', 7, 0, 100);
insert into account (account_name, storage_duration_in_days, url_count, url_max_count)
values('may', 7, 0, 100);
insert into account (account_name, storage_duration_in_days, url_count, url_max_count)
values('jae', 7, 0, 100);
insert into account (account_name, storage_duration_in_days, url_count, url_max_count)
values('jake', 7, 0, 100);
insert into account (account_name, storage_duration_in_days, url_count, url_max_count)
values('liz', 7, 0, 100);

insert into URL  (CREATED_AT, EXPIRE_AT, IS_EXPIRE, URL_NAME, VISIT_COUNT, VISITED_AT, ACCOUNT_NAME, URL_GROUP_ID)
values(CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, FALSE, 'HAHA', 0, CURRENT_TIMESTAMP, 'liz', null);

insert into url_group (url_group_name, account_name, parent_url_group_id) values ('first', 'liz', null);
insert into url_group (url_group_name, account_name, parent_url_group_id) values ('second', 'liz', 1);
insert into url_group (url_group_name, account_name, parent_url_group_id) values ('third', 'liz', 2);