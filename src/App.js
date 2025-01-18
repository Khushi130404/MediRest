import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Navbar from "./components/Navbar";

function App() {
  return (
    <Router>
      <Navbar />
      <div style={{ paddingTop: "80px" }}>
        <Routes>
          <Route path="/" element={<h2>Home Page</h2>} />
          <Route path="/about" element={<h2>About Us</h2>} />
          <Route path="/appointment" element={<h2>Book Appointment</h2>} />
          <Route path="/profile" element={<h2>User Profile</h2>} />
          <Route path="/register" element={<h2>Register</h2>} />
          <Route path="/login" element={<h2>Login</h2>} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
