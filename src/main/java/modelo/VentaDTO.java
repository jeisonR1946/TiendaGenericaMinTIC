package modelo;

public class VentaDTO {
	private int codigo_venta;
	private int cedula_cliente;
	private int cedula_usuario;
	private double iva_venta;
	private double total_venta;
	private double valor_venta;
	
	

	
	

	public VentaDTO(int cedula_usuario, int cedula_cliente) {

		this.cedula_usuario = cedula_usuario;
		this.cedula_cliente = cedula_cliente;
	}
	

	public VentaDTO(int codigo_venta, int cedula_cliente, int cedula_usuario, double iva_venta, double total_venta,
			double valor_venta) {

		this.codigo_venta = codigo_venta;
		this.cedula_cliente = cedula_cliente;
		this.cedula_usuario = cedula_usuario;
		this.iva_venta = iva_venta;
		this.total_venta = total_venta;
		this.valor_venta = valor_venta;
	}

	public int getCodigo_venta() {
		return codigo_venta;
	}

	public void setCodigo_venta(int codigo_venta) {
		this.codigo_venta = codigo_venta;
	}

	public int getCedula_cliente() {
		return cedula_cliente;
	}

	public void setCedula_cliente(int cedula_cliente) {
		this.cedula_cliente = cedula_cliente;
	}

	public int getCedula_usuario() {
		return cedula_usuario;
	}

	public void setCedula_usuario(int cedula_usuario) {
		this.cedula_usuario = cedula_usuario;
	}

	public double getIva_venta() {
		return iva_venta;
	}

	public void setIva_venta(double iva_venta) {
		this.iva_venta = iva_venta;
	}

	public double getTotal_venta() {
		return total_venta;
	}

	public void setTotal_venta(double total_venta) {
		this.total_venta = total_venta;
	}

	public double getValor_venta() {
		return valor_venta;
	}

	public void setValor_venta(double valor_venta) {
		this.valor_venta = valor_venta;
	}

}
