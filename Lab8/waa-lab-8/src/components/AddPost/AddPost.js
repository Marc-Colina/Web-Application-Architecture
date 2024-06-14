import React, { useRef, useState } from "react";
import "./AddPost.css";
import axios from "axios";

const AddPost = (props) => {
  const [post, setPost] = useState({
    title: "",
    content: "",
    author: "",
    user_id: 1,
  });

  const titleRef = useRef(null);
  const authorRef = useRef(null);
  const contentRef = useRef(null);

  // const onChange = (event) => {
  //   const copy = { ...post };
  //   copy[event.target.name] = event.target.value;
  //   console.log(event.target.value);
  //   setPost(copy);
  // };

  function addPost() {
    // console.log("title" + post.title);
    // console.log(post.content);
    // console.log(post.author);
    //console.log(post.user_id);
    console.log("I AM TITLE REF" + titleRef.current.value);

    const newPost = {
      title: titleRef.current.value,
      content: contentRef.current.value,
      author: authorRef.current.value,
      user_id: 1,
    };
    setPost(newPost);

    axios
      .post("http://localhost:8081/posts", newPost)
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
      <input type="text" id="postTitle" name="title" ref={titleRef}></input>

      <label htmlFor="postContent">Content</label>
      <textarea
        type="text"
        id="postContent"
        className="add-post-content"
        name="content"
        ref={contentRef}
      ></textarea>

      <label htmlFor="postAuthor">Author</label>
      <input type="text" id="postAuthor" name="author" ref={authorRef}></input>
      <button onClick={addPost}>Add Post</button>
    </div>
  );
};

export default AddPost;
