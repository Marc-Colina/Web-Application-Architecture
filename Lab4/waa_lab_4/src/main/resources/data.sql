-- Insert a single post

INSERT INTO Users (name)
VALUES ('Marc');
INSERT INTO Users (name)
VALUES ('Mary');
INSERT INTO Users (name)
VALUES ('Mabelle');

insert into post (user_id, title, content, author)
values (1, 'Introduction to Java', 'This post covers the basics of Java programming.', 'John Doe');

-- Insert another post
insert into post(user_id, title, content, author)
values (2, 'Spring Framework', 'An overview of the Spring Framework and its core features.', 'Jane Smith');

-- Insert multiple posts
insert into post (user_id, title, content, author)
values (3, 'Understanding REST APIs', 'This post explains what REST APIs are and how to use them.', 'Alice Johnson'),
       (1, 'Database Management Systems', 'A comprehensive guide to DBMS and their importance in software development.',
        'Bob Brown');

Insert into comment (post_id, name)
values (1, 'John Doe'),
       (1, 'Marc Colina'),
       (1, 'Dean Al-Tarawneh'),
       (2, 'Mabelle Seares'),
       (2, 'Mary Colina'),
       (3, 'Marietto Seares'),
       (3, 'Rose Colina'),
       (3, 'Marlon Colina');


