package Principal;
// voy a utilizar mi clase object: la clase raiz de todas las clases
// si se usa un hashmap o una lista por ejemplo hashmap
// la clave como el valor puede ser de cualquier tipo de datos
public interface IMetodos {
	
	public void guardar(Object key, Object value);
	public void editar(Object key, Object value);
	public void eliminar(Object key);
	public Object buscar(Object key);
	public void mostrar();

}
