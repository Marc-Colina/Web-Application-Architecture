import React from "react";
import "./Post.css";

const Post = (props) => {
  return (
    <div className="post" onClick={props.onClick}>
      <h2>Id : {props.id}</h2>
      <h2>Title : {props.title}</h2>
      <h2>Author : {props.author}</h2>
    </div>
  );
};

export default Post;
