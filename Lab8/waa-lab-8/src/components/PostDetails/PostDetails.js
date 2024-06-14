import React, { useEffect, useState } from "react";
import "./PostDetails.css";
import Comments from "../../containers/Comments/Comments";
import axios from "axios";
import { usePostId } from "../../contexts/PostIdContext";

const PostDetails = (props) => {
  console.log("I am at PostDetails");

  const [postId, setPostId] = usePostId();

  const [comments, setComments] = useState([
    { id: 1, postId: 1, author: "Marc", comment: "Nice Post" },
    { id: 2, postId: 2, author: "Lennard", comment: "AmazingPost" },
  ]);

  const [postDetailsState, setPostDetailsState] = useState([]);

  const fetchSelectedPost = (id) => {
    console.log("I am at fetchSelectedPost in PostDetails");
    axios
      .get(`http://localhost:8081/posts/${id}`)
      .then((response) => {
        setPostDetailsState(response.data);
        console.log(
          " I succeeded fetching the selected post in fetchSelectedPost in PostDetails!"
        );
        console.log(
          "I set postDetailsState in fetchSelectedPost in PostDetails"
        );
      })
      .catch((error) => console.log(error));
  };

  const deletePost = (id) => {
    console.log("I am at deletePost in PostDetails");
    axios
      .delete(`http://localhost:8081/posts/${id}`)
      .then((response) => {
        props.fetchPosts();
        setPostDetailsState(null);
        setPostId(null);
        console.log(
          " I succeeded deleting the post in deletePost in PostDetails!"
        );
        console.log(
          "I set the PostDetailsState in delete post in PostDetails!"
        );
      })
      .catch((error) => {
        console.log(error);
      });
  };

  function fetchComments(id) {
    console.log("I got in fetchComments with id : " + id + " in PostDetails");
    axios
      .get(`http://localhost:8081/posts/${id}/comments`)
      .then((response) => {
        console.log(
          " I succeeded fetching comments in fetchComments in PostDetails!"
        );
        console.log("I set the setComments in fetchComments in PostDetails!");
        setComments(response.data);
        console.log(response.data);
      })
      .catch((error) => console.log(error));
  }

  useEffect(() => {
    console.log(
      "I am in the useEffect and I am fetching the Comments in PostDetails"
    );
    fetchComments(postId);
  }, [postDetailsState.id]);

  useEffect(() => {
    console.log(
      "I am in the useEffect and I am fetching the Selected Post in PostDetails!"
    );
    fetchSelectedPost(postId);
  }, [postId]);

  return (
    <div className="post-details">
      <div className="author-title">
        <h2 className="title">{postDetailsState.id}</h2>
        <h2 className="title">{postDetailsState.title}</h2>
        <p className="content">{postDetailsState.content}</p>
        <p className="author">By : {postDetailsState.author}</p>
      </div>
      <h2>Comments</h2>
      <div className="comments">
        <Comments commentsList={comments} />
      </div>
      <div>
        <button>Edit</button>
        <button onClick={() => deletePost(postDetailsState.id)}>Delete</button>
      </div>
    </div>
  );
};

export default PostDetails;
