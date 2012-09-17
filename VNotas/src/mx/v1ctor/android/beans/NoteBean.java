
package mx.v1ctor.android.beans;

import java.io.Serializable;

import mx.v1ctor.android.bd.BDObject;
import mx.v1ctor.android.files.PropertiesBD;
import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * @author v1ctor
 * 
 */
@SuppressWarnings("serial")
public class NoteBean implements BDObject, Serializable {

	private long id;
	private String note;
	private boolean flag;

	private SQLiteDatabase sqldb;
	private PropertiesBD pbd;

	public NoteBean(SQLiteDatabase sqldb, PropertiesBD pbd) {
		this.sqldb = sqldb;
		this.pbd = pbd;
	}

	/**
	 * @see mx.v1ctor.android.bd.BDObject#create()
	 */
	public boolean create() {

		try {

			ContentValues values = new ContentValues();
			//values.put(pbd.getID(), id);
			values.put(pbd.getTEXT(), note);

			sqldb.insert(pbd.getTA_NOTES(), null, values);

		} catch (SQLException sql) {
			Log.e("ERROR", sql.getLocalizedMessage());
			return false;
		}
		return true;
	}

	/**
	 * No se hará update sobre SCORE
	 * 
	 * @see mx.v1ctor.android.bd.BDObject#update()
	 */
	public boolean update() {

		// Jamás se hará update sobre la tabla de score
		return false;
	}

	/**
	 * No se borrará sobre SCORE
	 * 
	 * @see mx.v1ctor.android.bd.BDObject#delete()
	 */
	public boolean delete() {

		try {

			sqldb.delete(pbd.getTA_NOTES(), pbd.getID() + "=" + id, null);

		} catch (SQLException sql) {
			Log.e("ERROR", sql.getLocalizedMessage());
			return false;
		}
		return true;
		
	}



	// /////////////////////////////////////////////////////////////////////////////
	// /////////////////////////////////////////////////////////////////////////////

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the note
	 */
	public String getNote() {
		return note;
	}

	/**
	 * @param note the note to set
	 */
	public void setNote(String note) {
		this.note = note;
	}

	/**
	 * @return the flag
	 */
	public boolean isFlag() {
		return flag;
	}

	/**
	 * @param flag the flag to set
	 */
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	

}// SCORE BEAN
