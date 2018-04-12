
package DatabaseOperation;


public interface CRUDOperations {
    
    public void delete(String userName, String email, String password);
    public void create(String firstName1, String lastName1, String userName1, String password1, String email, String city1, String found1);
    public void update(String firstName1, String lastName1, String userName1, String password1, String email, String city1, String found1);
    public boolean existInDb(String userName, String password);
}
