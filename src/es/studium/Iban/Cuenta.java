package es.studium.Iban;

public class Cuenta
{
	String Entidad;
	String Sucursal;
	String Dc;
	String NCuenta;
	
	public Cuenta(String entidad, String sucursal, String dc, String nCuenta)
	{
		super();
		Entidad = entidad;
		Sucursal = sucursal;
		Dc = dc;
		NCuenta = nCuenta;
	}
	
	public String getEntidad()
	{
		return Entidad;
	}

	public void setEntidad(String entidad)
	{
		Entidad = entidad;
	}

	public String getSucursal()
	{
		return Sucursal;
	}

	public void setSucursal(String sucursal)
	{
		Sucursal = sucursal;
	}

	public String getDc()
	{
		return Dc;
	}

	public void setDc(String dc)
	{
		Dc = dc;
	}

	public String getNCuenta()
	{
		return NCuenta;
	}

	public void setNCuenta(String nCuenta)
	{
		NCuenta = nCuenta;
	}
}
