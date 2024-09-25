package l14_hibernate_mapping.one2many;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="cart-o2m-annotation")
public class Cart {
	
	@Id
	@Column(name="id")
	@GeneratedValue
	private int id;
	@Column(name="total")
	private int total;
	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy = "cart",cascade = CascadeType.PERSIST)
	private Set<Items> items;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Items> getItems() {
		return items;
	}
	public void setItems(Set<Items> items) {
		this.items = items;
	}
	public Cart(int id, int total, String name, Set<Items> items) {
		super();
		this.id = id;
		this.total = total;
		this.name = name;
		this.items = items;
	}
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
