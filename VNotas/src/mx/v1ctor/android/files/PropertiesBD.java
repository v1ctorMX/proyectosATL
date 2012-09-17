package mx.v1ctor.android.files;

import mx.v1ctor.android.vnotas.R;
import android.content.Context;

/**
 * 
 * Clase que nos sirve para calcular de disco los nombres que se usarán en el
 * proyecto en base de datios.
 * 
 * @author v1ctor
 * @since Septiembre 2012
 */
public class PropertiesBD {

	/**
	 * CONFIGURACIÓN BD
	 */
	private final String BD;
	private final String SQL;
	private final int VERSION;

	/**
	 * TABLAS
	 */
	private final String TA_NOTES;

	/**
	 * COLUMNAS
	 */
	private final String ID;
	private final String TEXT;

	/**
	 * Obtenemos R
	 * 
	 * @param context
	 */
	public PropertiesBD(Context context) {

		BD = context.getString(R.string.bd_baseDB);
		SQL = context.getString(R.string.bd_baseSQL);
		VERSION = Integer.parseInt(context.getString(R.string.bd_version));
		TA_NOTES = context.getString(R.string.bd_tabla);
		ID = context.getString(R.string.bd_idNote);
		TEXT = context.getString(R.string.bd_tTexto);
	}

	/**
	 * @return the SQL
	 */
	public String getSQL() {
		return SQL;
	}

	/**
	 * @return the bD
	 */
	public String getBD() {
		return BD;
	}

	/**
	 * @return the vERSION
	 */
	public int getVERSION() {
		return VERSION;
	}

	/**
	 * @return the tA_NOTES
	 */
	public String getTA_NOTES() {
		return TA_NOTES;
	}

	/**
	 * @return the iD
	 */
	public String getID() {
		return ID;
	}

	/**
	 * @return the tEXT
	 */
	public String getTEXT() {
		return TEXT;
	}

}// PropertiesBD
