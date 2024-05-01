<template>
  <div id="login-box">
    <div>
      <h5 class="mb-4">LOGIN</h5>
      <input
        type="text"
        class="form-control mb-2"
        placeholder="ID"
        v-model="id"
      />
      <input
        type="password"
        class="form-control mb-4"
        placeholder="PASSWORD"
        v-model="password"
      />
      <button class="btn btn-primary w-100 fw-bold py-2" @click="login">
        로그인
      </button>
    </div>
  </div>
  <Loading v-if="isLoading" />
</template>
<script>
import axios from "axios";
import Loading from "@/components/Loading.vue";
import callsMixins from "@/mixins/callsMixins";

export default {
  components: { Loading },
  mixins: [callsMixins],
  data() {
    return {
      id: "",
      password: "",
      xhrToken: "",
      isLoading: false,
    };
  },
  methods: {
    async login() {
      const vm = this;
      if (!vm.id) {
        alert("아이디를 입력해주세요.");
        return;
      }

      if (!vm.password) {
        alert("비밀번호를 입력해주세요.");
        return;
      }

      vm.isLoading = true;
      vm.xhrToken = await vm.getToken();
      await axios
        .post(
          `http://localhost:8080/login`,
            {username:vm.id, password:vm.password},
          {
            headers: {
              "Content-type": "multipart/form-data",
              "X-XSRF-TOKEN": vm.xhrToken,
            },
          }
        )
        .then((res) => {
          console.log(res);
          console.log("header ", res.headers["Set-Cookie"])
          window.sessionStorage.setItem("fish-login", JSON.stringify(res));
          vm.$router.push("/link-menu");
        })
        .catch((err) => {
          console.log(err);
          alert("로그인 에러 발생");
          vm.isLoading = false;
        });
    },
  },
};
</script>
<style scoped>
#login-box {
  display: flex;
  align-items: center;
  justify-content: center;
  padding-top: 240px;
  background-color: #fff;
}

#login-box > div {
  padding: 24px;
  text-align: center;
  box-shadow: 1px 1px 5px rgba(0, 0, 0, 0.2);
}
</style>
