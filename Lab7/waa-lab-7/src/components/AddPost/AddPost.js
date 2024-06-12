import React, { useState } from "react";
import "./AddPost.css";
import axios from "axios";

const AddPost = (props) => {
  const [post, setPost] = useState({
    title: "",
    content: "",
    author: "",
    user_id: 1,
  });

  const onChange = (event) => {
    const copy = { ...post };
    copy[event.target.name] = event.target.value;
    console.log(event.target.value);
    setPost(copy);
  };

  function addPost() {
    // console.log("title" + post.title);
    // console.log(post.content);
    // console.log(post.author);
    //console.log(post.user_id);
    axios
      .post("http://localhost:8081/posts", post)
      .then((response) => {
        props.fetchPosts();
        console.log("Successfully Added!");
      })
      .catch((error) => console.log(error));
  }

  return (
    <div className="add-post">
      <h2>Add A Post</h2>

      <label htmlFor="postTitle">Title</label>
      <input
        type="text"
        id="postTitle"
        name="title"
        onChange={onChange}
      ></input>

      <label htmlFor="postContent">Content</label>
      <textarea
        type="text"
        id="postContent"
        className="add-post-content"
        name="content"
        onChange={onChange}
      ></textarea>

      <label htmlFor="postAuthor">Author</label>
      <input
        type="text"
        id="postAuthor"
        name="author"
        onChange={onChange}
      ></input>
      <button onClick={addPost}>Add Post</button>
    </div>
  );
};

export default AddPost;
