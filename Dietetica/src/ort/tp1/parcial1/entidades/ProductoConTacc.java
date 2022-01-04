/**
 * 
 */
package ort.tp1.parcial1.entidades;

/**
 * Representa un producto con tacc que puede estar en un pedido
 */
public class ProductoConTacc extends Producto {
	

	private static final String NOMBRE_MOSTRABLE = "Producto Con TACC";
	
	public ProductoConTacc(FamiliaProducto familiaProducto, String nombre, float precio) {
		super(familiaProducto, nombre, precio);
		
	}

	@Override
	public void mostrar() {
		//System.out.println(super.getNombre() + "   " + super.getFamiliaProducto() + "   " + super.getPrecio() + "   " + NOMBRE_MOSTRABLE);
		String familia = super.getFamiliaProducto().toString();
		System.out.printf(FORMATO_RENGLON_CONSOLA,super.getNombre(),familia,super.getPrecio(),NOMBRE_MOSTRABLE);
		
	}

	@Override
	public String toString() {
		/*return "ProductoConTacc [getNombre()=" + getNombre() + ", getPrecio()=" + getPrecio()
				+ ", getFamiliaProducto()=" + getFamiliaProducto() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";*/
		
		return " " + getPrecio();
	}
	
	public String mostrarNombre() {
		return " " + NOMBRE_MOSTRABLE;
	}

}
