package br.com.fernando.controller;

import br.com.fernando.model.dao.HibernateDAO;
import br.com.fernando.model.dao.InterfaceDAO;
import br.com.fernando.model.entitie.Cidade;
import br.com.fernando.model.entitie.Endereco;
import br.com.fernando.model.entitie.Pessoa;
import br.com.fernando.util.FacesContextUtil; 
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class MbPessoa  implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Pessoa pessoa = new Pessoa();
    private Endereco endereco = new Endereco();
    
    private List<Cidade> cidades;
    private List<Endereco> enderecos;
    
    public MbPessoa(){}
    
    private InterfaceDAO<Pessoa> pessoaDAO(){
        InterfaceDAO<Pessoa> pessoaDAO = new HibernateDAO<Pessoa>(Pessoa.class, FacesContextUtil.getRequestSession());
        return pessoaDAO;
    }
    
    private InterfaceDAO<Endereco> enderecoDAO(){
        InterfaceDAO<Endereco> enderecoDAO = new HibernateDAO<Endereco>(Endereco.class, FacesContextUtil.getRequestSession());
        return enderecoDAO;
    }

    private InterfaceDAO<Cidade> cidadeDAO(){
        InterfaceDAO<Cidade> cidadeDAO = new HibernateDAO<Cidade>(Cidade.class, FacesContextUtil.getRequestSession());
        return cidadeDAO;
    }
         
    
    public String limpPessoa(){
        this.pessoa = new Pessoa();
        this.endereco = new Endereco();
        return this.editPessoa();
    }

    public String editPessoa(){
        return "/restrict/cadastrarpessoa.faces";
    }

    public void addPessoa() {
        
        if (pessoa.getIdPessoa()== null || pessoa.getIdPessoa()== 0) {
            pessoa.setDataDeCadastro( new Date());
            insertPessoa();
        } else {
            updatePessoa();
        }
        limpPessoa();
        
    }
 
    private void insertPessoa() {
        this.pessoaDAO().save(pessoa);
        endereco.setPessoa(pessoa);
        this.enderecoDAO().save(endereco);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravação efetuada com sucesso", ""));
        
    }

    private void updatePessoa() {
        pessoaDAO().update(pessoa);
        enderecoDAO().update(endereco);
        FacesContext.getCurrentInstance().addMessage(null,
        new FacesMessage(FacesMessage.SEVERITY_INFO, "Alteração efetuada com sucesso", ""));
    }

    private void delete(){
        enderecoDAO().remove(endereco);
        pessoaDAO().remove(pessoa);
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Cidade> getCidades() {
        cidades = cidadeDAO().getEntities();
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    public List<Endereco> getEnderecos() {
        enderecos = enderecoDAO().getEntities();
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
}
