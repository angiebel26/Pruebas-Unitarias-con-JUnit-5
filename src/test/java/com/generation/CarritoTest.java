package com.generation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarritoTest
{
    @Test
    void carritoRecienCreadoVacio()
    {
        //Un carrito recién creado está vacío.
        Carrito carrito = new Carrito();
        assertTrue(carrito.estaVacio());
    }

    @Test
    void agregarProductoCantidadProductosEs1()
    {
        //Después de agregar un producto, la cantidad de productos es 1.
        Carrito carrito = new Carrito();
        Producto producto = new Producto("Arepa feliz", 2500, 1);

        carrito.agregar(producto);
        assertEquals(1, carrito.cantidadDeProductos());
    }

    @Test
    void totalCarritoConDosProductosEsLaSumaDePrecios()
    {
        //El total de un carrito con dos productos es la suma de sus precios.
        Carrito carrito = new Carrito();
        Producto producto1 = new Producto("Producto 1", 5500, 2);
        Producto producto2 = new Producto("Producto 2", 2500, 2);

        carrito.agregar(producto1);
        carrito.agregar(producto2);

        assertEquals(8000, carrito.calcularTotal());
    }

    @Test
    void carritoConAlMenosUnProductoNoVacio()
    {
        Carrito carrito = new Carrito();
        Producto producto = new Producto("Pollo feliz", 10500, 10);

        carrito.agregar(producto);
        assertFalse(carrito.estaVacio());
    }

    @Test
    void totalCarritoVacioEs0()
    {
        Carrito carrito = new Carrito();
        assertEquals(0, carrito.cantidadDeProductos());
    }
}
