/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Radio;

/**
 *
 * @author Ana Lucía Hernández (17138). Mario Sarmientos (17055)
 **/
public class Radio implements douglas {
    
    private boolean estado;
    private int[] AM;
    private float[] FM;
    private float[] botones;
    private boolean estadoAM;
    private boolean estadoFM;
    
    public Radio()
    {
        int emisorasAM = 530;
        for (int i =0; i<108; i++)
        {
            AM[i] = emisorasAM;
            emisorasAM += 10;
        }
        float emisorasFM = (float) 87.9;
        for (int i =0; i < 100; i++)
        {
            FM[i] = emisorasFM;
            emisorasFM += 10;
        }
    }
    /** 
     * Metodo que enciende la radio si esta apagada, y la apaga si esta encendida. 
     */
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
     * 
     */
    public void Switch()
    {
       if (this.estadoAM == true){
			this.estadoAM = false; 
			this.estadoFM = true;
	   }
	   if (this.estadoFM ==  true){
		   this.estadoFM = false; 
		   this.estadoAM = true; 
	   }
    }
    /**
     * Metodo para cambiar a una estación anterior
     * @param a: Estación actual 
     * @return: la estacion siguiente en el array de estaciones
     */
    public float siguiente(float a)
    {
        float emisoraSiguiente =0;
        if (estadoAM == true)
        {
            for (int i =0; i<108; i++)
            {	
				
                if (AM[i] == Integer.parseInt(String.valueOf(a)))
                {   
					if(i == 107){
						i = 0;
					}
					else 
					{
						emisoraSiguiente = AM[i++];
					}
                    
                }
            }
        }
        if (estadoAM == true)
        {
            for (int i =0; i < 100; i++)
            {
                if (FM[i] == a)
                {
					if ( i == 99){
						i = 0;
					}
					else {
						emisoraSiguiente = FM[i++];
					}
                    
                }
            }
        }
        return emisoraSiguiente;
    }
    public float anterior(float a)
    { 
        float emisoraAnterior =0;
        if (estadoAM == true)
        {
            for (int i =0; i<108; i++)
            {
                if (AM[i] == Integer.parseInt(String.valueOf(a)))
                {
                    emisoraAnterior = AM[i--];
                }
            }
        }
        if (estadoAM == true)
        {
            for (int i =0; i < 100; i++)
            {
                if (FM[i] == a)
                {
                    emisoraAnterior = FM[i--];
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
                botones[i] = e;
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
                emisora = botones[i];
            }
        }
        return emisora;
    }
}
