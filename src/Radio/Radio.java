/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Radio;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Ana Lucía Hernández (17138). Mario Sarmientos (17055)
 **/
public class Radio implements iradio {
    
    private boolean estado;
    private int[] AM;
    private float[] FM;
    private float[] botonesAM;
    private float[] botonesFM;
    private boolean estadoAM;
    private boolean estadoFM;
    private float ultimaEstacionFM;
    private float ultimaEstacionAM;
    
    public Radio()
    {
        this.ultimaEstacionFM = (float) 87.9;
        ultimaEstacionAM = (float) 530.0;
        estadoAM = true;
        estadoFM = false;
        AM = new int[109];
        FM = new float[101];
        botonesAM = new float[12];
        botonesFM = new float[12];
        int emisorasAM = 530;
        for (int i =0; i<109; i++)
        {
            AM[i] = emisorasAM;
            emisorasAM += 10;
        }
        float emisorasFM = (float) 87.9;
        for (int i =0; i < 101; i++)
        {
            FM[i] = emisorasFM;
            emisorasFM += 0.20;
            //Cambio de formato a un solo decimal.
            DecimalFormat unDecimal = new DecimalFormat(".#");
            emisorasFM = Float.parseFloat(unDecimal.format(emisorasFM));
        }
    }
    /** 
     * Metodo que enciende la radio si esta apagada, y la apaga si esta encendida. 
     */
    @Override
    public void onOff()
    {
        if (this.estado == true)
        {
            this.estado = false;
        }
        if (this.estado == false)
        {
            this.estado = true;
        }
        
    }
    /**
     * Metodo que se utilizara para cambiar radio AM a FM y viceversa
     * @return la ultima estacion de la emisora
     */
    @Override
    public float Switch()
    {
       float ultimaEstacion = (float) 0.0;
       if (this.estadoAM == true)
       {
            this.estadoAM = false; 
            this.estadoFM = true;
           ultimaEstacion = ultimaEstacionAM;
            
       }
       else if (this.estadoFM == true)
       {
           this.estadoFM = false; 
           this.estadoAM = true; 
           ultimaEstacion = ultimaEstacionFM;
       }
       return ultimaEstacion;
    }
    /**
     * Metodo para cambiar a una estación anterior
     * @param a: Estación actual 
     * @return: la estacion siguiente en el array de estaciones
     */
    @Override
    public float siguiente(float a)
    {
        float emisoraSiguiente = 0;
        if (estadoAM == false)
        {
            for (int i =0; i<109; i++)
            {	
                if (AM[i] == Integer.parseInt(String.valueOf(a).substring(0, String.valueOf(a).indexOf("."))))
                {   
                    if(i == 108)
                    {
                        emisoraSiguiente = (float) 530.0;
                        ultimaEstacionAM = emisoraSiguiente;
                    }
                    else 
                    {
                        emisoraSiguiente = AM[i+1];
                        ultimaEstacionAM = emisoraSiguiente;
                    }
                }
            }
        }
        if (estadoFM == false)
        {
            for (int i =0; i < 101; i++)
            {
                if (FM[i] == a)
                {
                    if (i == 100)
                    {
                        emisoraSiguiente = (float)87.9;
                        ultimaEstacionFM = emisoraSiguiente;
                    }
                    else 
                    {
                        emisoraSiguiente = FM[i+1];
                        ultimaEstacionFM = emisoraSiguiente;
                    }
                    
                }
            }
        }
        return emisoraSiguiente;
    }
    public float anterior(float a)
    { 
        float emisoraAnterior =0;
        if (estadoAM == false)
        {
            for (int i =0; i<109; i++)
            {
                if (AM[i] == Integer.parseInt(String.valueOf(a).substring(0, String.valueOf(a).indexOf("."))))
                {
                    if (i == 0){
                        i=108;
                        emisoraAnterior = AM[i];
                        ultimaEstacionAM = emisoraAnterior;
                    }
                    else 
                    {
                        emisoraAnterior = AM[i-1];
                        ultimaEstacionAM = emisoraAnterior;
                    }
                }
            }
        }
        if (estadoFM == false)
        {
            for (int i =0; i < 101; i++)
            {
                if (FM[i] == a)
                {
                    if (i == 0){
                        i = 100;
                        emisoraAnterior = FM[i];
                        ultimaEstacionFM = emisoraAnterior;
                    }
                    else 
                    {
                        emisoraAnterior = FM[i-1];
                        ultimaEstacionFM = emisoraAnterior;
                    }
                }
            }
        }
        return emisoraAnterior;
    }
    /**
     * Metodo para guardar una estacion como favorita en alguno de los botones
     * @param e: estacion actual - la que se quiere guardar
     * @param b: boton en el cual se desea guardar la estacion
     */
    public void guardar(float e, int b) //en el GUI, b tiene que ser el numero que da el usuario -1
    {
        for (int i=0; i<12; i++)
        {
            if (i == b)
            {
                if (e>500)
                {
                    botonesAM[i] = e;
                }
                else
                {
                    botonesFM[i] = e;
                }
            }
        }
    }
    /**
     * Metodo para seleccionar un boton en el cual se ha guardado como favorita una estacion 
     * @param b: el boton que se esta seleccionando
     * @return: estacion que tiene guardada en dicho boton
     */
    public float seleccionarFav(int b)
    {
        float emisora = 0;
        for (int i=0; i<12; i++)
        {
            if (i == b)
            {
                if (estadoAM == false)
                {
                    emisora = botonesAM[i];
                }
                else
                {
                    emisora = botonesFM[i];
                }
            }
        }
        return emisora;
    }
}