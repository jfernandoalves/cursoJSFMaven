package br.com.fernando.suport;

import br.com.fernando.model.dao.HibernateDAO;
import br.com.fernando.model.dao.InterfaceDAO;
import br.com.fernando.model.entitie.TipoEndereco;
import br.com.fernando.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "bbTipoEndereco")
@RequestScoped
public class BbTipoEndereco  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public List<TipoEndereco> getTipoEndereco(){
        InterfaceDAO<TipoEndereco> tipoEnderecoDAO = new HibernateDAO<TipoEndereco>(TipoEndereco.class, FacesContextUtil.getRequestSession());
        return tipoEnderecoDAO.getEntities();
    }
}
