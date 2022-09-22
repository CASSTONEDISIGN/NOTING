<template>
  <h1>Hello</h1>
</template>

<script>
import apiTest from "../API/GET/get";

export default {
  mounted() {
    apiTest
      .getArticle(1)
      .then(function (response) {
        console.log("getArticle", response);
      })
      .catch(function (e) {
        console.log(e);
      });
  },
};
</script>

<style>

</style>