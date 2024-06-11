import React from "react";
import "./PostDetails.css";

const PostDetails = (props) => {
  return (
    <div className="post-details">
      <div className="author-title">
        <h2 className="title">{props.postDetails.title}</h2>
        <p className="author">By : {props.postDetails.author}</p>
      </div>
      <div>
        <p>This is the content in the post ...</p>
      </div>
      <div>
        <button>Edit</button>
        <button>Delete</button>
      </div>
    </div>
  );
};

export default PostDetails;
