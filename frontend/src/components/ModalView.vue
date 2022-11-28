<template>
  <div class="modal">
    <div class="overlay" @click="$emit('close-modal')"></div>
    <div class="modal-card">
      <slot />
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style>
.modal,
.overlay {
  width: 100%;
  height: 100%;
  position: fixed;
  left: 0;
  right: 0;
  z-index: 10;
}
.overlay {
  opacity: 0.5;
  background-color: black;
}
.modal-card {
  position: relative;
  display: flex;
  align-self: center;
  justify-content: center;
  max-width: 40%;
  margin: auto;
  margin-top: 5%;
  background-color:#cdefed;
  padding: 0, 80px;
  min-height: 700px;
  z-index: 10;
  margin-left: 700px;
  opacity: 1;
}
</style>
