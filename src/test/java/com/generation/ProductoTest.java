package com.generation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductoTest
{
    @Test
    void precioDebeSerElMismoDelConstructor()
    {
        //El precio de un producto es el que se pasó al constructor
        Producto producto = new Producto("Pizza Peperoni",
                12000, 10);

        assertEquals(12000, producto.getPrecio());
    }

    @Test
    void stockMayorACeroEstaDisponible()
    {
        /* Un producto con stock mayor a cero está disponible
          (estaDisponible() devuelve true).*/
        Producto producto = new Producto("Taco",
                85000, 5);
        assertTrue(producto.estaDisponible());
    }

    @Test
    void stockIgualCeroNoDisponible()
    {
        //Un producto con stock igual a cero no está disponible.
        Producto producto = new Producto("Hamburguesa Especial", 3000, 0);
        assertFalse(producto.estaDisponible());
    }

    @Test
    void reducirStockCantidadValida()
    {
        //Después de reducir el stock en una cantidad válida, el stock disminuye correctamente.
        Producto producto = new Producto("Ramen Mexicano", 40000, 5);
        producto.reducirStock(2);
        assertEquals(3, producto.getStock());
    }

    @Test
    void reducirStockMasDisponible()
    {
        //Intentar reducir el stock más de lo disponible lanza IllegalArgumentException.
        Producto producto = new Producto("Cafe Capuchino", 4000, 5);
        assertThrows(IllegalArgumentException.class, () -> producto.reducirStock(10));
    }

    @Test
    void productoPrecioNegativo()
    {
        //Crear un producto con precio negativo lanza IllegalArgumentException.
        assertThrows(IllegalArgumentException.class, () ->
                new Producto("Helado Choco cono", -2500, 10));
    }


    //Prueba libre
    @Test
    void crearProductoConStockNegativoLanzaExcepcion()
    {
        // ¿Qué comportamiento están probando?
        // Probar que el constructor no permita crear un producto con stock inicial menor a cero.

        // ¿Qué aserción van a usar y por qué?
        // assertThrows, porque el código de producción lanza IllegalArgumentException ante valores negativos.

        // ¿Qué valor esperan obtener?
        // Que se capture la excepción correctamente y la prueba pase a verde.

        assertThrows(IllegalArgumentException.class, () ->
                new Producto("Libro Galaxia", 45000, -1));
    }
}