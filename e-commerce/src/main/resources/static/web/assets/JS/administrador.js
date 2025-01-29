const { createApp } = Vue;

createApp({
    data() {
        return {
            productos: [],
            url: "/productos", 
            editando: false,
            nuevoProducto: {
                nombre: "",
                precio: 0,
                stock: 0,
                descripcion: "",
                imagenUrl: "",
                ubicacion: "",
                categoria: "ropa",
                activo: true,
                oferta: false
            }
        };
    },
    created() {
        this.cargarDatos();
    },
    methods: {
        async cargarDatos() {
            try {
                const response = await axios.get(this.url);
                this.productos = response.data;
            } catch (error) {
                console.error("Error cargando productos:", error);
                alert("Hubo un problema al cargar los productos.");
            }
        },
        async agregarProducto() {
            if (!this.validarProducto(this.nuevoProducto)) return;
            
            try {
                if (this.editando) {
                    await axios.put(`${this.url}/${this.nuevoProducto.id}`, this.nuevoProducto);
                } else {
                    await axios.post(this.url, this.nuevoProducto);
                }
                this.cargarDatos();
                this.limpiarFormulario();
            } catch (error) {
                console.error("Error guardando producto:", error);
                alert("No se pudo guardar el producto.");
            }
        },
        editarProducto(producto) {
            this.nuevoProducto = { ...producto };
            this.editando = true;
        },
        async eliminarProducto(id) {
            if (confirm("¿Seguro que quieres eliminar este producto?")) {
                try {
                    await axios.delete(`${this.url}/${id}`);
                    this.cargarDatos();
                } catch (error) {
                    console.error("Error eliminando producto:", error);
                    alert("No se pudo eliminar el producto.");
                }
            }
        },
        limpiarFormulario() {
            this.nuevoProducto = {
                nombre: "",
                precio: 0,
                stock: 0,
                descripcion: "",
                imagenUrl: "",
                ubicacion: "",
                categoria: "",
                activo: true,
                oferta: false
            };
            this.editando = false;
        },
        validarProducto(producto) {
            if (!producto.nombre.trim()) {
                alert("El nombre es obligatorio.");
                return false;
            }
            if (producto.precio <= 0 || isNaN(producto.precio)) {
                alert("El precio debe ser un número positivo.");
                return false;
            }
            if (producto.stock < 0 || isNaN(producto.stock)) {
                alert("El stock no puede ser negativo.");
                return false;
            }
            if (!producto.descripcion.trim()) {
                alert("La descripción es obligatoria.");
                return false;
            }
            if (!producto.imagenUrl.trim()) {
                alert("La URL de la imagen es obligatoria.");
                return false;
            }
            if (!producto.ubicacion.trim()) {
                alert("La ubicación es obligatoria.");
                return false;
            }
            return true;
        }
    }
}).mount("#app");


  
/*createApp({
    data(){
        return{
            cliente: undefined,
            clientes: [],
            productos: [],
            clientesVisibles: [],
            productosVisibles: [],
            totalPaginasCli: 1,
            totalPaginasPro: 1,
            paginaNumeroCli: 1,
            paginaNumeroPro: 1,
            numPaginasArrayCli: [],
            numPaginasArrayPro: [],
            numPaginasVisibleCli: [],
            numPaginasVisiblePro: [],
            moduloPaginadoActualCli: 0,
            moduloPaginadoActualPro: 0,
            clienteModif: undefined,
            productoModif: undefined,
            clienteFinal: undefined,
            productoFinal: undefined,
            clienteNuevo: {
                nombre: "",
                apellido: "",
                direccion: "",
                email: "",
                telefono: "",
            },
            productoNuevo: {
                nombre: "",
                precio: undefined,
                stock: undefined,
                descripcion: "",
                imagenUrl: "",
                categoria: "",
            },
            
            sinError: true,
        }
    },

    created(){
        this.cargarDatos();
    },

    methods: {

        cargarDatos: function(){

            let clientes = axios.get('/clientes');
            let productos = axios.get('/productos');

            Promise.all([clientes, productos])
                    .then(respuesta => {
                        console.log(respuesta);
                        this.clientes = respuesta[0].data.map(cliente => ({...cliente})).sort((c1, c2) => c1.id - c2.id);
                        this.productos = respuesta[1].data.map(producto => ({... producto})).sort((p1, p2) => p1.id - p2.id);

                        this.administrarDatos();
                    })

        },

        administrarDatos: function(){
            this.renderClientes();
            this.renderProductos();
        },


        crearProducto(){

            this.sinError = true;
            console.log(this.clienteNuevo);
            if(!this.productoNuevo.nombre || !this.productoNuevo.precio || !this.productoNuevo.stock || !this.productoNuevo.descripcion || !this.productoNuevo.imagenUrl || !this.clienteNuevo.categoria){
                this.sinError = false;
            }
            else {

                Swal.fire({
                    customClass: 'modal-sweet-alert',
                    title: 'Por favor confirme la creación del producto',
                    text: "Si acepta se procederá a la creación del producto. Si quiere anular la petición, solo haga clic en el boton 'Cerrar'.",
                    icon: 'warning',
                    showCancelButton: true,
                    confirmButtonColor: '#f7ba24',          
                    cancelButtonColor: '#d33',
                    cancelButtonText: 'Cerrar',
                    confirmButtonText: 'Aceptar'
                }).then((result) => {
                    if (result.isConfirmed) {
                        axios.post('/api/crear-producto', {nombre: this.productoNuevo.precio, precio: this.productoNuevo.precio, stock: this.productoNuevo.stock, descripcion: this.productoNuevo.descripcion, imagenUrl: this.productoNuevo.imagenURL, categoria: this.productoNuevo.categoria,})
                        .then(response => {
                            
                            Swal.fire({
                                customClass: 'modal-sweet-alert',
                                text: "Producto creado!",
                                icon: 'success',
                                confirmButtonText: 'Aceptar'
                            }).then((result) => {
                                location.reload(); 
                            })
                        })
                        .catch(err =>{
                           console.log([err])
               
                           Swal.fire({
                               customClass: 'modal-sweet-alert',
                               icon: 'error',
                               title: 'Ups...',
                               text: err.message.includes('403')? err.response.data: "Hubo un error inesperado",
                           })
                        })
                    }
                  })
            }        
        },

        

        modifCliente(){

            this.clienteFinal = undefined;
            this.sinError = true;
            if(!this.clienteModif.nombre || !this.clienteModif.apellido || !this.clienteModif.direccion || !this.clienteModif.telefono || !this.clienteModif.email){
                this.sinError = false;
            }
            else {
                this.clienteFinal = {... this.clienteModif};

                Swal.fire({
                    customClass: 'modal-sweet-alert',
                    title: 'Por favor confirme la modificacion del cliente',
                    text: "Si acepta se procederá a la modificación del cliente. Si quiere anular la petición, solo haga clic en el boton 'Cerrar'.",
                    icon: 'warning',
                    showCancelButton: true,          
                    cancelButtonColor: '#d33',
                    confirmButtonColor: '#f7ba24',
                    cancelButtonText: 'Cerrar',
                    confirmButtonText: 'Aceptar'
                }).then((result) => {
                    if (result.isConfirmed) {
                        this.clienteFinal.activo
                        axios.patch('/api/modificar-cliente',{id: this.clienteFinal.id,nombre: this.clienteFinal.nombre, apellido: this.clienteFinal.apellido, direccion: this.clienteFinal.direccion, email: this.clienteFinal.email, telefono: this.clienteFinal.telefono})
                        .then(response => {
                            
                            Swal.fire({
                                customClass: 'modal-sweet-alert',
                                text: "Cliente modificado!",
                                icon: 'success',
                                confirmButtonText: 'Aceptar'
                            }).then((result) => {
                                location.reload(); 
                            })
                        })
                        .catch(err =>{
                           console.log([err])
               
                           Swal.fire({
                               customClass: 'modal-sweet-alert',
                               icon: 'error',
                               title: 'Ups...',
                               text: err.message.includes('403')? err.response.data: "Hubo un error inesperado",
                           })
                        })
                    }
                  })
            }
        },


        modifProd(){
            this.productoFinal = undefined;
            this.sinError = true;
    
            if(!this.productoModif.categoria || !this.productoModif.descripcion || !this.productoModif.imagenUrl || !this.productoModif.nombre || !this.productoModif.precio || !this.productoModif.stock){
                this.sinError = false;
            }
            else {
                this.productoFinal = {... this.productoModif};

                Swal.fire({
                    customClass: 'modal-sweet-alert',
                    title: 'Por favor confirme la modificacion del producto',
                    text: "Si acepta se procederá a la modificación del producto. Si quiere anular la petición, solo haga clic en el boton 'Cerrar'.",
                    icon: 'warning',
                    showCancelButton: true,          
                    cancelButtonColor: '#d33',
                    confirmButtonColor: '#f7ba24',
                    cancelButtonText: 'Cerrar',
                    confirmButtonText: 'Aceptar'
                    }).then((result) => {
                        if (result.isConfirmed) {
                            axios.patch('/api/modificar-producto',{'id': this.productoFinal.id, 'nombre': this.productoFinal.nombre, 'descripcion': this.productoFinal.descripcion, 'precio': this.productoFinal.precio, 'stock': this.productoFinal.stock, 'categoria': this.productoFinal.categoria, 'ImagenUrl': this.productoFinal.ImagenUrl})
                            .then(response => {
                                
                                Swal.fire({
                                    customClass: 'modal-sweet-alert',
                                    text: "Producto modificado!",
                                    icon: 'success',
                                    confirmButtonText: 'Aceptar'
                                }).then((result) => {
                                    location.reload(); 
                                })
                            })
                            .catch(err =>{
                            console.log([err])
                
                            Swal.fire({
                                customClass: 'modal-sweet-alert',
                                icon: 'error',
                                title: 'Ups...',
                                text: err.message.includes('403')? err.response.data: "Hubo un error inesperado",
                            })
                            })
                        }
                })
            }
        },

        

        borrarCliente(cliente){
            Swal.fire({
                customClass: 'modal-sweet-alert',
                title: 'Por favor confirmar la cancelación del cliente',
                text: `Si acepta, el cliente ${cliente.nombre + cliente.apellido} será cancelado. El cliente no podrá acceder a su usario y sus recursos. Si desea cancelar la petición, solo haga clic en el boton 'Cerrar'.`,
                icon: 'warning',
                showCancelButton: true,          
                cancelButtonColor: '#d33',
                confirmButtonColor: '#f7ba24',
                cancelButtonText: 'Cerrar',
                confirmButtonText: 'Aceptar'
            }).then((result) => {
                if (result.isConfirmed) {
                    cliente.activo = false;
                    axios.patch('/api/modificar-cliente',{id: cliente.id,nombre: cliente.nombre, apellido: cliente.apellido, direccion: cliente.direccion, email: cliente.email, telefono: cliente.telefono})
                    .then(response => {
                        Swal.fire({
                            customClass: 'modal-sweet-alert',
                            text: "Cliente cancelado",
                            icon: 'success',
                            confirmButtonText: 'Aceptar'
                        }).then((result) => {
                            location.reload(); 
                        })
                    })
                    .catch(err =>{
                       console.log([err])
           
                       Swal.fire({
                           customClass: 'modal-sweet-alert',
                           icon: 'error',
                           title: 'Ups...',
                           text: err.message.includes('403')? err.response.data: "Ha surgido un error imprevisto.",
                       })
                    })
                }
              })
        },

        borrarProducto(producto){
            Swal.fire({
                customClass: 'modal-sweet-alert',
                title: 'Por favor confirmar la cancelación del producto',
                text: `Si acepta, el producto ${producto.nombre} será cancelado. El mismo no podrá ser accedido en futuras transacciones. Si desea cancelar la petición, solo haga clic en el boton 'Cerrar'.`,
                icon: 'warning',
                showCancelButton: true,          
                cancelButtonColor: '#d33',
                confirmButtonColor: '#f7ba24',
                cancelButtonText: 'Cerrar',
                confirmButtonText: 'Aceptar'
            }).then((result) => {
                if (result.isConfirmed) {
                    producto.activo = false;
                    axios.patch('/api/deshabilitar-producto',`id=${producto.id}`,{headers:{'content-type':'application/x-www-form-urlencoded'}})
                    .then(response => {
                        Swal.fire({
                            customClass: 'modal-sweet-alert',
                            text: "Producto cancelado",
                            icon: 'success',
                            confirmButtonText: 'Aceptar'
                        }).then((result) => {
                            location.reload(); 
                        })
                    })
                    .catch(err =>{
                       console.log([err])
           
                       Swal.fire({
                           customClass: 'modal-sweet-alert',
                           icon: 'error',
                           title: 'Ups...',
                           text: err.message.includes('403')? err.response.data: "Ha surgido un error imprevisto.",
                       })
                    })
                }
              })
        },

        

        activarCliente(cliente){
            Swal.fire({
                customClass: 'modal-sweet-alert',
                title: 'Por favor confirmar la activación del cliente',
                text: `Si acepta, el cliente ${cliente.nombre + cliente.apellido} será activado. El cliente volverá acceder a su usario y sus recursos. Si desea cancelar la petición, solo haga clic en el boton 'Cerrar'.`,
                icon: 'warning',
                showCancelButton: true,          
                cancelButtonColor: '#d33',
                confirmButtonColor: '#f7ba24',
                cancelButtonText: 'Cerrar',
                confirmButtonText: 'Aceptar'
            }).then((result) => {
                if (result.isConfirmed) {
                    cliente.activo = true;
                    axios.patch('/api/modificar-cliente',{id: cliente.id,nombre: cliente.nombre, apellido: cliente.apellido, direccion: cliente.direccion, email: cliente.email, telefono: cliente.telefono, activo: cliente.activo})
                    .then(response => {
                        Swal.fire({
                            customClass: 'modal-sweet-alert',
                            text: "Cliente activado",
                            icon: 'success',
                            confirmButtonText: 'Aceptar'
                        }).then((result) => {
                            location.reload(); 
                        })
                    })
                    .catch(err =>{
                       console.log([err])
           
                       Swal.fire({
                           customClass: 'modal-sweet-alert',
                           icon: 'error',
                           title: 'Ups...',
                           text: err.message.includes('403')? err.response.data: "Ha surgido un error imprevisto.",
                       })
                    })
                }
              })
        },

        activarProducto(producto){
            Swal.fire({
                customClass: 'modal-sweet-alert',
                title: 'Por favor confirmar la activación del producto',
                text: `Si acepta, el producto ${producto.nombre} será activado. El mismo volverá a ser accedido en futuras transacciones. Si desea cancelar la petición, solo haga clic en el boton 'Cerrar'.`,
                icon: 'warning',
                showCancelButton: true,          
                cancelButtonColor: '#d33',
                confirmButtonColor: '#f7ba24',
                cancelButtonText: 'Cerrar',
                confirmButtonText: 'Aceptar'
            }).then((result) => {
                if (result.isConfirmed) {
                    producto.activo = true;
                    axios.patch('/api/modificar-producto',{'id': producto.id, 'nombre': producto.nombre, 'descripcion': producto.descripcion, 'precio': producto.precio, 'stock': producto.stock, 'categoria': producto.categoria, 'ImagenUrl': producto.ImagenUrl, 'activo': producto.activo})
                    .then(response => {
                        Swal.fire({
                            customClass: 'modal-sweet-alert',
                            text: "Producto activado",
                            icon: 'success',
                            confirmButtonText: 'Aceptar'
                        }).then((result) => {
                            location.reload(); 
                        })
                    })
                    .catch(err =>{
                       console.log([err])
           
                       Swal.fire({
                           customClass: 'modal-sweet-alert',
                           icon: 'error',
                           title: 'Ups...',
                           text: err.message.includes('403')? err.response.data: "Ha surgido un error imprevisto.",
                       })
                    })
                }
              })
        },

        

        renderClientes: function(){

            let tamanio = this.clientes.length;
            let contador = 0;
            let renglonesElementos = [];

            while(contador < tamanio){
                renglonesElementos.push(this.clientes.slice(contador, contador+=10));
            }

            this.totalPaginasCli = renglonesElementos.length;
            if(this.totalPaginasCli === 1){
                this.paginaNumeroCli = 1;
            }
            this.clientesVisibles = renglonesElementos[this.paginaNumeroCli - 1];
            if(!this.clientesVisibles){
                this.clientesVisibles = [];
            }
            let numeros = [];
            for(let i = 1; i <= this.totalPaginasCli; i++){
                numeros.push(i);
            }
            contador = 0;
            this.numPaginasArrayCli = [];
            while(contador < this.totalPaginasCli){
                this.numPaginasArrayCli.push( numeros.slice(contador, contador+=3) );
            }
            this.numPaginasVisibleCli = this.numPaginasArrayCli[this.moduloPaginadoActualCli];
        },

        cambiarPaginaCli: function(movimientos){
            this.paginaNumeroCli += movimientos;
            this.moduloPaginadoActualCli = Math.floor((this.paginaNumeroCli - 1) / 3);
            console.log(this.moduloPaginadoActualCli);
            this.renderClientes();
        },

        irAPaginaCli: function(page){
            this.paginaNumeroCli = page;
            this.renderClientes();
        },


        renderProductos: function(){

            let tamanio = this.productos.length;
            let contador = 0;
            let renglonesElementos = [];

            while(contador < tamanio){
                renglonesElementos.push(this.productos.slice(contador, contador+=10));
            }

            this.totalPaginasPro = renglonesElementos.length;
            if(this.totalPaginasPro === 1){
                this.paginaNumeroPro = 1;
            }
            this.productosVisibles = renglonesElementos[this.paginaNumeroPro - 1];
            if(!this.productosVisibles){
                this.productosVisibles = [];
            }
            let numeros = [];
            for(let i = 1; i <= this.totalPaginasPro; i++){
                numeros.push(i);
            }
            contador = 0;
            this.numPaginasArrayPro = [];
            while(contador < this.totalPaginasPro){
                this.numPaginasArrayPro.push( numeros.slice(contador, contador+=3) );
            }
            this.numPaginasVisiblePro = this.numPaginasArrayPro[this.moduloPaginadoActualPro];
        },

        cambiarPaginaPro: function(movimientos){
            this.paginaNumeroPro += movimientos;
            this.moduloPaginadoActualPro = Math.floor((this.paginaNumeroPro - 1) / 3);
            console.log(this.moduloPaginadoActualPro);
            this.renderProductos();
        },

        irAPaginaPro: function(page){
            this.paginaNumeroPro = page;
            this.renderProductos();
        },


        
    }

}).mount("#app")*/