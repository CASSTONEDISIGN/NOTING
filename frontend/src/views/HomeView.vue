<script setup>
import { RouterLink } from "vue-router";

const opnelist = () => {

}

</script>

<template>
  <div class="home">
    <header>
      <div class="logo">
        <img src="../assets/favicon.ico" class="ringing" alt="logo" />
        <!-- <img src="../assets/No Wating.png" class="hide" alt="No Wating" />
        <img src="../assets/Noting.png" class="appear" alt="Noting" /> -->
      </div>
      <nav>
        <button class="account_button" type="button" onclick="openlist">
          <div>아이콘</div>
          <span>내 계정</span>
          <div>밑 화살표</div>
        </button>
        <!-- <RouterLink to="/login/deligate">사장 로그인</RouterLink>
        <RouterLink to="/login/customer">고객 로그인</RouterLink> -->
      </nav>
    </header>
    <main>Main</main>
    <footer>footer</footer>
  </div>
</template>

<style lang="scss" scoped>
@font-face {
  font-family: "Aloevera";
  src: url("../assets/Aloevera-OVoWO.ttf") format("truetype");
  font-weight: 700;
}
header {
  width: 90vw;
  height: min-content;
  display: flex;
  padding: 0 1.5rem;
  justify-content: space-between;
  font-family: Aloevra;
  align-items: center;
}
nav {
  display: flex;
  gap: 1rem;
  .account_button{
    display: flex;
    background-color: rgb(167, 168, 169);
    border: none;
  }
  .account_button:hover{
    cursor: pointer;
    background-color: rgb(209, 211, 212);
  }
  .choice_list{
    font-size: 12px;
    line-height: 15px;
    padding: 8px 16px;
    color: rgb(23, 43, 77);
  }
}

main {
  height: 120vh;
  background-color: #adff2f;
}
.home {
  display: flex;
  flex-direction: column;
}

//logo
.logo {
  width: fit-content;
  .hide {
    -webkit-animation: flip-in-hor-bottom 1s
      cubic-bezier(0.25, 0.46, 0.45, 0.94) both;
    animation: flip-in-hor-bottom 1s cubic-bezier(0.25, 0.46, 0.45, 0.94) both;
    animation-delay: 1.5s;
  }

  .appear {
    -webkit-animation: flip-in-hor-top 1s cubic-bezier(0.25, 0.46, 0.45, 0.94)
      both;
    animation: flip-in-hor-top 1s cubic-bezier(0.25, 0.46, 0.45, 0.94) both;
    animation-delay: 1.5s;
  }
  .ringing {
    width: 80px;
  }
}

//keyframes
@-webkit-keyframes flip-in-hor-bottom {
  0% {
    -webkit-transform: rotateX(0);
    transform: rotateX(0);
    opacity: 1;
  }
  20% {
    -webkit-transform: rotateX(80deg);
    transform: rotateX(80deg);
  }
  100% {
    -webkit-transform: rotateX(0);
    transform: rotateX(0);
    opacity: 0;
  }
}
@keyframes flip-in-hor-bottom {
  0% {
    -webkit-transform: rotateX(0);
    transform: rotateX(0);
    opacity: 1;
  }
  20% {
    -webkit-transform: rotateX(80deg);
    transform: rotateX(80deg);
  }
  100% {
    -webkit-transform: rotateX(0);
    transform: rotateX(0);
    opacity: 0;
  }
}
@-webkit-keyframes flip-in-hor-top {
  0% {
    -webkit-transform: rotateX(0);
    transform: rotateX(0);
    opacity: 0;
  }
  20% {
    -webkit-transform: rotateX(80deg);
    transform: rotateX(80deg);
  }
  100% {
    -webkit-transform: rotateX(0);
    transform: rotateX(0);
    opacity: 1;
  }
}
@keyframes flip-in-hor-top {
  0% {
    -webkit-transform: rotateX(0);
    transform: rotateX(0);
    opacity: 0;
  }
  20% {
    -webkit-transform: rotateX(80deg);
    transform: rotateX(80deg);
  }
  100% {
    -webkit-transform: rotateX(0);
    transform: rotateX(0);
    opacity: 1;
  }
}

/* header {
    position: absolute;
  
    background-color: rgb(108, 189, 108);
  }
  
  .logo {
    display: block;
    margin: 0 auto 2rem;
  }
  
  nav {
    width: 100%;
    font-size: 12px;
    text-align: center;
    margin-top: 2rem;
  }
  
  nav a.router-link-exact-active {
    color: var(--color-text);
  }
  
  nav a.router-link-exact-active:hover {
    background-color: transparent;
  }
  
  nav a {
    display: inline-block;
    padding: 0 1rem;
    border-left: 1px solid var(--color-border);
  }
  
  nav a:first-of-type {
    border: 0;
  }
  
  @media (min-width: 1024px) {
    header {
      display: flex;
      place-items: center;
      padding-right: calc(var(--section-gap) / 2);
    }
  
    .logo {
      margin: 0 2rem 0 0;
    }
  
    header .wrapper {
      display: flex;
      place-items: flex-start;
      flex-wrap: wrap;
    }
  
    nav {
      text-align: left;
      margin-left: -1rem;
      font-size: 1rem;
  
      padding: 1rem 0;
      margin-top: 1rem;
    }
  } */
</style>
