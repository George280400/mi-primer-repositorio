package Principal;



public interface IMetodos {
	
	public void guardar(Object Object);
	public Object buscar(int indice, Object Object);
	public void editar(int indice, Object Object);
	public void eliminar(int indice, Object Object);
	public void mostrar();

}
