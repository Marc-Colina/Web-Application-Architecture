import React, { useEffect, useState } from "react";
import Posts from "../Posts/Posts";
import "./Dashboard.css";
import PostDetails from "../../components/PostDetails/PostDetails";
import axios from "axios";
import AddPost from "../../components/AddPost/AddPost";

const Dashboard = () => {
  console.log("Hello I am Dashboard!");
  const [postsState, setPostsState] = useState([
    { id: 111, title: "Happiness", author: "John" },
    { id: 112, title: "MIU", author: "Dean" },
    { id: 113, title: "Enjoy Life", author: "Jasmine" },
  ]);

  function fetchPosts() {
    axios
      .get("http://localhost:8081/posts")
      .then((response) => {
        console.log("I set the PostsState in fetchPosts");
        setPostsState(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  }

  useEffect(() => {
    fetchPosts();
  }, []);

  const [postState, setPostState] = useState({ title: "", author: "" });

  const [postDetailsState, setPostDetailsState] = useState(null);

  const onChange = (event) => {
    const copy = { ...postState };
    copy[event.target.name] = event.target.value;
    setPostState(copy);
    console.log("I set the PostState in onChange");
  };

  function changeTitle() {
    const updatedPosts = [...postsState];
    updatedPosts[0].title = postState.title;
    setPostsState(updatedPosts);
    console.log("I set the PostsState in Check Title");
  }

  const deletePost = (id) => {
    axios
      .delete(`http://localhost:8081/posts/${id}`)
      .then((response) => {
        fetchPosts();
        setPostDetailsState(null);
        console.log("I set the PostDetailsState in delete post");
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const fetchSelectedPost = (id) => {
    axios
      .get(`http://localhost:8081/posts/${id}`)
      .then((response) => {
        setPostDetailsState(response.data);
        console.log("I set postDetailsState in fetchSelectedPost");
      })
      .catch((error) => console.log(error));
  };

  return (
    <div>
      <div className="posts">
        <Posts posts={postsState} onSelectPost={fetchSelectedPost} />
      </div>
      <div className="change-title">
        <input type="text" name="title" onChange={onChange}></input>
        <button onClick={changeTitle}>Change Title (First Post)</button>
      </div>
      {postDetailsState && (
        <PostDetails postDetails={postDetailsState} deletePost={deletePost} />
      )}
      <AddPost fetchPosts={fetchPosts} />
    </div>
  );
};

export default Dashboard;
