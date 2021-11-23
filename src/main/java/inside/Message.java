package inside;

import javax.persistence.*;

@Entity
@Table(name = "Message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private String text;

  /*  @OneToOne(mappedBy = "message")
    private User user;
*/
    public Message(){}

    public Message(String name, String text) {

        this.name = name;
        this.text = text;
    }


    public Message(Long id, String name, String text) {

        this.id = id;
        this.name = name;
        this.text = text;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
