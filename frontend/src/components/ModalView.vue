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
  margin-top: 82px;
  background-color:#cdefed;
  padding: 20px;
  min-height: 800px;
  z-index: 10;
  opacity: 1;
}
</style>
