const { createApp } = Vue;

createApp({
  data() {
    return {
      producto: null
    };
  },
  created() {
    const params = new URLSearchParams(window.location.search);
    const id = params.get("id");
    axios.get("/productos/" + id).then(res => {
      this.producto = res.data;
    });
  }
}).mount('#app');
