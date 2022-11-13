<template>
  <v-app>
    <v-content>
      <router-view></router-view>
    </v-content>
  </v-app>
</template>

<script>
export default {
  name: "App",

  components: {},

  data: () => ({
    //
  }),
};
</script>

<style>
@font-face {
  font-family: "Alice-Regular";
  src: url("assets/alice/Alice-Regular.ttf") format("truetype");
  font-weight: normal;
}
.v-application {
  font-family: "Alice-Regular", sans-serif !important;
}
</style>
