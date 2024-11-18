const {createApp} = Vue;

createApp({
    data(){
        return{
            mensaje:`hola`,
            categoria: [],
            url:"",
            productos:"",
            productosActivos:"",
            categorias: [],
            productosFiltrados: [],
            checked: [],
            inputBusqueda: "",
        }
    },
    created(){
    this.url = "/api/productos";
    this.loadData() 

    
    },
    methods: {
        loadData: function(){
            axios.get(this.url)
            .then( res =>{
              this.productos= res.data;
              this.productosActivos= this.productos.filter(producto => producto.Activo == true)
              this.productosFiltrados = res.data.map(producto => ({ ...producto }));
              this.categorias = [... new Set(this.productos.map(producto => producto.categoria))];
              console.log(this.productos)
            })
            .catch((error)=>{console.log(error)})
        },
    
        async cargarImagen(event) {
            const archivo = event.target.files[0];
            const formData = new FormData();
            formData.append("imagen", archivo);
    
            const respuesta = await axios.post("/productos/imagen", formData);
            this.producto.imagenUrl = respuesta.data; // Guarda la URL de la imagen
        },
        async agregarProducto() {
            await axios.post("/productos", this.producto);
            alert("Producto agregado correctamente");
        }
    
    }}
).mount('#app')