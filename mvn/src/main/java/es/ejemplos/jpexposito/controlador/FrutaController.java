package es.ejemplos.jpexposito.controlador;

import es.ejemplos.jpexposito.api.Fruta;
import es.ejemplos.jpexposito.excepcion.PersistenciaException;
import es.ejemplos.jpexposito.excepcion.FrutaException;
import es.ejemplos.jpexposito.modelo.FrutaModelo;

/**
 * Controlador de la clase Fruta
 */
public class FrutaController {

   private static final String LA_FRUTA_INDICADA_NO_EXISTE = "La fruta indicada NO existe";
   FrutaModelo frutaModelo;

   public FrutaController() {
      frutaModelo = new FrutaModelo();
   }

   /**
    * Metodo encargado de realizar la validacion del objeto fruta
    * 
    * @param fruta a validar
    * @throws FrutaException con el mensaje descriptivo de lo que sucede
    */
   public void validarFruta(Fruta fruta) throws FrutaException {
      String mensaje = "";

      if (fruta == null) {
         mensaje = "Se esta validando un objeto nulo de fruta";
         throw new FrutaException(mensaje);
      }
      if (fruta.getIdentificador() == null || fruta.getIdentificador().isEmpty()) {
         mensaje = "El identidicador de la fruta es nulo o vacio, ";
      }

      if (fruta.getNombre() == null || fruta.getNombre().isEmpty()) {
         mensaje += "El nombre de la fruta es nulo o vacio, ";
      }

      if (fruta.getCoste() < 0) {
         mensaje += "El coste de la fruta es 0 o menor, ";
      }
      if (fruta.getPrecio() < 0) {
         mensaje += "El precio de la fruta es 0 o menor.";
      }
      if (!mensaje.isEmpty()) {
         throw new FrutaException(mensaje);
      }
   }

   /**
    * Metodo encargado de insertar
    * @param fruta a insertar
    * @throws FrutaException con mensaje controlado
    * @throws PersistenciaException
    */
   public void insertar(Fruta fruta) throws FrutaException, PersistenciaException {
      validarFruta(fruta);
      if (existe(fruta)) {
         throw new FrutaException("La fruta indicada ya existe");
      }
      frutaModelo.insertar(fruta); 
   }

   /**
    * Metodo encargado de eliminar
    * @param fruta a eliminar
    * @throws FrutaException
    * @throws PersistenciaException
    */
   public void eliminar(Fruta fruta) throws FrutaException, PersistenciaException {
      validarFruta(fruta);
      if (!existe(fruta)) {
         throw new FrutaException(LA_FRUTA_INDICADA_NO_EXISTE);
      }
      frutaModelo.eliminar(fruta); 
   }

   /**
    * Meotod encargado de realiza la eliminacion de una fruta
    * @param identificador del elemento a eliminar
    * @throws FrutaException controlada con el error
    * @throws PersistenciaException
    */
   public void eliminar(String identificador) throws FrutaException, PersistenciaException {
      Fruta fruta;
      fruta = buscar(identificador);
      eliminar(fruta);
   }

   /**
    * Metodo encargado de buscar por identificador
    * @param identificador para localizar la fruta
    * @return fruta a traves del identificador
    * @throws PersistenciaException
    */
   public Fruta buscar(String identificador) throws PersistenciaException {
      Fruta fruta = null;
      fruta = frutaModelo.buscar(identificador);
      return fruta;
   }

   /**
    * Metodo encargado de realizar la modificacion de una fruta
    * @param fruta a modficar
    * @throws FrutaException controlada en caso de error
    * @throws PersistenciaException
    */
   public void modificar(Fruta fruta) throws FrutaException, PersistenciaException {
      
      validarFruta(fruta);
      if (!existe(fruta)) {
         throw new FrutaException(LA_FRUTA_INDICADA_NO_EXISTE);
      }
      frutaModelo.modificar(fruta);
   }

   /**
    * Funcion encargada de verificar si existe la fruta
    * @param fruta a encontrar
    * @return true/false
    * @throws PersistenciaException error controlado
    */
   private boolean existe(Fruta fruta) throws PersistenciaException {
     boolean encontrada = false;
     Fruta frutaEncontrada;

     frutaEncontrada = buscar(fruta.getIdentificador());
     if (frutaEncontrada != null) {
        encontrada = true;
     }  
     return encontrada;
   }


   

}
