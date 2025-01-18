import React from "react";
import Navbar from "./Navbar";
import Footer from "./Footer";
import Welcome from "./Welcome";
import Menu from "./Menu";
import HerosWithCape from "./HerosWithoutCape";

const HomePage = () => {
  return (
    <div>
      <Navbar />
      <Welcome></Welcome>
      <Menu></Menu>
      <HerosWithCape></HerosWithCape>
      <Footer />
    </div>
  );
};

export default HomePage;
