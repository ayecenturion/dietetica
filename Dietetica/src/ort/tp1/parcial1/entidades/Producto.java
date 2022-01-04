/**
 * 
 */
package ort.tp1.parcial1.entidades;

/**
 * Un producto
 */
public abstract class Producto implements Mostrable{

	/**
	 * Atributos, Completar
	 */
	private String nombre;
	private float precio;
	private FamiliaProducto familiaProducto;
	private static float DESCUENTO_POR_MAYOR = 10;
	/**
	 * Constructor del pedido, recibe sus atributos como parámetro
	 * 
	 * @param familiaProducto {@link FamiliaProducto}
	 * @param nombre          {@link String} con el nombre
	 * @param precio          {@link Float} con su precio
	 */
	public Producto(FamiliaProducto familiaProducto, String nombre, float precio) {
		this.setNombre(nombre);
		this.setPrecio(precio);
		this.setFamiliaProducto(familiaProducto);
	}
	

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return precio;
	}

	private void setPrecio(float precio) {
		this.precio = precio;
	}
	
	public float getPrecio(TipoPedido tipoPedido) {
		float porc = (DESCUENTO_POR_MAYOR * this.precio) / 100;
		float nvoPrecio = 0;
		if(tipoPedido == TipoPedido.POR_MAYOR) {
			nvoPrecio = this.precio + porc;
		}
		
		return nvoPrecio;
	}

	public FamiliaProducto getFamiliaProducto() {
		return familiaProducto;
	}

	public void setFamiliaProducto(FamiliaProducto familiaProducto) {
		this.familiaProducto = familiaProducto;
	}

	@Override
	public String toString() {
		return " " + nombre + " " + familiaProducto;
	}

	

}
