package br.com.fernando.suport;

import br.com.fernando.model.dao.HibernateDAO;
import br.com.fernando.model.dao.InterfaceDAO;
import br.com.fernando.model.entitie.TipoLogradouro;
import br.com.fernando.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class BbTipoLogradouro  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public List<TipoLogradouro> getTipoLogradouro(){
        InterfaceDAO<TipoLogradouro> tipoLogradouroDAO = new HibernateDAO<TipoLogradouro>(TipoLogradouro.class, FacesContextUtil.getRequestSession());
        return tipoLogradouroDAO.getEntities();
    
    }
    
}
