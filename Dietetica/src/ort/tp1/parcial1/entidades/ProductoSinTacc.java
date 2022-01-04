/**
 * 
 */
package ort.tp1.parcial1.entidades;

/**
 * Representa un producto sin tacc
 */
public class ProductoSinTacc extends Producto {

	private static final String NOMBRE_MOSTRABLE = "Producto Sin TACC";
	private String certificadoraSinTac;
	
	public ProductoSinTacc(FamiliaProducto familiaProducto, String nombre, float precio, String certificadoraSinTac) {
		super(familiaProducto, nombre, precio);
		this.setCertificadoraSinTac(certificadoraSinTac);
	}

	
	public String getCertificadoraSinTac() {
		return certificadoraSinTac;
	}

	private void setCertificadoraSinTac(String certificadoraSinTac) {
		this.certificadoraSinTac = certificadoraSinTac;
	}

	@Override
	public void mostrar() {
		//System.out.println(super.getNombre() + "   " + super.getFamiliaProducto() + "   " + super.getPrecio() + "   " + NOMBRE_MOSTRABLE);
		String familia = super.getFamiliaProducto().toString();
		System.out.printf(FORMATO_RENGLON_CONSOLA,super.getNombre(),familia,super.getPrecio(),NOMBRE_MOSTRABLE);;
	}


	@Override
	public String toString() {
		return " " + getPrecio();
	}

	public String mostrarNombre() {
		return " " + NOMBRE_MOSTRABLE;
	}


}
