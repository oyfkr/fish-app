import axios from "axios";
export default {
  methods: {
    async getToken() {
      let xhrToken = "";
      await axios
        .get(`http://localhost:8080/csrf-token`)
        .then((res) => {
          console.log(res);
          xhrToken = res.data;
        })
        .catch((err) => {
          console.log(err);
          alert("토큰 에러 발생");
          vm.isLoading = false;
        });
      return xhrToken;
    },
  },
};
