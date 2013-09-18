package br.com.fernando.model.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="pessoa")
public class Pessoa implements Serializable{

    private static final long serialVersionUID = 1L;

    public Pessoa(){}
    
    @Id
    @GeneratedValue
    @Column(name="idPessoa", nullable = false )
    private Integer idPessoa;
    
    @Column(name="nmNome", length = 50, nullable = false)
    private String nome;
    
    @Column(name="dsEmail", length = 50, nullable = false)
    private String email;
    
    @Column(name="nuTelefone", length = 15, nullable = false) //(011)99999-9999
    private String telefone;
    
    @Column(name="nuCpf", length = 14, nullable = false) //999.999.999-99
    private String cpf;
    
    @Column(name="dtNasc", nullable = false) 
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    
    @Column(name="dtCad", nullable = false) 
    @Temporal(TemporalType.DATE)
    private Date dataCadastro;

    @ManyToOne(optional = false)
    @ForeignKey(name = "pessoaSexo")
    @JoinColumn(name="IdSexo", referencedColumnName = "IdSexo")
    private Sexo sexo;    

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }


        @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (this.idPessoa != null ? this.idPessoa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (this.idPessoa != other.idPessoa && (this.idPessoa == null || !this.idPessoa.equals(other.idPessoa))) {
            return false;
        }
        return true;
    }

}
