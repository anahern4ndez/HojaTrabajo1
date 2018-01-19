/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Radio;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author anahernandez
 */
public class RadioTest {
    
    public RadioTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of onOff method, of class Radio.
     */
    @Test
    public void testOnOff() {
        System.out.println("onOff");
        Radio instance = new Radio();
        instance.onOff();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of Switch method, of class Radio.
     */
    @Test
    public void testSwitch() {
        System.out.println("Switch");
        Radio instance = new Radio();
        float expResult = 530.0F;
        float result = instance.Switch();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        if (result != expResult)
        {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of siguiente method, of class Radio.
     */
    @Test
    public void testSiguiente() {
        System.out.println("siguiente");
        float a = 87.9F;
        Radio instance = new Radio();
        float expResult = 88.1F;
        float result = instance.siguiente(a);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        if (result != expResult)
        {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of anterior method, of class Radio.
     */
    @Test
    public void testAnterior() {
        System.out.println("anterior");
        float a = 88.1F;
        Radio instance = new Radio();
        float expResult = 87.9F;
        float result = instance.anterior(a);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        if (result != expResult)
        {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of guardar method, of class Radio.
     */
    @Test
    public void testGuardar() {
        System.out.println("guardar");
        float e = 130.5F;
        int b = 2;
        Radio instance = new Radio();
        instance.guardar(e, b);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of seleccionarFav method, of class Radio.
     */
    @Test
    public void testSeleccionarFav() {
        System.out.println("seleccionarFav");
        int b = 2;
        Radio instance = new Radio();
        float expResult = 0.0F;
        float result = instance.seleccionarFav(b);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        if (result != expResult)
        {
            fail("The test case is a prototype.");
        }
    }
    
}
