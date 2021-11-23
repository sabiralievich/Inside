package inside.service;

import inside.dao.Message;
import inside.model.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataPostService {

    @Autowired
    MessageRepository messageRepository;

    public void postMessage(Message message) {
        messageRepository.save(message);
        System.out.println("Saved");
    }

    public List<Message> getLastTen() {

        return messageRepository.findWithPageable(PageRequest.of(0, 10, Sort.Direction.DESC, "id"));


    }
}
