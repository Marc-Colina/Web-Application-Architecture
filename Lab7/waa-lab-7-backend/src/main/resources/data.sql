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

Insert into comment (post_id, name, comment)
values (1, 'John Doe', 'Nice Post!'),
       (1, 'Marc Colina', 'Amazing Post!'),
       (1, 'Dean Al-Tarawneh', 'Great Post!'),
       (2, 'Mabelle Seares', 'Gorgeous Post!'),
       (2, 'Mary Colina', 'Awesome Post!'),
       (3, 'Marietto Seares', 'Wonderful Post!'),
       (3, 'Rose Colina', 'Fantastic Post!'),
       (4, 'Marlon Colina', 'Excellent Post!');


