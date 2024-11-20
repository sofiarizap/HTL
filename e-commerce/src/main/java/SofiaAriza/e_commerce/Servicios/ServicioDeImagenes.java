package SofiaAriza.e_commerce.Servicios;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public interface ServicioDeImagenes {

  final String directorioImagenes = "src/main/resources/static/images";

  public default String guardarImagen(MultipartFile imagen) throws IOException {
    if (imagen.isEmpty()) {
      throw new IllegalArgumentException("La imagen no puede estar vacía.");
    }

    // Generar un nombre único
    String nombreArchivo = UUID.randomUUID().toString() + "_" + imagen.getOriginalFilename();
    Path rutaArchivo = Paths.get(directorioImagenes, nombreArchivo);

    // Crear directorio si no existe
    Files.createDirectories(Paths.get(directorioImagenes));

    // Guardar la imagen
    Files.copy(imagen.getInputStream(), rutaArchivo);

    return "/images/" + nombreArchivo; // Ruta accesible desde la web
  }
}
