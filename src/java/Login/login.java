package Login;



import DatabaseOperation.CRUDOperations;
import DatabaseOperation.CRUDOperationsImpl;
import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean(name = "validation")

public class login {
     CRUDOperations crud = new CRUDOperationsImpl();
    ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
    
    private String userName = "";
    private String password = "";

    public String getUsername() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void enter() throws IOException{
        if (crud.existInDb(getUsername(), getPassword())){
         externalContext.redirect("http://localhost:8080/JsfPage/faces/MainPage.xhtml");
        }else{
              externalContext.redirect("http://localhost:8080/JsfPage/faces/SomthingWentWrong.xhtml");
        }
       
    }
}
