@Enitity @Table(name = "E_Journey")
public class Journey {
	@Id @GeneratedValue @Column(name = "A_ID")
	private int ID;
	@Column(name = "A_name")
	private String name;
	@ManyToOne @Column(name = "A_kunde")
	private Kunde kunde;
}