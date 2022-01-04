/**
 * 
 */
package ort.tp1.parcial1.entidades;

import java.util.ArrayList;

/**
 * Clase que contiene un pedido generado.
 */
public class Pedido implements Certificable , Mostrable{

	/*
	 * Completar atributos
	 */
	
	private ArrayList<Integer> cantidadList;
	private ArrayList<Producto> productoList;
	private TipoPedido tipo;

	public Pedido(TipoPedido tipo) {
		this.setTipo(tipo);
		this.cantidadList = new ArrayList<>();
		this.productoList = new ArrayList<>();
	}

	public TipoPedido getTipo() {
		return tipo;
	}

	private void setTipo(TipoPedido tipo) {
		this.tipo = tipo;
	}



	/**
	 * Permite agregar un producto al pedido
	 * 
	 * @param producto El {@link Producto} a agregar.
	 * @param cantidad La cantidadd del {@link Producto} a agregar
	 */
	public void agregarProducto(Producto producto, Integer cantidad) {

		// buscar si el producto esta sumar cantidades
		//		si no esta agregarlo
		
		agregarProductoALista(producto);
		int p = buscarProducto(producto);
		
		if(p>-1) {
			this.cantidadList.add(cantidad);
			//System.out.println("Se agrego producto al pedido");
		}else {
			//System.out.println("No se agrego el producto");
		}
	}
	
	private void agregarProductoALista(Producto producto) {
		this.productoList.add(producto);
	
	}

	/**
	 * Saca un producto del pedido.
	 * 
	 * @param producto El {@link Producto} a sacar del pedido
	 * @param cantidad Cantidad del {@link Producto} a sacar del pedido
	 */
	public void sacarProducto(Producto producto, int cantidadASacar) {
		int p = buscarProducto(producto);
		
		if(p>-1) {
			int cant = cantidadProducto(producto);
			if(cant <= cantidadASacar) {
				this.productoList.remove(producto);
				this.cantidadList.remove(p);
			}else {
				cant = cant - cantidadASacar;
				this.cantidadList.set(p, cant);
			}
		}
	}

	/**
	 * Devuelve el indice del producto buscado en la lista.
	 * 
	 * @param p {@link Producto}
	 * @return El indice >= 0 si encuentra el producto y -1 si no lo encuentra
	 */
	private int buscarProducto(Producto p) {
		int idx = -1;
		Producto encontrado = null;
		Producto act;
		int i = 0;
		
		while(i < this.productoList.size() && encontrado == null) {
			act = this.productoList.get(i);
			
			if(act == p) {
				encontrado = act;
				idx = i;
				
			}else {
				i++;
			}
		}
		
		return idx;
	}

	/**
	 * Indica la cantidad del producto dado.
	 * 
	 * @param producto {@link Producto} cuya cantidad se desea averiguar
	 * @return {@link Integer} conteniendo la cantidad del producto en el pedido -1
	 *         si no está el producto
	 */
	private int cantidadProducto(Producto producto) {
		
		int cant = -1;
		int p = buscarProducto(producto);
		
		
		if(p >-1){
			cant = this.cantidadList.get(p);
		}
		
		return cant;
	}

	/**
	 * Devuelve una estructura conteniendo las lineas del pedido
	 * 
	 * @return un la estructura conteniendo {@link LineaPedido}s
	 */
	private ArrayList<LineaPedido> getTablaProductosPedidos() {
		
		ArrayList<LineaPedido> tabla = new ArrayList<>();
		
		
		for(int i=0; i<this.productoList.size(); i++) {
			Producto p = this.productoList.get(i);
			int c = this.cantidadList.get(i) ;
			
			LineaPedido lp = new LineaPedido(p,c);
			
			tabla.add(lp);
			lp.mostrar();
		}
		
		return tabla;
	}

	/**
	 * // * Calcula el importe del pedido
	 * 
	 * @return {@link Float} conteniendo el importe del pedido
	 */
	private float calcularImportePedido() {

		float importe = 0;
		
		for(Producto p : this.productoList) {
			importe = importe + (p.getPrecio()*cantidadProducto(p));
		}
		return importe;
	}

	@Override
	public void mostrar() {
		
		System.out.printf( FORMATO_ENCABEZADO_CONSOLA, "Cantidad ", "Nombre ", "Tipo de Producto ","Precio unitario ", "Tipo producto");
		getTablaProductosPedidos();
		System.out.println("-------------------------------------------");
		boolean cert = isCertificadoSinTACC();
		if(cert == true) {
			System.out.println("Es certificado sin TACC");
		}else {
			System.out.println("El pedido NO es certificado sin TACC");
		}
		System.out.println("-------------------------------------------");
		System.out.println("El importe total del pedido es: " + calcularImportePedido());
	}

	@Override
	public boolean isCertificadoSinTACC() {
		boolean certificado = true;
		int cant = 0;
		for(Producto p : this.productoList) {
			if(p instanceof ProductoConTacc) {
				cant ++;
			}
		}
		if(cant != 0) {
			certificado = false;
		}
		return certificado;
	}

}
