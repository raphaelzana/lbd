package model.entidade;

public class UsuarioSorteio {
	
	private int idUser;
	private int idSorteio;
	
	public UsuarioSorteio() {
		
	}
	
	public UsuarioSorteio(int idUser, int idSorteio) {
		super();
		this.idUser = idUser;
		this.idSorteio = idSorteio;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdSorteio() {
		return idSorteio;
	}

	public void setIdSorteio(int idSorteio) {
		this.idSorteio = idSorteio;
	}

	@Override
	public String toString() {
		return "UsuarioSorteio [idUser=" + idUser + ", idSorteio=" + idSorteio + "]";
	}
	
	
	

}
