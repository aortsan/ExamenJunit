/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.sql.Date;
import java.time.LocalDate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alvaro
 */
public class PedidosDaoTest {

    static PedidosDao pedidos = new PedidosDao();
    static Pedido pedidoPrueba = new Pedido(null, 6, 1, Date.valueOf("2020-06-15"), Date.valueOf("2020-06-16"), null, 1, new BigDecimal(20.20), "Agustin de Iturbide", "4", "Madrid", null, "28043", "España");

    public PedidosDaoTest() {
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
     * Test of read method, of class PedidosDao.
     */
    @Test
    public void testRead() {
        System.out.println("read");

        Integer idPedido = 1;
        Pedido expResult = null;
        Pedido result = pedidos.read(idPedido);
        assertEquals(expResult, result);

        idPedido = 11053;
        result = pedidos.read(idPedido);
        assertEquals(idPedido, result.getId());

        idPedido = -1;
        expResult = null;
        result = pedidos.read(idPedido);
        assertEquals(expResult, result);

        idPedido = 11077;
        expResult = new Pedido(11077, 65, 1, Date.valueOf("1998-05-06"), Date.valueOf("1998-06-03"), null, 2, new BigDecimal(8.5300), "Rattlesnake Canyon Grocery", "2817 Milton Dr.", "Albuquerque", "NM", "87110", "Estados Unidos");
        result = pedidos.read(idPedido);
        assertEquals(expResult.getFechaEnvio(), result.getFechaEnvio());
    }

    /**
     * Test of insert method, of class PedidosDao.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");

        Pedido pedido = null;
        Integer expResult = null;
        Integer result = pedidos.insert(pedido);
        assertEquals(expResult, result);

        pedido = new Pedido(11077, 65, 1, Date.valueOf("1998-05-06"), Date.valueOf("1998-06-03"), null, 2, new BigDecimal(8.5300), "Rattlesnake Canyon Grocery", "2817 Milton Dr.", "Albuquerque", "NM", "87110", "Estados Unidos");
        result = pedidos.insert(pedido);
        assertNotEquals(pedido.getId(), result);

        expResult = 11080;
        result = pedidos.insert(pedidoPrueba);
        assertEquals(expResult, result);
        pedidos.delete(expResult);
    }

    /**
     * Test of update method, of class PedidosDao.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        
        Pedido pedido = null;
        Integer expResult = null;
        Integer result = pedidos.update(pedido);
        assertEquals(expResult, result);
        
        pedidos.insert(pedidoPrueba);
        pedidoPrueba.setCargo(new BigDecimal(34.150));
        expResult = 1;
        result = pedidos.update(pedidoPrueba);
        assertEquals(expResult, result);
    }

    /**
     * Test of delete method, of class PedidosDao.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        
        Integer idPedido = -1;
        Integer expResult = 1;
        Integer result = pedidos.delete(idPedido);
        assertNotEquals(expResult, result);
        
        idPedido = 11083;
        expResult = 1;
        result = pedidos.delete(idPedido);
        assertNotEquals(expResult, result);
    }

    /**
     * Test of listar method, of class PedidosDao.
     */
    @Test
    public void testListar() {
        System.out.println("listar");
        
        Integer posicion = 1;
        Pedido expResult = new Pedido(10692,1,4,Date.valueOf("1997-10-03"),Date.valueOf("1997-10-31"),Date.valueOf("1997-10-13"),2,new BigDecimal(61.0200),"Alfreds Futterkiste","Obere Str. 57","Berlín",null,"12209","Alemania");
        ArrayList<Pedido> result = pedidos.listar(posicion);
        assertEquals(expResult.getId(), result.get(0).getId());
        
        expResult = new Pedido(10365,3,3,Date.valueOf("1996-11-27"),Date.valueOf("1996-12-25"),Date.valueOf("1996-12-02"),2,new BigDecimal(22.0000),"Antonio Moreno Taquería","Mataderos  2312","México D.F.",null,"05023","México");
        assertEquals(expResult.getId(), result.get(9).getId());
        
        posicion = 0;
        expResult = new Pedido(10643,1,6,Date.valueOf("1997-08-25"),Date.valueOf("1997-09-22"),Date.valueOf("1997-09-02"),2,new BigDecimal(29.4600),"Alfreds Futterkiste","Obere Str. 57","Berlín",null,"12209","Alemania");
        result = pedidos.listar(posicion);
        assertEquals(expResult.getId(), result.get(0).getId());
        
        posicion = -1;
        result = pedidos.listar(posicion);
        assertEquals (new ArrayList(), result);
    }

}
