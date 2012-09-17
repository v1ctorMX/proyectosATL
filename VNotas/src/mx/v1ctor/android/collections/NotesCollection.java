package mx.v1ctor.android.collections;

import java.util.LinkedList;

import mx.v1ctor.android.bd.BDCollection;
import mx.v1ctor.android.bd.BDObject;
import mx.v1ctor.android.beans.NoteBean;
import mx.v1ctor.android.files.PropertiesBD;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Clase que permite obtener todos los registros acumulados en el score de la bd
 * 
 * @author v1ctor
 * @since Septiembre 2012
 */
public class NotesCollection implements BDCollection {

	private SQLiteDatabase sqldb;
	private PropertiesBD pbd;
	
	/**
	 * @param sqldb
	 */
	public NotesCollection(SQLiteDatabase sqldb, PropertiesBD pbd) {
		this.sqldb = sqldb;
		this.pbd = pbd;
	}

	/**
	 * @see mx.v1ctor.android.bd.BDCollection#count()
	 */
	public long count() {

		long cantidad = -1;

		try {
			Cursor cursor = sqldb
					.query(pbd.getTA_NOTES(), new String[] { "COUNT("
							+ pbd.getID()+ ")" }, null, null,
							null, null, null);

			cursor.moveToFirst();
			cantidad = cursor.getLong(0);
			cursor.close();

		} catch (SQLException sqle) {
			Log.e("ERROR", sqle.getLocalizedMessage());
		}
		return cantidad;

	}

	/**
	 * @see mx.v1ctor.android.bd.BDCollection#retrieveN(long)
	 */
	public LinkedList<BDObject> retrieveN(long count) {

		LinkedList<BDObject> lista = new LinkedList<BDObject>();

		try {
			Cursor cursor = sqldb.query(pbd.getTA_NOTES(), new String[] {
					pbd.getID(), pbd.getTEXT() }, null, null, null, null, null,
					count + "");

			cursor.moveToFirst();
			do {

				long id = cursor.getLong(0);
				String text = cursor.getString(1);

				NoteBean nb = new NoteBean(sqldb,pbd);
				nb.setId(id);
				nb.setNote(text);

				lista.add(nb);

			} while (cursor.moveToNext());
			cursor.close();

		} catch (SQLException sqle) {
			Log.e("ERROR", sqle.getLocalizedMessage());
		}

		return lista;
	}

	/**
	 * @see mx.v1ctor.android.bd.BDCollection#retrieve(long)
	 */
	public BDObject retrieve(long id) {
		// Nos interesa mostrar TODAS las notas limitadas en una cantidad, no
		// registro por registro.
		return null;
	}

}
