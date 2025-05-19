import { BrowserRouter, Routes, Route } from "react-router-dom";
// import Home from "./Home";
// import Login from "./Login";
// import Register from "./Register";
import Catalogue from "./Catalogue";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        {/* <Route path="/" element={<Home />} />
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} /> */}
        <Route path="/catalogue" element={<Catalogue />} />
      </Routes>
    </BrowserRouter>
  );
}
export default App;
