package modelo;

public class ProductoDTO {
	
	private int codigo_producto;
	private double iva_compra;
	private int nit_proveedor;
	private String nombre_producto;
	private double precio_compra;
	private double precio_venta;
	private double subtotal;	
	private int cantidad;
	
	
	
	
	
	

	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public ProductoDTO(int codigo_producto,int cantidad) {

		this.codigo_producto = codigo_producto;
		this.cantidad = cantidad;
	}
	

	public ProductoDTO(int codigo_producto, double subtotal) {

		this.codigo_producto = codigo_producto;
		this.subtotal = subtotal;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	
	
	

	public ProductoDTO(int codigo_producto, double iva_compra, int nit_proveedor, String nombre_producto,
			double precio_compra, double precio_venta) {
		
		this.codigo_producto = codigo_producto;
		this.iva_compra = iva_compra;
		this.nit_proveedor = nit_proveedor;
		this.nombre_producto = nombre_producto;
		this.precio_compra = precio_compra;
		this.precio_venta = precio_venta;
	}	
	
	public int getCodigo_producto() {
		return codigo_producto;
	}
	public void setCodigo_producto(int codigo_producto) {
		this.codigo_producto = codigo_producto;
	}
	public double getIva_compra() {
		return iva_compra;
	}
	public void setIva_compra(double iva_compra) {
		this.iva_compra = iva_compra;
	}
	public int getNit_proveedor() {
		return nit_proveedor;
	}
	public void setNit_proveedor(int nit_proveedor) {
		this.nit_proveedor = nit_proveedor;
	}
	public String getNombre_producto() {
		return nombre_producto;
	}
	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}
	public double getPrecio_compra() {
		return precio_compra;
	}
	public void setPrecio_compra(double precio_compra) {
		this.precio_compra = precio_compra;
	}
	public double getPrecio_venta() {
		return precio_venta;
	}
	public void setPrecio_venta(double precio_venta) {
		this.precio_venta = precio_venta;
	}
		

}
