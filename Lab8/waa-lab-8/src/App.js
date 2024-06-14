import "./App.css";
import Dashboard from "./containers/Dashboard/Dashboard";
import { PostIdProvider } from "./contexts/PostIdContext";

function App() {
  return (
    <div className="App">
      <h1>Welcome to WAA Lab-6 Activity</h1>
      <PostIdProvider>
        <Dashboard />
      </PostIdProvider>
    </div>
  );
}

export default App;
