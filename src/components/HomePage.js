import React from "react";
import Navbar from "./Navbar";
import Footer from "./Footer";
import Welcome from "./Welcome";
import Menu from "./Menu";

const HomePage = () => {
  return (
    <div>
      <Navbar />
      <Welcome></Welcome>
      <Menu></Menu>
      <Footer />
    </div>
  );
};

export default HomePage;
