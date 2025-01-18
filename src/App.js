import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Navbar from "./components/Navbar";
import Footer from "./components/Footer";
import HomePage from "./components/HomePage";

function App() {
  return (
    <Router>
      <div>
        <Routes>
          <Route path="/" element={<HomePage></HomePage>} />
          <Route path="/about" element={<h2>About Us</h2>} />
          <Route path="/appointment" element={<h2>Book Appointment</h2>} />
          <Route path="/profile" element={<h2>User Profile</h2>} />
          <Route path="/register" element={<h2>Register</h2>} />
          <Route path="/login" element={<h2>Login</h2>} />
        </Routes>
      </div>
      {/* <HomePage></HomePage> */}
    </Router>
  );
}

export default App;
