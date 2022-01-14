package DAW.lope.tienda.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProductosComprasId implements Serializable {

	private static final long serialVersionUID = -646454952592380157L;

	@Column(name = "id_Compra")
    private int id_Compra;
 
    @Column(name = "id_Producto")
    private int id_Producto;
    
    public ProductosComprasId(){}
 
    public ProductosComprasId(int id_Compra, int id_Producto) {
        this.id_Compra = id_Compra;
        this.id_Producto = id_Producto;
    }

	public int getId_Compra() {
		return id_Compra;
	}

	public void setId_Compra(int id_Compra) {
		this.id_Compra = id_Compra;
	}

	public int getId_Producto() {
		return id_Producto;
	}

	public void setId_Producto(int id_Producto) {
		this.id_Producto = id_Producto;
	}
    
}
