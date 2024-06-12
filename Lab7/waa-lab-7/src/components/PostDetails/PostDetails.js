import React, { useEffect, useState } from "react";
import "./PostDetails.css";
import Comments from "../../containers/Comments/Comments";
import axios from "axios";

const PostDetails = (props) => {
  console.log("I am at PostDetails");
  const [comments, setComments] = useState([
    { id: 1, postId: 1, author: "Marc", comment: "Nice Post" },
    { id: 2, postId: 2, author: "Lennard", comment: "AmazingPost" },
  ]);

  function fetchComments(id) {
    console.log("I got in fetchComments with id : " + id);
    axios
      .get(`http://localhost:8081/posts/${id}/comments`)
      .then((response) => {
        console.log(" I SUCCEEDED!");
        setComments(response.data);
        console.log(response.data);
      })
      .catch((error) => console.log(error));
  }

  useEffect(() => {
    console.log("IM MOUNTED!");
    fetchComments(props.postDetails.id);
  }, [props.postDetails.id]);

  return (
    <div className="post-details">
      <div className="author-title">
        <h2 className="title">{props.postDetails.id}</h2>
        <h2 className="title">{props.postDetails.title}</h2>
        <p className="content">{props.postDetails.content}</p>
        <p className="author">By : {props.postDetails.author}</p>
      </div>
      <h2>Comments</h2>
      <div className="comments">
        <Comments commentsList={comments} />
      </div>
      <div>
        <button>Edit</button>
        <button onClick={() => props.deletePost(props.postDetails.id)}>
          Delete
        </button>
      </div>
    </div>
  );
};

export default PostDetails;
