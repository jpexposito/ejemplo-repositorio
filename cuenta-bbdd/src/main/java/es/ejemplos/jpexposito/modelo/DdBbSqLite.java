package es.ejemplos.jpexposito.modelo;

import es.ejemplos.jpexposito.exception.PersistenciaException;

public class DdBbSqLite extends DdBb {
   private static final String DRIVER = "org.sqlite.JDBC";
   private static final String URL  = "jdbc:sqlite:test.db";
   
   public DdBbSqLite(String driver, String urlConexion, String usuario, String password) throws PersistenciaException {
      super(driver, urlConexion, usuario, password);
   }

   public DdBbSqLite(String usuario, String password) throws PersistenciaException {
      super(DRIVER, URL, usuario, password);
   }

  


}
