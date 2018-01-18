/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Radio;

/**
 *
 * @author Ana Lucía Hernández (17138). Mario Sarmientos (17055)
 */
public interface douglas {
    /**
     * Metodo para encender y apagar la radio
     */
    public abstract void onOff();
    /**
     * Metodo para realizar el cambio entre emisoras FM a emisoras AM y viceversa si se desea
     * @return el valor de la nueva estacion cuando se cambia AM a FM
     */
    public abstract float Switch();
    /**
     * Metodo para cambiar frecuencias de emisoras, para pasar de la actual a la frecuencia siguiente
     * @param a: frecuencia de emisora actual;
     * @return frecuencia de emisora que le sigue
     */
    public abstract float siguiente(float a);
    /**
     * Metodo para cambiar frecuencias de emisoras, para pasar de la actual a la frecuencia anterior
     * @param a: frecuencia de emisora actual
     * @return frecuencia de emisora que le precede
     */
    public abstract float anterior(float a);
    /**
     * Metodo para guardar una frencuencia en un boton especifico (como favorito)
     * @param e: frecuencia que se desea guardar
     * @param b: boton en el cual se quiere guardar la frecuencia
     */
    public abstract void guardar(float e, int b);
    /**
     * Metodo para ir a una frecuencia previamente guardada en un boton como favorita
     * @param b: boton que se está presionando
     * @return emisora que contiene el botón
     */
    public abstract float seleccionarFav(int b);
    
}
