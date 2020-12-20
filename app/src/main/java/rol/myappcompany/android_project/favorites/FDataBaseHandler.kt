package rol.myappcompany.android_project.favorites
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

val DATABASE_NAME = "FavoritesDataBase"
val TABLE_NAME = "Favorites"
val COL_FID = "fid"
val COL_ID = "id"
val COL_NAME = "name"
val COL_IMAGE = "ImgSrcUrl"

class FDataBaseHandler(val context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, 1){ //NULL VALUE IS THE CURSOR FACTORY

    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE " + TABLE_NAME +" (" +
                COL_FID +" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_ID +" INTEGER ," +
                COL_NAME + " TEXT, " +
                COL_IMAGE + " TEXT)"

        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun insertDataFavorites(favorites: Favorites){
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(COL_ID, favorites.id)
        cv.put(COL_NAME, favorites.name)
        //cv.put(COL_IMAGE, favorites.ImgSrcUrl)


        val  result =  db?.insert(TABLE_NAME, null, cv) //insert to the DB
        /*if(result == (-1).toLong())
            //Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        else
            //Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()*/
    }

    fun readDataFavorites() : MutableList<Favorites>{
        val list : MutableList<Favorites> = ArrayList()
        val db = this.readableDatabase
        val query = "SELECT * FROM " + TABLE_NAME
        val result = db.rawQuery(query, null)
        if(result.moveToFirst()){
            do{
                val favorites = Favorites()
                favorites.id = result.getString(result.getColumnIndex(COL_ID)).toInt()
                favorites.name = result.getString(result.getColumnIndex(COL_NAME))
                //favorites.ImgSrcUrl = result.getString(result.getColumnIndex(COL_IMAGE))

                list.add(favorites)
            }while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }

    fun deleteDataFavorites(num: Int){
        val db = this.writableDatabase
        db.delete(TABLE_NAME, COL_ID + "=?", arrayOf(num.toString()))
        db.close()
    }


    fun favoritesCheckedId(num: Int): Boolean {
        val db = this.readableDatabase
        val query = "SELECT * FROM " + TABLE_NAME
        val result = db.rawQuery(query,null)
        if(result.moveToFirst()){
            do{
                if (num == result.getString(result.getColumnIndex(rol.myappcompany.android_project.favorites.COL_ID)).toInt()){
                    return true
                }
            }while (result.moveToNext())
        }
        return false
    }
}