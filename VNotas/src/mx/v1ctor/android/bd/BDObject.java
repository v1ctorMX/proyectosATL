
package mx.v1ctor.android.bd;

/**
 * Interfaz de ayuda a guardar objetos a BD de SQLite con 3 sencillos métodos para cada objeto
 * @author v1ctor
 * @since Septiembre 2012
 */
public interface BDObject {
	
	/**
	 * Creamos el objeto en BD 
	 * @return true si se guardó exitosamente
	 */
	public boolean create();
	
	/**
	 * Actualizamos el objeto que invoca el método a BD
	 * @return true si la actualización se realizó correctamente
	 */
	public boolean update();
	
	/**
	 * Borramos el objeto de BD
	 * @return true si el objeto se borró satisfactoriamente
	 */
	public boolean delete();
}
