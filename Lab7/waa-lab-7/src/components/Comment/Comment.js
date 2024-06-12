import React from "react";
import "./Comment.css";
const Comment = (props) => {
  return (
    <div className="post comment">
      <h2>By : {props.name}</h2>
      <p>{props.comment}</p>
    </div>
  );
};

export default Comment;
