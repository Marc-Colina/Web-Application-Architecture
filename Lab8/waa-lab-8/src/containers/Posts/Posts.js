import React from "react";
import Post from "../../components/Post/Post";

const Posts = (props) => {
  console.log("I am at Posts");
  const posts = props.posts.map((post) => {
    return (
      <Post
        id={post.id}
        title={post.title}
        author={post.author}
        content={post.content}
        key={post.id}
        onClick={() => props.onSelectPost(post.id)}
      />
    );
  });
  return posts;
};

export default Posts;
