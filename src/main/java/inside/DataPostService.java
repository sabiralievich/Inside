package inside;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class DataPostService {

    @Autowired
    MessageRepository messageRepository;
    public void postMessage(Message message) {
        messageRepository.save(message);
        System.out.println("Saved");
    }

    public Message getLastTen() {
     //   System.out.println(messageRepository.getLastTen("testmessage2", "d").getText());
        //messageRepository.findWithPageable(new PageRequest(0, 2, Sort.Direction.DESC, "id"));
        return new Message(messageRepository.getLastTen("testmessage2", "d").getName(), messageRepository.getLastTen("testmessage2", "d").getText());

    }
}
