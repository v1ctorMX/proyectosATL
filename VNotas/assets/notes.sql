
/*    Crea las tablas de configuración. 
 *    Víctor Miguel Peralta Santa Anna    V.1 
 */ 
CREATE TABLE NOTES ( 
    nIdNote	INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, 
    tNOTE	TEXT    NOT NULL, 
    CHECK (tNOTE > 0)
); 

