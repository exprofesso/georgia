drop function if exists smart_user_search;

create function smart_user_search(
    login varchar(255), name varchar(255), surname varchar(255), email varchar(255), role integer)
    RETURNS setof m_users
AS
$$

select u.* from m_users u
where u.email = $1 and u.name = $2 and u.login = $4
limit 1;

$$ language SQL;
