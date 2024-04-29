<template>
  <div class="loading-wrap">
    <div class="loading-spinner"></div>
  </div>
</template>
<script></script>
<style scoped>
.loading-wrap {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  width: 100%;
  height: 100%;
  background-color: #0002;
  position: fixed;
  z-index: 9999;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
}
.loading-spinner {
  width: 40px;
  height: 40px;
  border: 5px solid #3498db;
  border-top: 5px solid transparent;
  border-radius: 50%;
  animation: rotate 1s linear infinite;
}

@keyframes rotate {
  from {
    transform: rotate(0deg);
  }
  to {
    transform: rotate(360deg);
  }
}
</style>
