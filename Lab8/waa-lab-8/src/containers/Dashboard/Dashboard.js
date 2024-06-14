import React, { useEffect, useState } from "react";
import Posts from "../Posts/Posts";
import "./Dashboard.css";
import PostDetails from "../../components/PostDetails/PostDetails";
import axios from "axios";
import AddPost from "../../components/AddPost/AddPost";
import { usePostId } from "../../contexts/PostIdContext";

const Dashboard = () => {
  console.log("Hello I am Dashboard!");

  const [postId, setPostId] = usePostId();

  const [postsState, setPostsState] = useState([
    { id: 111, title: "Happiness", author: "John" },
    { id: 112, title: "MIU", author: "Dean" },
    { id: 113, title: "Enjoy Life", author: "Jasmine" },
  ]);

  function fetchPosts() {
    axios
      .get("http://localhost:8081/posts")
      .then((response) => {
        console.log(
          "I succeeded in fetching the posts in fetchPosts in Dashboard"
        );
        console.log("I set the PostsState in fetchPosts in Dashboard");
        setPostsState(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  }

  useEffect(() => {
    console.log("I am in useEffect in Dashboard fetching the Posts");
    fetchPosts();
  }, []);

  const [postState, setPostState] = useState({ title: "", author: "" });

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

  const setSelectedPostId = (id) => {
    console.log("I am at setSelectedPostId in Dashboard!");
    setPostId(id);
  };

  return (
    <div>
      <div className="posts">
        <Posts posts={postsState} onSelectPost={setSelectedPostId} />
      </div>
      <div className="change-title">
        <input type="text" name="title" onChange={onChange}></input>
        <button onClick={changeTitle}>Change Title (First Post)</button>
      </div>
      {postId && <PostDetails fetchPosts={fetchPosts} />}
      <AddPost fetchPosts={fetchPosts} />
    </div>
  );
};

export default Dashboard;
