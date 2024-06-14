import { createContext, useState, useContext } from "react";

const PostIdContext = createContext();

export const PostIdProvider = ({ children }) => {
  const [postId, setPostId] = useState(null);

  return (
    <PostIdContext.Provider value={[postId, setPostId]}>
      {children}
    </PostIdContext.Provider>
  );
};

// Custom hook for easy consumption
export const usePostId = () => useContext(PostIdContext);
