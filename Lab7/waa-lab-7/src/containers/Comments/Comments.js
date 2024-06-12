import React, { useEffect, useState } from "react";
import Comment from "../../components/Comment/Comment";
const Comments = (props) => {
  console.log("I am in Comments");
  const commentsList = props.commentsList.map((commentObj) => {
    return (
      <Comment
        name={commentObj.name}
        comment={commentObj.comment}
        key={commentObj.id}
      />
    );
  });

  return commentsList;
};

export default Comments;
