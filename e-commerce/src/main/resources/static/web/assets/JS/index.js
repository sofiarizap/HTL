const {createApp} = Vue;

createApp({
    data(){
        return{
            
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
    this.url = "/productos";
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
              console.log(this.productos.map(producto => producto.categoria))
            })
            .catch((error)=>{console.log(error)})
        },
        
        busquedaCruzada: function () {
            let filtroInput = this.productos.filter(producto => producto.nombre.toLowerCase().includes(this.inputBusqueda.toLowerCase()))
            if (this.checked.length === 0) {
                this.productosFiltrados = filtroInput
            } else {
                let filtroCheck = filtroInput.filter(categoria => this.checked.includes(categoria.categoria))
                this.productosFiltrados = filtroCheck
            }
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