
package com.practica01.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

public interface FirebaseStorageSevice {
    
     public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);

    //El BuketName es el <id_del_proyecto> + ".appspot.com"
    final String BucketName = "elarbol-5c03d.appspot.com";

    //Esta es la ruta básica de este proyecto elarbol
    final String rutaSuperiorStorage = "elarbol";

    //Ubicación donde se encuentra el archivo de configuración Json
    final String rutaJsonFile = "firebase";
    
    //El nombre del archivo Json
    final String archivoJsonFile = "elarbol-5c03d-firebase-adminsdk-95ubm-e72b32b7d6.json";
    
}
