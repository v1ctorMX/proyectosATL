package mx.v1ctor.android.bd;

import java.io.IOException;

import mx.v1ctor.android.files.FileBD;
import mx.v1ctor.android.vnotas.R;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * @author v1ctor
 * 
 */
public class BDOpenHelper extends SQLiteOpenHelper {

	private FileBD fileBD;
	private Context context;
	private String assetName = "";

	/**
	 * Obtenemos la conexión a la base de datos de SQLite
	 * 
	 * @param context
	 */
	public BDOpenHelper(Context context) {
		
		super(
				context, 
				context.getString(R.string.bd_baseDB) ,
				null, 
				Integer.parseInt(context.getString(R.string.bd_version))
				);
		this.context = context;
		this.assetName = context.getString(R.string.bd_baseSQL);
	}

	/**
	 * @see android.database.sqlite.SQLiteOpenHelper#onCreate(android.database.sqlite.SQLiteDatabase)
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		try {
			this.fileBD = new FileBD(context, assetName);

			String archivoEnCadena = this.fileBD.getFile();
			db.execSQL(archivoEnCadena);
			
			Log.d("CREATE DATABASE", "done");

		} catch (IOException ioe) {
			Log.e("ERROR", ioe.getLocalizedMessage());
		}

	}// Crea la base de datos.

	/**
	 * @see android.database.sqlite.SQLiteOpenHelper#onUpgrade(android.database.sqlite.SQLiteDatabase,
	 *      int, int)
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
		Log.e("UPDATE DATABASE", "no se actualizó la BD pues no hay manejo para ello");
	}

}
