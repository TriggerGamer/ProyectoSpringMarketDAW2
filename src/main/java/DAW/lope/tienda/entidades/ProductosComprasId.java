package DAW.lope.tienda.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProductosComprasId implements Serializable {

	private static final long serialVersionUID = -646454952592380157L;

	@Column(name = "id_Compra")
    private int idCompra;
 
    @Column(name = "id_Producto")
    private int idProducto;
    
    public ProductosComprasId(){}
 
    public ProductosComprasId(int id_Compra, int id_Producto) {
        this.idCompra = id_Compra;
        this.idProducto = id_Producto;
    }

    
	public int getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

}
