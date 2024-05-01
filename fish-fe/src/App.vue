<template>
  <router-view></router-view>
</template>
<script>
export default {
  created() {
    const vm = this;
    const loginInfo = window.sessionStorage.getItem("fish-login");
    if (!loginInfo) vm.$router.push("/");
  },
};
</script>
<style>
@import url("https://cdn.jsdelivr.net/gh/orioncactus/pretendard/dist/web/static/pretendard.css");
* {
  font-family: "Pretendard";
  margin: 0;
  padding: 0;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  font-size: 14px;
  word-break: break-all;
}
.container {
  min-width: 1320px;
  overflow-x: scroll;
}
.plate {
  background-color: #ece9d8;
  display: flex;
}
table {
  margin-bottom: 0 !important;
}
table th,
table td {
  vertical-align: middle;
  background-color: #ece9d8 !important;
  padding: 4px !important;
}
table th {
  text-align: center;
  width: 70px;
}
.btn {
  width: 82px;
}
.btn-primary {
  background-color: #ffe0c0;
  color: #000;
  border-color: #ccc;
}
.btn-primary:hover {
  background-color: #ffca94;
  border-color: #ccc;
  color: #000;
}
label {
  display: block;
  cursor: pointer;
  align-items: center;
  display: flex;
}
</style>
