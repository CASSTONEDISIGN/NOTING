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
    align-items: center;
    justify-content: center;
    width: fit-content;
    background-color:#cdefed;
    padding: 0px 80px 0px 30px;
    min-height: 700px;
    margin-top: 10%;
    z-index: 10;
    opacity: 1;
  }
  </style>
  