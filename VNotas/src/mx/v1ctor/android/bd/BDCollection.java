
package mx.v1ctor.android.bd;

import java.util.LinkedList;

/**
 * Permite trabajar con las colecciones de BDObject
 * @author v1ctor
 * @since Septiembre 2012
 */
public interface BDCollection {

	/**
	 * Regresa la cantidad de tuplas que habitan en la colección
	 * @return la cantidad de tuplas
	 */
	public long count();
	
	/**
	 * Regresa la colección en una lista de objectos, limitando por el número de parámetro
	 * @param count
	 * @return Las tuplas en lista de objetosBD
	 */
	public LinkedList<BDObject> retrieveN(long count);
	
	/**
	 * Regresa el objeto de BD que tenga el id indicado
	 * @param id el identificador
	 * @return EL objeto BD perteneciente a ese id
	 */
	public BDObject retrieve (long id);
}
