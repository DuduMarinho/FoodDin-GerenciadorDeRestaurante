public abstract class Pessoa {
  private String nome;
  private String telefone;
  private String email;
  private String documento;
  public Pessoa(String nome, String telefone, String email, String documento) {
      this.nome = nome;
      this.telefone = telefone;
      this.email = email;
      this.documento = documento;
  }

  public String getNome() { return nome; }
  public void setNome(String nome) { this.nome = nome; }
  public String getTelefone() { return telefone; }
  public void setTelefone(String telefone) { this.telefone = telefone; }
  public String getEmail() { return email; }
  public void setEmail(String email) { this.email = email; }
  public String getDocumento() { return documento; }
  public void setDocumento(String documento) { this.documento = documento; }
}
