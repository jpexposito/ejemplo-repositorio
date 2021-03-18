package es.ejemplos.jpexposito;

import java.util.ArrayList;

public class Lista {

   ArrayList<String> elementos = null;

   /**
    * Constructor por defecto de la clase
    */
   public Lista() {
      elementos = new ArrayList<>();
   }

   /**
    * Metodo encargado de insertar un elemento en el arrayList
    * @param dato elemento a insertar
    */
   public void insertar(String dato) {
      elementos.add(dato);
   }

   /**
    * Funcion que verifica si la lista contiene el dato
    * @param dato a encontrar
    * @return boolean con encontrado si/no
    */
   public boolean existe(String dato) {
      return elementos.contains(dato);
   }
   
}
