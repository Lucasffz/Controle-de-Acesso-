public abstract class User  {
	String nome;
	String matricula;
	String curso;
	Laboratorio laboratorio;
	String senha;

	User(String nome,String matricula,String curso, Laboratorio laboratorio,String senha){
		this.nome = nome;
		this.matricula = matricula;
		this.curso = curso;
		this.laboratorio = laboratorio;
		this.senha = senha;
	}
	
	User(){
		
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public Laboratorio getLaboratorio() {
		return laboratorio;
	}
	public void setLaboratorio(Laboratorio laboratorio) {
		this.laboratorio = laboratorio;
	}
	
	
	
}
