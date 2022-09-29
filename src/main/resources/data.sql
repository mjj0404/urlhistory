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

-- CREATED_AT  	EXPIRE_AT  	IS_EXPIRE  	RATING  	URL_NAME  	VISIT_COUNT  	VISITED_AT  	ACCOUNT_NAME  	URL_GROUP_ID

insert into URL (url_name, account_name, is_expire, created_at, expire_at, visited_at, rating)
values('liz 1st website url', 'liz', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,1);
insert into URL (url_name, account_name, is_expire, created_at, expire_at, visited_at, rating)
values('liz 2nd website url', 'liz', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,3);
insert into URL (url_name, account_name, is_expire, created_at, expire_at, visited_at, rating)
values('liz 3rd website url', 'liz', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,5);
insert into URL (url_name, account_name, is_expire, created_at, expire_at, visited_at, rating)
values('liz 4th website url', 'liz', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,2);
insert into URL (url_name, account_name, is_expire, created_at, expire_at, visited_at, rating)
values('liz 5th website url', 'liz', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,4);
insert into URL (url_name, account_name, is_expire, created_at, expire_at, visited_at, rating)
values('liz 6th website url', 'liz', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,3);




insert into url_group (url_group_name, account_name, parent_url_group_id) values ('first', 'liz', null);
insert into url_group (url_group_name, account_name, parent_url_group_id) values ('second', 'liz', 1);
insert into url_group (url_group_name, account_name, parent_url_group_id) values ('third', 'liz', 2);

insert into URL (url_name, account_name, is_expire, created_at, expire_at, visited_at, url_group_id, rating)
values('liz 7th website url', 'liz', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1, 3);
