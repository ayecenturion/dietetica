/**
 * 
 */
package ort.tp1.parcial1.entidades;

/**
 * Línea de un pedido, incluye el producto y la cantidad del mismo
 */
public class LineaPedido implements Mostrable {

//completar atributos
	
	private Producto producto;
	private int cantidad;

	/**
	 * Constructor de la entidad
	 * 
	 * @param producto {@link Producto} contenido en la línea.
	 * @param cantidad {@link Integer} representando la cantidad de producto de la
	 *                 línea
	 */
	public LineaPedido(Producto producto, int cantidad) {
		this.setProducto(producto);
		this.setCantidad(cantidad);
	}

	public Producto getProducto() {
		return producto;
	}

	private void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	private void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}



	/**
	 * Devuelve le precio de una linea de pedido
	 * 
	 * @param tipo {@link TipoPedido} para calular el precio
	 * @return {@link Float} con el precio de la línea
	 */
	public float getPrecioLineaPedido(TipoPedido tipo) {
		
		return this.producto.getPrecio(tipo);
	}

	/**
	 * Agraga la cantidad indicada de producto a la {@link LineaPedido}
	 * 
	 * @param cantidad {@link Integer} con la cantidad a agregar (debe ser positivo,
	 *                 si no, no agrega)
	 */
	public void adicionarCantidad(int cantidad) {
		
		int nvaCant = this.cantidad + cantidad;
		setCantidad(nvaCant);
	}

	@Override
	public void mostrar() {
		//System.out.println(" ");
		//System.out.printf(this.toString(),FORMATO_RENGLON_CONSOLA);
		System.out.printf("%d",this.cantidad);
		this.producto.mostrar();
	}

	@Override
	public String toString() {
		return  " " + cantidad;
	}
	
	
}
