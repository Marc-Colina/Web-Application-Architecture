import React, { useState } from "react";
import Posts from "../Posts/Posts";
import "./Dashboard.css";
import PostDetails from "../../components/PostDetails/PostDetails";
const Dashboard = () => {
  const [postsState, setPostsState] = useState([
    { id: 111, title: "Happiness", author: "John" },
    { id: 112, title: "MIU", author: "Dean" },
    { id: 113, title: "Enjoy Life", author: "Jasmine" },
  ]);

  const [postState, setPostState] = useState({ title: "", author: "" });

  const [postDetailsState, setPostDetailsState] = useState(null);

  const onChange = (event) => {
    const copy = { ...postState };
    copy[event.target.name] = event.target.value;
    setPostState(copy);
  };

  function changeTitle() {
    const updatedPosts = [...postsState];
    updatedPosts[0].title = postState.title;
    setPostsState(updatedPosts);
  }

  const selectedPost = (post) => {
    console.log("I got here!" + post.title);
    setPostDetailsState(post);
  };

  return (
    <div>
      <div className="posts">
        <Posts posts={postsState} onSelectPost={selectedPost} />
      </div>
      <div className="change-title">
        <input type="text" name="title" onChange={onChange}></input>
        <button onClick={changeTitle}>Change Title (First Post)</button>
      </div>
      {postDetailsState && <PostDetails postDetails={postDetailsState} />}
    </div>
  );
};

export default Dashboard;
