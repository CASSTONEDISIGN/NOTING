<script setup>
import { RouterLink } from "vue-router";
</script>

<template>
  <header>
    <span class="logo"> Noting </span>
    <nav>
      <RouterLink to="/login/deligate">사장 로그인</RouterLink>
      <RouterLink to="/login/customer">고객 로그인</RouterLink>
    </nav>
  </header>
  <main>Main</main>
</template>

<style scoped>
  @font-face {
  font-family:'Aloevera';
  src: url('../assets/Aloevera-OVoWO.ttf') format('truetype');
  font-weight: 700;
}
header {
  width: 90vw;
  height: min-content;
  display: flex;
  padding: 1.5rem;
  justify-content: space-between;
  font-family: Aloevra;
}
nav {
  display: flex;
  gap: 1rem;
}
.logo{
  font-family: Aloevra;
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
