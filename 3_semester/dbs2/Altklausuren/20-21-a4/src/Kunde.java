@Entity @Table(name = "E_Kunde")
public class Kunde {
	@Id @GeneratedValue @Column(name = "A_ID")
	private int ID;
	@Column(name = "A_name")
	private String name;
	@OneToMany(mappedBy = "kunde") @Column(name = "A_journeys")
	private Set<Journey> journeys = new HashSet<Journey>();
}