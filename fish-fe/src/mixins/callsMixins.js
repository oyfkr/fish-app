export default {
  methods: {
    async getToken() {
      const vm = this;
      await axios
        .get(`http://localhost:8080/csrf-token`)
        .then((res) => {
          console.log(res);
          vm.xhrToken = res;
        })
        .catch((err) => {
          console.log(err);
          alert("토큰 에러 발생");
          vm.isLoading = false;
        });
    },
  },
};
