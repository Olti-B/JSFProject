package Login;

import DatabaseOperation.CRUDOperations;
import DatabaseOperation.CRUDOperationsImpl;
import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean(name="register")
public class RegisterAccountInDB {
    CRUDOperations crud = new CRUDOperationsImpl();
    ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();      
    
    private String firstName = "";
    private String lastName ="";
    private String userName ="";
    private String password ="";
    private String email ="";
    private String city ="";
    private String found ="";
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setFound(String found) {
        this.found = found;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName=firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getUserName() {
        return userName;
    }
    public String getPassword() {
        return password;
    }
    public String getEmail() {
        return email;
    }
    public String getCity() {
        return city;
    }
    public String getFound() {
        return found;
    }

 
    public void insertCredentions() throws IOException {
        if(crud.existInDb(getUserName(), getPassword())){
            externalContext.redirect("http://localhost:8080/JsfPage/faces/SomthingWentWrong.xhtml");
        }else{
         crud.create(getFirstName(),getLastName(), getUserName(), getPassword(), getEmail(), getCity(), getFound());
         externalContext.redirect("http://localhost:8080/JsfPage/faces/MainPage.xhtml");
        }
    }

  
}
