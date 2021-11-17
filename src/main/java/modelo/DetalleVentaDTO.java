package modelo;

public class DetalleVentaDTO {

	private int codigo_detalle_venta;
	private int cantidad_producto;
	private int codigo_producto;
	private int codigo_venta;
	private double valor_total;
	private double valor_renta;
	private double valor_iva;

	public int getCodigo_detalle_venta() {
		return codigo_detalle_venta;
	}

	public void setCodigo_detalle_venta(int codigo_detalle_venta) {
		this.codigo_detalle_venta = codigo_detalle_venta;
	}

	public int getCantidad_producto() {
		return cantidad_producto;
	}

	public void setCantidad_producto(int cantidad_producto) {
		this.cantidad_producto = cantidad_producto;
	}

	public int getCodigo_producto() {
		return codigo_producto;
	}

	public void setCodigo_producto(int codigo_producto) {
		this.codigo_producto = codigo_producto;
	}

	public int getCodigo_venta() {
		return codigo_venta;
	}

	public void setCodigo_venta(int codigo_venta) {
		this.codigo_venta = codigo_venta;
	}

	public double getValor_total() {
		return valor_total;
	}

	public void setValor_total(double valor_total) {
		this.valor_total = valor_total;
	}

	public double getValor_renta() {
		return valor_renta;
	}

	public void setValor_renta(double valor_renta) {
		this.valor_renta = valor_renta;
	}

	public double getValor_iva() {
		return valor_iva;
	}

	public void setValor_iva(double valor_iva) {
		this.valor_iva = valor_iva;
	}

	public DetalleVentaDTO(int codigo_detalle_venta, int cantidad_producto, int codigo_producto, int codigo_venta,
			double valor_total, double valor_renta, double valor_iva) {

		this.codigo_detalle_venta = codigo_detalle_venta;
		this.cantidad_producto = cantidad_producto;
		this.codigo_producto = codigo_producto;
		this.codigo_venta = codigo_venta;
		this.valor_total = valor_total;
		this.valor_renta = valor_renta;
		this.valor_iva = valor_iva;
	}

	public DetalleVentaDTO(int cantidad_producto, int codigo_producto, int codigo_venta, double valor_total,
			double valor_renta, double valor_iva) {

		this.cantidad_producto = cantidad_producto;
		this.codigo_producto = codigo_producto;
		this.codigo_venta = codigo_venta;
		this.valor_total = valor_total;
		this.valor_renta = valor_renta;
		this.valor_iva = valor_iva;
	}

}
