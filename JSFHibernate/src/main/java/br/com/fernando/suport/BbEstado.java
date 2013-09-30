package br.com.fernando.suport;

import br.com.fernando.model.dao.HibernateDAO;
import br.com.fernando.model.dao.InterfaceDAO;
import br.com.fernando.model.entitie.Estado;
import br.com.fernando.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "bbEstado")
@RequestScoped
public class BbEstado implements Serializable {
    private static final long serialVersionUID = 1L;
     
    
    public List<Estado> getEstados(){
        InterfaceDAO<Estado> estadoDAO = new HibernateDAO<Estado>(Estado.class, FacesContextUtil.getRequestSession());
        List<Estado> listaEstados = estadoDAO.getEntities();
        return listaEstados;
    }
}
