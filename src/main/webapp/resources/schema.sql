
-- 2023-09-02
create database rmsoft_yang;

create table user(
user_num int auto_increment,
user_id varchar(20) not null,
user_pw varchar(40) not null,
user_reg_date datetime default now(),
primary key(user_num));

create table board(
board_num int auto_increment,
board_title varchar(100) not null,
board_writer varchar(100) not null,
board_content varchar(1000) not null,
board_reg_date datetime default now(),
board_count int default 0,
board_img varchar(50) not null,
board_loan int default 0,
board_user varchar(20) not null,
primary key(board_num));

insert into user(user_id, user_pw)
    values(#{userId}, #{userPw});

select * from user where user_id = #{userId} and user_pw = #{userPw};