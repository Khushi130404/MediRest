import React from "react";
import styles from "./Welcome.module.css";

const Welcome = () => {
  return (
    <div>
      <div className={styles.box}>
        <div className={styles.hero}>
          <div className={styles.title}>
            <div className={styles.textWelcome}>
              <div className={styles.textWrapperWelcome}>
                Welcome to MediCure
              </div>
              <p className={styles.divWelcome}>
                Lorem ipsum dolor sit amet consectetur adipisicing elit.
                Assumenda, voluptatum!
              </p>
            </div>
            <div className={styles.buttons}>
              <div className={styles.containerBook}>
                <a href="home.html" style={{ textDecoration: "none" }}>
                  <p className={styles.animatedWord}>Book An Appointment</p>
                </a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Welcome;
