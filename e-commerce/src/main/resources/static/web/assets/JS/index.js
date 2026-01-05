const { createApp } = Vue;

function toDirectDriveUrl(url) {
  if (!url) return './assets/imagenes/no-disponible.png';
  const s = String(url);

  // /file/d/ID/...
  let m = s.match(/\/file\/d\/([^/]+)/);
  if (m) return `https://drive.google.com/uc?export=view&id=${m[1]}`;

  // /d/ID/...
  m = s.match(/\/d\/([^/]+)/);
  if (m) return `https://drive.google.com/uc?export=view&id=${m[1]}`;

  // ?id=ID  (open?id=..., uc?id=..., thumbnail?id=...)
  m = s.match(/[?&](?:id|uc|thumbnail)=([^&]+)/);
  if (m) return `https://drive.google.com/uc?export=view&id=${m[1]}`;

  // /folders/ID no es imagen directa → placeholder
  if (/\/folders\//.test(s)) {
    return './assets/imagenes/no-disponible.png';
  }

  // Cualquier otra (ruta local o URL directa)
  return s;
}

createApp({
  data() {
    return {
      mensaje: "holi",
      productos: []
    };
  },
  computed: {
    productosFiltrados() {
      return (this.productos || []).filter(p => p.activo);
    }
  },
  methods: {
    toDirectDriveUrl, // disponible para usarlo en el template si quieres
    imagenError(event) {
      event.target.src = './assets/imagenes/no-disponible.png';
    },
    agregarAlCarrito(producto) {
      const carrito = JSON.parse(localStorage.getItem('carrito') || '[]');
      const idx = carrito.findIndex(p => p.id === producto.id);
      if (idx > -1) {
        carrito[idx].cantidad += 1;
      } else {
        carrito.push({ ...producto, cantidad: 1 });
      }
      localStorage.setItem('carrito', JSON.stringify(carrito));
      alert("Producto agregado al carrito");
    }
  },
  created() {
    axios.get("/productos")
      .then(res => {
        const data = Array.isArray(res.data) ? res.data : [];
        // Normalizamos el campo de imagen y convertimos a URL directa si es Drive
        this.productos = data.map(p => {
          const cruda = p.imagenUrl ?? p.imagenURL ?? p.urlImagen ?? p.image ?? p.img;
          return {
            ...p,
            imagenUrl: toDirectDriveUrl(cruda)
          };
        });
        // Útil para verificar URLs efectivas en consola
        console.log("Ejemplo producto:", this.productos[0]);
      })
      .catch(err => console.error("Error cargando productos:", err));
  }
}).mount('#app');

