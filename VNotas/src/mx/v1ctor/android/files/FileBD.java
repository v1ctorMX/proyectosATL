package mx.v1ctor.android.files;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

/**
 * Permite cargar un archivo desde el directorio assets
 * 
 * @author v1ctor
 * @since Septiembre 2012
 */
public class FileBD {
	private Context context;
	private String fileName = "";
	private String fileString = "";

	/**
	 * Pasamos un contexto para poder obtener la facilidad de acceso al
	 * directorio assets
	 * 
	 * @param context
	 *            El contexto para sacar el directorio
	 */
	public FileBD(Context context, String file) {
		this.context = context;
		this.fileName = file;
	}

	/**
	 * Obtiene el archivo y lo convierte en una cadena para poderlo usar en la
	 * creación de la BD, etc.
	 * 
	 * @return El archivo completo en una línea.
	 * @throws IOException
	 */
	public String getFile() throws IOException {

		try {
			// obtiene el manejador de archivos en assets
			AssetManager assetManager = context.getAssets();

			// obtiene el archivo que necesitamos. (lanza excepción)
			InputStream isr = assetManager.open(fileName);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(isr));
			StringBuilder archivoCompleto = new StringBuilder();
			
			String linea = "";
			while ( (linea = br.readLine()) != null) {
				archivoCompleto.append(linea);				
			}// regresa el archivo en una línea.

			fileString = archivoCompleto.toString();

			br.close();
		} catch (FileNotFoundException fnfe) {
			Log.e("ERROR", "FILE NOT FOUND EXCEPTION");
			return "Archivo no encontrado";
		}
		return fileString;
	}// getFile

}// FileM
