import React from "react";
import Post from "../../components/Post/Post";

const Posts = (props) => {
  const posts = props.posts.map((post) => {
    return (
      <Post
        id={post.id}
        title={post.title}
        author={post.author}
        key={post.id}
        onClick={() => props.onSelectPost(post)}
      />
    );
  });
  return posts;
};

export default Posts;
